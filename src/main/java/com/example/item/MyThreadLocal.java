package com.example.item;

/**
 * @author HXM
 * @date 2021年01月04日 11:05
 */
public class MyThreadLocal {

    private static ThreadLocal<Context> userThreadLocal;

    public static void set(Context user) {
        if (userThreadLocal == null) {
            System.out.println("新建ThreadLocal对象");
            userThreadLocal = new ThreadLocal<>();
        }
        userThreadLocal.set(user);
    }

    public static Context get() {
        return userThreadLocal.get();
    }

}
