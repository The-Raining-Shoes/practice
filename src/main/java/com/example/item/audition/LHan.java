package com.example.item.audition;

public class LHan {

    public LHan lHan = null;

    public LHan() {

    }

    public LHan getInstance() {
        if (lHan == null) {
            synchronized (LHan.class) {
                if (lHan == null) {
                    lHan = new LHan();
                }
            }
        }
        return lHan;
    }

}
