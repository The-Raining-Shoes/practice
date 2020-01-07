package com.example.item.threadLearning;

/**
 * @Author: HXM
 * @Date: 2020/1/3 16:08
 */
public class ThreadDemo3 {

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
        int i = 1;
        while (true) {
            synchronized (res) {
                if (res.flag) {
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (i % 2 == 0) {
                    res.name = "麦克";
                    res.value = "男";
                    res.flag = true;
                } else {
                    res.name = "丽丽";
                    res.value = "女";
                    res.flag = true;
                }
                i += 1;
                res.flag = true;
                res.notify();
            }
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
        while (true) {
            synchronized (res) {
                if (!res.flag) {
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(res.name + "--------" + res.value);
                res.flag = false;
                res.notify();
            }
        }

    }
}
