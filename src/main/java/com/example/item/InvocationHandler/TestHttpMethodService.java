package com.example.item.InvocationHandler;

import com.example.item.InvocationHandler.annotation.RemoteMethod;

public interface TestHttpMethodService {

    @RemoteMethod(name = "测试请求", url = "/queryTestMethod", desc = "测试请求描述", urlMethod = "queryTestMethod", httpMethod = RemoteMethod.HttpMethod.POST)
    TestHttpMethodDTO.TestHttpMethodVO queryTestMethod(TestHttpMethodDTO testHttpMethodDTO, TestHttpMethodDTO test);

}
