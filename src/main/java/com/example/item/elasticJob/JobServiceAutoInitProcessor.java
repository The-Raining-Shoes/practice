//package com.example.item.elasticJob;
//
//import com.dangdang.ddframe.job.api.simple.SimpleJob;
//import com.dangdang.ddframe.job.config.JobCoreConfiguration;
//import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
//import com.dangdang.ddframe.job.lite.api.JobScheduler;
//import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
//import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
//import lombok.Setter;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.aop.support.AopUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.core.annotation.AnnotationUtils;
//import org.springframework.lang.Nullable;
//import org.springframework.stereotype.Component;
//
//@Component
//public class JobServiceAutoInitProcessor implements BeanPostProcessor {
//
//    private static final Logger log = LoggerFactory.getLogger(JobServiceAutoInitProcessor.class);
//
//    @Setter(onMethod_ = @Autowired)
//    private CoordinatorRegistryCenter coordinatorRegistryCenter;
//
//    @Nullable
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) {
//        JobService jobService = AnnotationUtils.findAnnotation(AopUtils.getTargetClass(bean), JobService.class);
//        if (jobService != null) {
//            this.registerJob(beanName, bean, jobService);
//        }
//        return bean;
//    }
//
//    private void registerJob(String beanName, Object bean, JobService jobService) {
//        String className = AopUtils.getTargetClass(bean).getCanonicalName();
//        JobCoreConfiguration jobCoreConfiguration = JobCoreConfiguration.newBuilder(beanName, jobService.cron(), jobService.shardingTotalCount()).build();
//        if (bean instanceof SimpleJob) {
//            log.info("init {}({})", jobService.desc(), className);
//            //启动任务
//            SimpleJobConfiguration simpleJobConfiguration = new SimpleJobConfiguration(jobCoreConfiguration, className);
//            new JobScheduler(coordinatorRegistryCenter, LiteJobConfiguration.newBuilder(simpleJobConfiguration).build()).init();
//        }
//    }
//
//}
