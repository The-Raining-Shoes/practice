package com.example.item;

import com.example.item.InvocationHandler.TestHttpMethodService;
import com.example.item.InvocationHandler.apiActuator.TESTApiActuator;
import com.example.item.InvocationHandler.entity.TestHttpMethodDTO;
import lombok.Setter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Proxy;

@SpringBootTest
@RunWith(SpringRunner.class)
public class InvocationHandlerTest {

    @Setter(onMethod_ = @Autowired)
    private RestTemplate restTemplate;

    @Test
    public void test() {
        TestHttpMethodDTO testHttpMethodDTO = new TestHttpMethodDTO();
        testHttpMethodDTO.setCode("CODE");
        testHttpMethodDTO.setNumber("17782263622");
        testHttpMethodDTO.setProdType("1");
        TestHttpMethodService testHttpMethodService = (TestHttpMethodService) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{TestHttpMethodService.class},
                new TESTApiActuator(restTemplate,"", ""));
        TestHttpMethodDTO.TestHttpMethodVO testHttpMethodVO = testHttpMethodService.queryTestMethod(testHttpMethodDTO);
        System.out.println(testHttpMethodVO);
    }

}
