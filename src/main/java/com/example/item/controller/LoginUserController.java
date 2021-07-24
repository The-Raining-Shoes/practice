package com.example.item.controller;

import com.example.item.domain.dto.LoginDTO;
import com.example.item.domain.dto.Result;
import com.example.item.exception.ErrorCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登陆测试
 *
 * @author HXM
 * @date 2020年04月22日 9:15
 */
@RestController
@RequestMapping(value = "/login")
public class LoginUserController {

    @PostMapping(value = "/login")
    public Result<Object> login(@RequestBody LoginDTO p) {
        if (p.getUserName().equals("admin") && p.getPassword().equals("ant.design")) {
            return new Result<>(null);
        }
        return new Result<>(ErrorCode.USER_AUTHENTICATION_FAIL, null);
    }

    //仅测试使用
    @GetMapping(value = "/currentUser")
    public Result<LoginDTO> refreshToken() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setName("毛豪");
        loginDTO.setUserId(1);
        return new Result<>(loginDTO);
    }

    @GetMapping(value = "/loginTest")
    public Result<LoginDTO> refreshSToken(@RequestParam String a, @RequestParam String b) {
        System.out.println(a.equals(b));
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setName("毛豪");
        loginDTO.setUserId(1);
        return new Result<>(loginDTO);
    }
}
