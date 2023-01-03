package com.example.item.auditionParctice.adapter;

/**
 * <b>(AdapterImpl)</b>
 * 适配器模式(与代理模式、装饰模式很像，但侧重接口的适用性修改)
 *
 * @author Rainy 2023-01-02 10:00:17
 * @version 1.0.0
 */
public class AdapterImpl extends Speak implements AdapterInterface {

    @Override
    public String translate() {
        // 拿到接口类数据
        String speak = speak();
        // 再做一些其他操作，比如说进行翻译
        System.out.println("翻译：" + speak);
        return speak;
    }

}
