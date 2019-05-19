package com.example.item.repostory;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * @author HXM
 *
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID>{

	/**
	   * 根据对象值查询
	   * 
	   * @param e 对象
	   * @return
	   */
	  List<T> findByEntity(T e);

	  /**
	   * 根据对象值查询带sort参数
	   * 
	   * @param e 对象
	   * @return
	   */
	  List<T> findByEntity(T e, Sort sort);

	  /**
	   * 根据对象值查询
	   * 
	   * @param e 对象
	   * @param page 页码
	   * @param size 分页大小
	   * @return
	   */
	  Page<T> findByEntity(T e, Pageable pageable);

	  /**
	   * 根据对象ID查询
	   * 
	   * @param e 对象
	   * @return
	   */
	  public T findEntityById(ID id);
}
