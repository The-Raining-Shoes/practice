package com.example.item.auditionParctice.mement;

/**
 * <b>(ExecuteMethod)</b>
 * 备忘录模式
 *
 * @author Rainy 2023-01-07 22:58:42
 * @version 1.0.0
 */
public class ExecuteMethod {

    public static void main(String[] args) {
        Note note = new Note("123");
        History.log(note.save());
        note.change("456");
        History.log(note.save());
        note.change("789");
        History.log(note.save());
        note.change("100");
        note.print();
        note.resume(History.getHis());
        note.print();
    }

}
