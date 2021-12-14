//package com.example.item.elasticJob;
//
//import com.dangdang.ddframe.job.executor.handler.ExecutorServiceHandler;
//import com.dangdang.ddframe.job.executor.handler.JobExceptionHandler;
//import com.dangdang.ddframe.job.executor.handler.impl.DefaultExecutorServiceHandler;
//import com.dangdang.ddframe.job.executor.handler.impl.DefaultJobExceptionHandler;
//import org.springframework.stereotype.Component;
//
//import java.lang.annotation.*;
//
//@Target({ElementType.TYPE})
//@Retention(RetentionPolicy.RUNTIME)
//@Inherited
//@Documented
//@Component
//public @interface JobService {
//    String desc();
//
//    String cron();
//
//    int shardingTotalCount() default 1;
//
//    String shardingItemParameters() default "";
//
//    String jobParameter() default "";
//
//    boolean failover() default false;
//
//    boolean misfire() default false;
//
//    Class<? extends JobExceptionHandler> exceptionHandler() default DefaultJobExceptionHandler.class;
//
//    Class<? extends ExecutorServiceHandler> executorServiceHandler() default DefaultExecutorServiceHandler.class;
//
//    boolean streamingProcess() default false;
//}
