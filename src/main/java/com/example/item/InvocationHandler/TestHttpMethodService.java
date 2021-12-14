package com.example.item.InvocationHandler;

import com.example.item.InvocationHandler.annotation.RemoteMethod;
import com.example.item.InvocationHandler.entity.TestHttpMethodDTO;

public interface TestHttpMethodService {

    @RemoteMethod(name = "测试请求", url = "/queryTestMethod", desc = "测试请求描述", urlMethod = "queryTestMethod")
    TestHttpMethodDTO.TestHttpMethodVO queryTestMethod(TestHttpMethodDTO testHttpMethodDTO);
    
}
