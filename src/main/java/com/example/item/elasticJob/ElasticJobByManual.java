//package com.example.item.elasticJob;
//
//import com.dangdang.ddframe.job.api.ShardingContext;
//import com.dangdang.ddframe.job.api.simple.SimpleJob;
//import com.dangdang.ddframe.job.config.JobCoreConfiguration;
//import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
//import com.dangdang.ddframe.job.lite.api.JobScheduler;
//import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
//import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
//import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
//import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
//import com.example.item.SomeStuff;
//
//public class ElasticJobByManual implements SimpleJob {
//
//    @Override
//    public void execute(ShardingContext shardingContext) {
//        System.out.println("分片数量" + shardingContext.getShardingTotalCount()
//                + "当前分区" + shardingContext.getShardingItem()
//                + "当前分区名称" + shardingContext.getShardingParameter()
//                + "当前自定义参数" + shardingContext.getJobParameter() + "============SYSTEM=================");
//    }
//
//    public static void main(String[] args) {
//        ZookeeperConfiguration zookeeperConfiguration = new ZookeeperConfiguration("localhost:2181", "elsetic-job");
//        CoordinatorRegistryCenter coordinatorRegistryCenter = new ZookeeperRegistryCenter(zookeeperConfiguration);
//        coordinatorRegistryCenter.init();
//        //配置任务 每秒运行一次
//        JobCoreConfiguration jobCoreConfiguration =
//                JobCoreConfiguration.newBuilder("archive-job", "1 * * * * ? *", 10).build();
//        SimpleJobConfiguration simpleJobConfiguration = new SimpleJobConfiguration(jobCoreConfiguration, SomeStuff.class.getName());
//        //启动任务
//        new JobScheduler(coordinatorRegistryCenter, LiteJobConfiguration.newBuilder(simpleJobConfiguration).build()).init();
//    }
//
//}
