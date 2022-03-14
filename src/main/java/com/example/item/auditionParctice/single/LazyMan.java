package com.example.item.auditionParctice.single;

/**
 * 懒汉式：线程不安全，一般使用双重检测锁模式 DCL懒汉式
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
                    lazyMan = new LazyMan(); // 不是一个原子性操作 会执行下面的操作
                    /**
                     * 1.分配内存空间
                     * 2.执行构造方法，初始化对象
                     * 3.把这个对象指向这个空间
                     * 会发生指令重排的现象
                     * 如A线程指令重排成了132，然后B线程进来发现对象不为空，但是此时对象并没有被初始化，线程B就取到了一个未初始化的对象，所以一般要用volatile保证指令不被重排
                     */

                }
            }
        }
        return lazyMan;
    }

}
