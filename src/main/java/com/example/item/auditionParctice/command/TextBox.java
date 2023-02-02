package com.example.item.auditionParctice.command;

import lombok.Data;

/**
 * <b>(TestContent)</b>
 *
 * @author Rainy 2023-01-06 22:46:00
 * @version 1.0.0
 */
@Data
public class TextBox {

    private String content;

    public TextBox(String content) {
        this.content = content;
    }

}
