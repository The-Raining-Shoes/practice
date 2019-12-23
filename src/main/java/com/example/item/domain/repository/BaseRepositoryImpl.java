/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology
 * Branch. All rights reserved. <a>http://www.crunii.com</a>
 */
package com.example.item.domain.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.Optional;

/**
 * @author tuzy create 2018年9月17日下午5:32:36
 */
@Slf4j
@NoRepositoryBean
public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
    implements JpaRepository<T, ID> {

    protected final EntityManager entityManager;

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

    public T findEntityById(ID id) {
        Optional<T> data = super.findById(id);
        if (data.isPresent()) {
            return data.get();
        }
        return null;
    }


//    public List<T> findByEntity(T e) {
//        return super.findAll(getPredicate(e));
//    }
//
//    public List<T> findByEntity(T e, Sort sort) {
//        return super.findAll(getPredicate(e), sort);
//    }
//
//    public Page<T> findByEntity(T e, Pageable pageable) {
//        return super.findAll(getPredicate(e), pageable);
//    }

    /**
     * @see com.crunii.bss.db.repository.BaseRepository#findByEntity(java.lang.Object,
     * org.springframework.data.jpa.domain.Specification)
     */
//    public List<T> findByEntity(T e, Specification<T> s) {
//        return super.findAll(getPredicate(e).and(s));
//    }


    /**
     * @see com.crunii.bss.db.repository.BaseRepository#findByEntity(java.lang.Object,
     * org.springframework.data.jpa.domain.Specification, org.springframework.data.domain.Sort)
     */
//    public List<T> findByEntity(T e, Specification<T> s, Sort sort) {
//        return super.findAll(getPredicate(e).and(s), sort);
//    }


    /**
     * @see com.crunii.bss.db.repository.BaseRepository#findByEntity(java.lang.Object,
     * org.springframework.data.jpa.domain.Specification,
     * org.springframework.data.domain.Pageable)
     */
//    public Page<T> findByEntity(T e, Specification<T> s, Pageable pageable) {
//        return super.findAll(getPredicate(e).and(s), pageable);
//    }


//    private Specification<T> getPredicate(T e) {
//        return new Specification<T>() {
//            private static final long serialVersionUID = 1L;
//
//            @Override
//            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//                Class<T> cl = getDomainClass();
//                Field[] fields = cl.getDeclaredFields();
//                List<Predicate> ls = new ArrayList<>();
//                for (Field f : fields) {
//                    String name = f.getName();
//                    if ("serialVersionUID".equals(name) || f.isAnnotationPresent(Transient.class) || f
//                        .isAnnotationPresent(Ignore.class)) {
//                        continue;
//                    }
//                    f.setAccessible(true);
//                    Object value = null;
//                    try {
//                        value = f.get(e);
//                    } catch (Exception e1) {
//                        log.debug("获取属性{}值失败！", name);
//                    }
//                    if (value != null && !"".equals(value)) {
//                        if (f.isAnnotationPresent(GreaterThan.class)
//                            && f.getAnnotation(GreaterThan.class).name() != null) {
//                            name = f.getAnnotation(GreaterThan.class).name();
//                        } else if (f.isAnnotationPresent(LessThan.class)
//                            && f.getAnnotation(LessThan.class).name() != null) {
//                            name = f.getAnnotation(LessThan.class).name();
//                        }
//
//                        Path<?> path = root.get(name);
//                        if (path == null) {
//                            continue;
//                        }
//                        if (f.isAnnotationPresent(Like.class)) {
//                            // 处理模糊查询
//                            StringBuffer pattern = new StringBuffer();
//                            Like likeAnnotation = f.getAnnotation(Like.class);
//                            if (likeAnnotation.usePrefix()) {
//                                pattern.append("%");
//                            }
//                            pattern.append(value);
//                            if (likeAnnotation.useSuffix()) {
//                                pattern.append("%");
//                            }
//                            ls.add(criteriaBuilder.like(path.as(String.class), pattern.toString()));
//                        } else if (f.isAnnotationPresent(GreaterThan.class)) {
//                            GreaterThan gtAnnotation = f.getAnnotation(GreaterThan.class);
//                            Predicate predicate = null;
//                            if (gtAnnotation.equal()) {
//                                // 处理大于等于
//                                if (Number.class.isAssignableFrom(path.getJavaType()) && value instanceof Number) {
//                                    predicate = criteriaBuilder.ge(path.as(Number.class), (Number) value);
//                                } else if (Date.class.isAssignableFrom(path.getJavaType()) && value instanceof Date) {
//                                    predicate = criteriaBuilder.greaterThanOrEqualTo(path.as(Date.class), (Date) value);
//                                }
//                            } else {
//                                // 处理大于
//                                if (Number.class.isAssignableFrom(path.getJavaType()) && value instanceof Number) {
//                                    predicate = criteriaBuilder.gt(path.as(Number.class), (Number) value);
//                                } else if (Date.class.isAssignableFrom(path.getJavaType()) && value instanceof Date) {
//                                    predicate = criteriaBuilder.greaterThan(path.as(Date.class), (Date) value);
//                                }
//                            }
//                            if (predicate != null)
//                                ls.add(predicate);
//                        } else if (f.isAnnotationPresent(LessThan.class)) {
//                            LessThan gtAnnotation = f.getAnnotation(LessThan.class);
//                            Predicate predicate = null;
//                            // 处理小于
//                            if (gtAnnotation.equal()) {
//                                // 处理小于等于
//                                if (Number.class.isAssignableFrom(path.getJavaType()) && value instanceof Number) {
//                                    predicate = criteriaBuilder.le(path.as(Number.class), (Number) value);
//                                } else if (Date.class.isAssignableFrom(path.getJavaType()) && value instanceof Date) {
//                                    predicate = criteriaBuilder.lessThanOrEqualTo(path.as(Date.class), (Date) value);
//                                }
//                            } else if (Number.class.isAssignableFrom(path.getJavaType()) && value instanceof Number) {
//                                predicate = criteriaBuilder.lt(path.as(Number.class), (Number) value);
//                            } else if (Date.class.isAssignableFrom(path.getJavaType()) && value instanceof Date) {
//                                predicate = criteriaBuilder.lessThan(path.as(Date.class), (Date) value);
//                            }
//                            if (predicate != null)
//                                ls.add(predicate);
//                        } else {
//                            ls.add(criteriaBuilder.equal(path, value));
//                        }
//                    }
//                }
//                return criteriaBuilder.and(ls.toArray(new Predicate[0]));
//            }
//
//        };
//    }

    /**
     * 多线程执行保存操作 默认60s超时
     *
     * @param entities 保存实体
     * @return List
     */
//    public List<T> batchSave(List<T> entities) {
//        return batchSave(entities, ResConstants.DB_BATCH_UPDATE_TIMEOUT);
//    }

    /**
     * 多线程执行保存操作
     *
     * @param entities 保存实体
     * @param timeout  超时时间
     * @return List
     */
//    public List<T> batchSave(List<T> entities, int timeout) {
//        if (entities.size() <= ResConstants.DB_BATCH_UPDATE_LIMIT) {
//            return saveAll(entities);
//        }
//        PlatformTransactionManager transactionManager = SpringUtil.getBean(PlatformTransactionManager.class);
//        ThreadPoolTaskExecutor es = SpringUtil.getBean(ThreadPoolTaskExecutor.class);
//        @SuppressWarnings("unchecked")
//        List<T> result = Collections.synchronizedList(new ArrayList());
//        CountDownLatch downLatch = BatchUpdateAspect.getDownLatch();
//        AtomicBoolean hasError = BatchUpdateAspect.getError();
//        // 拆分后数据
//        List<List<T>> subList = JdbcUtils.subList(entities);
//        // 线程运行结果集合
//        List<BatchUpdateRunnable> runList = new ArrayList<>();
//        // 多线程结束标志
//        CountDownLatch doneLatch = new CountDownLatch(subList.size());
//        // 提交到线程池
//        subList.forEach(ls -> {
//            BatchUpdateRunnable callable =
//                new BatchUpdateRunnable(transactionManager, doneLatch, downLatch, timeout, hasError, () -> {
//                    for (T entity : ls) {
//                        result.add(save(entity));
//                    }
//                    return null;
//                });
//            es.execute(callable);
//            runList.add(callable);
//        });
//        try {
//            boolean awaitStatus = doneLatch.await(timeout, TimeUnit.SECONDS);
//            if (!awaitStatus) {
//                hasError.set(true);
//                log.error("等待执行超时，回滚事物。");
//                throw new BssRuntimeException(ErrorCode.BSS_DEAL_ERROR, "等待执行超时");
//            }
//        } catch (InterruptedException e) {
//            hasError.set(true);
//            log.error("等待超时", e);
//            throw new BssRuntimeException(ErrorCode.BSS_DEAL_ERROR, "数据更新异常");
//        }
//        runList.forEach((callable) -> {
//            if (callable.getResult() instanceof Exception) {
//                throw new RuntimeException((Exception) callable.getResult());
//            }
//        });
//        return result;
//    }


}
