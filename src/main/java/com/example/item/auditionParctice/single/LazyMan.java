package com.example.item.auditionParctice.single;

/**
 * 单例模式是可以用枚举来破坏的
 */
public class LazyMan {

    public volatile static LazyMan lazyMan;
    public static boolean qingjiang = false;

    public LazyMan() {
        synchronized (LazyMan.class) {
            if (!qingjiang) {
                qingjiang = true;
            } else {
                throw new RuntimeException("不要试图尝试，兄弟");
            }
        }
    }

    public static LazyMan getInstance() {
        if (lazyMan == null) {
            synchronized (LazyMan.class) {
                if (lazyMan == null) {
                    lazyMan = new LazyMan(); // 不是一个原子性操作
                    /**
                     * 1.分配内存空间
                     * 2.执行构造方法，初始化对象
                     * 3.把这个对象指向这个空间
                     */
                }
            }
        }
        return lazyMan;
    }

}
