package com.example.item.elasticJob;

import com.dangdang.ddframe.job.api.ElasticJob;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.lang.Nullable;

import java.util.Objects;

//@Component
public class JobServiceAutoInitProcessor implements BeanPostProcessor {

    private static final Logger log = LoggerFactory.getLogger(JobServiceAutoInitProcessor.class);

    @Setter(onMethod_ = @Autowired)
    private CoordinatorRegistryCenter coordinatorRegistryCenter;
    @Setter(onMethod_ = @Autowired(required = false))
    private JobEventConfiguration jobEventConfiguration;

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        JobService jobService = AnnotationUtils.findAnnotation(AopUtils.getTargetClass(bean), JobService.class);
        if (jobService != null) {
            this.registerJob(beanName, bean, jobService);
        }
        return bean;
    }

    private void registerJob(String beanName, Object bean, JobService jobService) {
        String className = AopUtils.getTargetClass(bean).getCanonicalName();
        JobCoreConfiguration jobCoreConfiguration = JobCoreConfiguration.newBuilder(beanName, jobService.cron(), jobService.shardingTotalCount()).build();
        if (bean instanceof SimpleJob) {
            log.info("init {}({})", jobService.desc(), className);
            //启动任务
            SimpleJobConfiguration simpleJobConfig = new SimpleJobConfiguration(jobCoreConfiguration, className);
            LiteJobConfiguration.Builder liteJobConfig  = LiteJobConfiguration.newBuilder(simpleJobConfig);
            if (Objects.nonNull(jobEventConfiguration)) {
                new SpringJobScheduler((ElasticJob) bean, coordinatorRegistryCenter, liteJobConfig.build(), jobEventConfiguration).init();
            } else {
                new SpringJobScheduler((ElasticJob) bean, coordinatorRegistryCenter, liteJobConfig.build()).init();
            }
        }
    }

}
