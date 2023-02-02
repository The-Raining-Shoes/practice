package com.example.item.auditionParctice.command;

/**
 * <b>(ExecuteMethod)</b>
 *
 * @author Rainy 2023-01-06 22:51:56
 * @version 1.0.0
 */
public class ExecuteMethod {

    public static void main(String[] args) {
        final TextBox textBox = new TextBox("123");
        PrintCommand printCommand = new PrintCommand(textBox);
        SaveButton saveButton = new SaveButton();
        saveButton.bind(printCommand);
        saveButton.doPrint();
        textBox.setContent("321");
        saveButton.doPrint();
    }

}
