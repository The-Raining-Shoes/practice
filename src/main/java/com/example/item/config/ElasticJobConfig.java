//package com.example.item.config;
//
//import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
//import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
//import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
//import com.example.item.elasticJob.JobZookeeperProperties;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ElasticJobConfig {
//
//    @Bean("JobZookeeperProperties")
//    @ConfigurationProperties(
//            prefix = "job.zookeeper"
//    )
//    public JobZookeeperProperties zookeeperConfiguration() {
//        return new JobZookeeperProperties();
//    }
//
//    @Bean
//    @ConditionalOnMissingBean({CoordinatorRegistryCenter.class})
//    public CoordinatorRegistryCenter coordinatorRegistryCenter(@Qualifier("JobZookeeperProperties") JobZookeeperProperties prop) {
//        ZookeeperConfiguration config = new ZookeeperConfiguration(prop.getServer(), prop.getNamespace());
//        config.setBaseSleepTimeMilliseconds(prop.getBaseSleepTimeMilliseconds());
//        config.setMaxSleepTimeMilliseconds(prop.getMaxSleepTimeMilliseconds());
//        config.setMaxRetries(prop.getMaxRetries());
//        config.setSessionTimeoutMilliseconds(prop.getSessionTimeoutMilliseconds());
//        config.setConnectionTimeoutMilliseconds(prop.getConnectionTimeoutMilliseconds());
//        CoordinatorRegistryCenter coordinatorRegistryCenter = new ZookeeperRegistryCenter(config);
//        coordinatorRegistryCenter.init();
//        return coordinatorRegistryCenter;
//    }
//
//}
