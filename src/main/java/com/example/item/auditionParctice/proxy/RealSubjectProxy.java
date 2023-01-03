package com.example.item.auditionParctice.proxy;

import java.lang.reflect.InvocationTargetException;

/**
 * <b>(RealSubjectPorxy)</b>
 *
 * @author Rainy 2023-01-03 13:29:38
 * @version 1.0.0
 */
public class RealSubjectProxy implements Subject {

    private final RealSubject realSubject;

    public RealSubjectProxy() {
        try {
            this.realSubject = (RealSubject) this.getClass().getClassLoader().loadClass("com.example.item.auditionParctice.proxy.RealSubject").getConstructor().newInstance();
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException |
                 ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void connect() {
        System.out.println("代理连接");
    }

    private void log() {
        System.out.println("代理日志");
    }

    @Override
    public void doWork() {
        connect();
        realSubject.doWork();
        log();
    }


}
