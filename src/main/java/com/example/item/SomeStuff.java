package com.example.item;

import com.example.item.utils.JsonUtil;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 测试数据
 *
 * @author MaoHao
 * @date 2020年04月13日 9:18
 */
@Slf4j
public class SomeStuff {

    public static void main(String[] args) {
        String a = "[{amount=6.00, offerName=七彩铃音}, {amount=0.10, offerName=乐享家流量转短信费用}]";
        List<UserBill> commentList = JsonUtil.fromJson(a, new TypeToken<List<UserBill>>() {
        }.getType());
        System.out.println(commentList);
    }

    @Data
    static class UserBill {
        private double amount;
        private String offerName;
    }

}