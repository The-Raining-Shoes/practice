package com.example.item.method.foreachZip;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author HXM
 * @date 2021年03月05日 10:03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseDTO {

    private String createTime;
    private String fromUser;
    private String content;

}
