package com.example.item;

/**
 * @Author: HXM
 * @Date: 2019/12/27 10:39
 */
public class Ye {

    public static void main(String[] args) {
        Res res = new Res();
        Input input = new Input(res);
        Output output = new Output(res);
        Thread thread1 = new Thread(input, "厂家");
        Thread thread2 = new Thread(output, "卖家");
        thread1.start();
        thread2.start();
    }
}

class Res {
    public String name;
    public String value;
    public boolean flag = false;
}

class Input implements Runnable {
    private Res res;

    Input(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        synchronized (res) {
            if (res.flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            res.name = "丽丽";
            res.value = "男";
            res.flag = true;
            notify();
        }
    }
}

class Output implements Runnable {
    private Res res;

    Output(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        synchronized (res) {
            if (res.flag) {
                System.out.println(res.name + "--------" + res.value);
                res.flag = false;
                try {
                    notify();
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}