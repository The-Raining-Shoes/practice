package com.example.item.auditionParctice.mement;

/**
 * <b>(Note)</b>
 *
 * @author Rainy 2023-01-07 22:53:55
 * @version 1.0.0
 */
public class Note {

    private String content;

    public Note(String content) {
        this.content = content;
    }

    public void change(String content) {
        this.content = content;
    }

    public BackUp save() {
        return new BackUp(content);
    }

    public void resume(BackUp back) {
        this.content = back.content;
    }

    public void print() {
        System.out.println(this.content);
    }

}
