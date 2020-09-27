package com.example.item;

import com.example.item.domain.entity.GoodsInfo;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试数据
 *
 * @author HXM
 * @date 2020年04月13日 9:18
 */
@Slf4j
public class SomeStuff {

    public static void main(String[] args) throws IOException {
        List<GoodsInfo> list = new ArrayList<>();
        GoodsInfo goodsInfo = new GoodsInfo();
        goodsInfo.setGoodsName("1");
        GoodsInfo goodsInfo1 = new GoodsInfo();
        goodsInfo1.setGoodsName("2");
        GoodsInfo goodsInfo2 = new GoodsInfo();
        goodsInfo2.setGoodsName("3");
        list.add(goodsInfo);
        list.add(goodsInfo1);
        list.add(goodsInfo2);
        System.out.println(list);
        for (GoodsInfo goodsInfo3 : list) {
            if (goodsInfo3.getGoodsName().equals("1")) {
                list.remove(goodsInfo3);
            } else {
                goodsInfo3.setGoodsStory("啊大苏打倒萨大苏打");
            }
        }
        System.out.println(list);
//        SocketChannel sc = SocketChannel.open();
//        sc.configureBlocking(true);
//        boolean connect = sc.connect(new InetSocketAddress("localhost", 8090));
//        System.out.println("connected:" + connect);
//        ByteBuffer sendByteBuffer = ByteBuffer.allocate(25);
//        sendByteBuffer.flip();
//        sc.read(sendByteBuffer);

    }

}