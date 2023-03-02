package com.example.item.functionDemo;

import lombok.Builder;
import lombok.Data;

/**
 * <b>(TypeClassOne)</b>
 *
 * @author Rainy 2023-02-01 12:08:47
 * @version 1.0.0
 */
@Data
@Builder
public class TypeClassOne {

    private Integer type;

    private String name;

    private String nameTwo;

}
