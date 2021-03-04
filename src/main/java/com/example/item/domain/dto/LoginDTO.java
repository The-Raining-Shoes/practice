package com.example.item.domain.dto;

import lombok.Data;

/**
 * @author HXM
 * @date 2020年04月22日 9:17
 */
@Data
public class LoginDTO {
    private String password;
    private String type;
    private String userName;
    private Integer userId;
    private String name;
    private String avatar = "https://gw.alipayobjects.com/zos/antfincdn/XAosXuNZyF/BiazfanxmamNRoxxVxka.png";
}
