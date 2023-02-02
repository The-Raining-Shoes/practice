package com.example.item.auditionParctice.command;

/**
 * <b>(SaveButton)</b>
 *
 * @author Rainy 2023-01-06 22:47:46
 * @version 1.0.0
 */
public class SaveButton {

    private Command command;

    public void bind(Command command) {
        this.command = command;
    }

    public void doPrint() {
        this.command.execute();
    }

}
