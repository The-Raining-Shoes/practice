package com.example.item.auditionParctice.factory.abstroct1;

/**
 * 工厂模式
 */
public class HuaWeiFactory implements IProductFactory{

    @Override
    public IphoneProduct iphoneProduct() {
        return new HuaWeiPhone();
    }

    @Override
    public IRouterProduct iRouterProduct() {
        return new HuaWeiRoute();
    }

}
