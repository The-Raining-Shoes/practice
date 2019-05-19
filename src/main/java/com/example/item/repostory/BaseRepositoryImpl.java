package com.example.item.repostory;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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


	@Override
	public List<T> findByEntity(T e) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<T> findByEntity(T e, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Page<T> findByEntity(T e, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*	public List<T> findByEntity(T e) {
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
						log.debug("获取属性{}值失败！", name);
					}
					if (value != null && !"".equals(value)) {
						Path<?> path = root.get(name);
						if (path == null) {
							continue;
						}
						if (f.isAnnotationPresent(Like.class)) {
							// 处理模糊查询
							StringBuffer pattern = new StringBuffer();
							Like likeAnnotation = f.getAnnotation(Like.class);
							if (likeAnnotation.usePrefix()) {
								pattern.append("%");
							}
							pattern.append(value);
							if (likeAnnotation.useSuffix()) {
								pattern.append("%");
							}
							ls.add(criteriaBuilder.like(path.as(String.class), pattern.toString()));
						} else if (f.isAnnotationPresent(GreaterThan.class)) {
							GreaterThan gtAnnotation = f.getAnnotation(GreaterThan.class);
							if (gtAnnotation.equal()) {
								// 处理大于等于
								if (Number.class.isAssignableFrom(path.getJavaType()) && value instanceof Number) {
									criteriaBuilder.ge(path.as(Number.class), (Number) value);
								} else if (Date.class.isAssignableFrom(path.getJavaType()) && value instanceof Date) {
									criteriaBuilder.greaterThanOrEqualTo(path.as(Date.class), (Date) value);
								}
							} else {
								// 处理大于
								if (Number.class.isAssignableFrom(path.getJavaType()) && value instanceof Number) {
									criteriaBuilder.gt(path.as(Number.class), (Number) value);
								} else if (Date.class.isAssignableFrom(path.getJavaType()) && value instanceof Date) {
									criteriaBuilder.greaterThan(path.as(Date.class), (Date) value);
								}
							}

						} else if (f.isAnnotationPresent(LessThan.class)) {
							LessThan gtAnnotation = f.getAnnotation(LessThan.class);
							if (gtAnnotation.equal()) {
								// 处理小于等于
								if (Number.class.isAssignableFrom(path.getJavaType()) && value instanceof Number) {
									criteriaBuilder.le(path.as(Number.class), (Number) value);
								} else if (Date.class.isAssignableFrom(path.getJavaType()) && value instanceof Date) {
									criteriaBuilder.lessThanOrEqualTo(path.as(Date.class), (Date) value);
								}
							} else {
								// 处理小于
								if (Number.class.isAssignableFrom(path.getJavaType()) && value instanceof Number) {
									criteriaBuilder.lt(path.as(Number.class), (Number) value);
								} else if (Date.class.isAssignableFrom(path.getJavaType()) && value instanceof Date) {
									criteriaBuilder.lessThan(path.as(Date.class), (Date) value);
								}
							}
						} else {
							ls.add(criteriaBuilder.equal(path, value));
						}
					}
				}
				return criteriaBuilder.and(ls.toArray(new Predicate[ls.size()]));
			}

		};
	}*/

}