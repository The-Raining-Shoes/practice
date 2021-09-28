package com.example.item.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ZkClientTest {

    ZooKeeper zkCli = null;

    // 初始化客户端
    @Before
    public void init() throws IOException {
        // 回调监听
        String connectString = "localhost:2181";
        int sessionTimeout = 3000;
        zkCli = new ZooKeeper(connectString, sessionTimeout, event -> {
//            try {
//                List<String> children = zkCli.getChildren("/", true);
//                for (String c : children) {
//                    System.out.println(c);
//                }
//            } catch (KeeperException | InterruptedException e) {
//                e.printStackTrace();
//            }
        });
    }

    // 创建子节点
    @Test
    public void createZooNode() throws KeeperException, InterruptedException {
        String path = zkCli.create("/hello", "world".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(path);
    }

    // 获取子节点
    @Test
    public void getChild() throws KeeperException, InterruptedException {
        List<String> children = zkCli.getChildren("/", true);
        System.out.println("——————————");
        for (String c : children) {
            // 监听的具体内容
            byte[] data = zkCli.getData("/" + c, event -> {
                System.out.println("监听路径为：" + event.getPath());
                System.out.println("监听的类型为：" + event.getType());
                System.out.println("监听被修改了！！！");
            }, null);
            System.out.println(new String(data));
            System.out.println(c);
        }
        System.out.println("——————————");
    }

    // 删除节点
    @Test
    public void rmChildData() throws KeeperException, InterruptedException {
        zkCli.delete("/test-job", -1);
    }

    // 修改数据
    @Test
    public void setData() throws KeeperException, InterruptedException {
        zkCli.setData("/hello", "17".getBytes(), -1);
    }

    // 判断节点是否存在
    @Test
    public void testExist() throws KeeperException, InterruptedException {
        Stat exists = zkCli.exists("/test-job", false);
        System.out.println(exists == null ? "not exists" : "exists");
    }

}
