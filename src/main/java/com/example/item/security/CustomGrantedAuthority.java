package com.example.item.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
public class CustomGrantedAuthority implements GrantedAuthority {

    /**
     * 权限编码
     */
    private String privCode;

    @Override
    public String getAuthority() {
        return this.privCode;
    }

}
