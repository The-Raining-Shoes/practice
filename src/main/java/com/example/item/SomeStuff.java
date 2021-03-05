package com.example.item;

import com.example.item.domain.dto.LoginDTO;
import com.example.item.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 测试数据
 *
 * @author MaoHao
 * @date 2020年04月13日 9:18
 */
@Slf4j
public class SomeStuff {

    public static void main(String[] args) {
        String a = "{\n" +
                   "    \"password\": 1,\n" +
                   "    \"type\": 1,\n" +
                   "    \"userName\": \"测试\"\n" +
                   "}";
        LoginDTO loginDTO = JsonUtil.fromJson(a, LoginDTO.class);
        System.out.println(loginDTO);
    }

}