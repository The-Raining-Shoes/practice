package com.example.item.repostory;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
		implements BaseRepository<T, ID> {

	protected final EntityManager entityManager;

	// 父类没有不带参数的构造方法，这里手动构造父类
	public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
		this.entityManager = entityManager;
	}
	

	/**
	 * @param entityInformation
	 * @param entityManager
	 */
	public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

	public void evict(T entity) {
		entityManager.detach(entity);
	}
	
	public T findEntityById(ID id) {
	    Optional<T> data = super.findById(id);
	    if(data.isPresent()) {
	        return data.get();
	    }
	    return null;
	}

	public List<T> findByEntity(T e) {
		return super.findAll(getPredicate(e));
	}

	public List<T> findByEntity(T e, Sort sort) {
		return super.findAll(getPredicate(e), sort);
	}

	public Page<T> findByEntity(T e, Pageable pageable) {
		return super.findAll(getPredicate(e), pageable);
	}


	private Specification<T> getPredicate(T e) {
		return new Specification<T>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				Class<T> cl = getDomainClass();
				Field[] fields = cl.getDeclaredFields();
				List<Predicate> ls = new ArrayList<>();
				for (Field f : fields) {
					String name = f.getName();
					if ("serialVersionUID".equals(name)) {
						continue;
					}
					f.setAccessible(true);
					Object value = null;
					try {
						value = f.get(e);
					} catch (Exception e1) {
					}
					if (value != null && !"".equals(value)) {
						Path<?> path = root.get(name);
						if (path == null) {
							continue;
						}
						 else {
							ls.add(criteriaBuilder.equal(path, value));
						}
					}
				}
				return criteriaBuilder.and(ls.toArray(new Predicate[ls.size()]));
			}

		};
	}

}