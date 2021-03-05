package com.example.item.domain.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * @author HXM
 * @date 2020年04月22日 9:17
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginDTO implements Serializable {
    private static final long serialVersionUID = 7895199923008942197L;

    @JsonAlias({"passAge"})
    private String password;
    private String type;
    private String userName;
    private Integer userId;
    private String name;
    private String avatar = "https://gw.alipayobjects.com/zos/antfincdn/XAosXuNZyF/BiazfanxmamNRoxxVxka.png";
}
