package com.example.item.method.interfaceParam;

/**
 * <b>(MethodImpl)</b>
 *
 * @author Rainy 2022-12-06 15:22:17
 * @version 1.0.0
 */
public class MethodImpl {

    public <T> T execute(Execute<T> action) {
        StaticClass staticClass = new StaticClass();
        return action.doTest(staticClass);
    }

}
