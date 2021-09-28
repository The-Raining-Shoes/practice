package com.example.item.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

public class MyZookeeperWatcher implements Watcher {

    @Override
    public void process(WatchedEvent event) {
        if(event.getState()== Event.KeeperState.SyncConnected){
            System.out.println("---->>>>>"+event.getType());
            System.out.println("---->>>>>"+event.getPath());
        }
    }

}
