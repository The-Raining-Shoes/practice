package com.example.item.auditionParctice.command;

/**
 * <b>(PrintCommand)</b>
 *
 * @author Rainy 2023-01-06 22:49:20
 * @version 1.0.0
 */
public class PrintCommand implements Command {

    public PrintService printService = new PrintService();
    private final TextBox textBox;

    public PrintCommand(TextBox textBox) {
        this.textBox = textBox;
    }

    @Override
    public void execute() {
        printService.print(textBox.getContent());
    }

}
