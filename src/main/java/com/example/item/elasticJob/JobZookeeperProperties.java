package com.example.item.elasticJob;

import lombok.Data;

@Data
public class JobZookeeperProperties {

    private String server;
    private String namespace;
    private int baseSleepTimeMilliseconds = 1000;
    private int maxSleepTimeMilliseconds = 3000;
    private int maxRetries = 3;
    private int sessionTimeoutMilliseconds;
    private int connectionTimeoutMilliseconds;

}
