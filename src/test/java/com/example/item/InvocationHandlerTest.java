package com.example.item;

import com.example.item.InvocationHandler.TestHttpMethodService;
import com.example.item.InvocationHandler.TESTApiActuator;
import com.example.item.InvocationHandler.entity.ApiBean;
import com.example.item.InvocationHandler.TestHttpMethodDTO;
import lombok.Setter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@SpringBootTest
@RunWith(SpringRunner.class)
public class InvocationHandlerTest {

    @Setter(onMethod_ = @Autowired)
    private RestTemplate restTemplate;

    @Test
    public void test() {
        ApiBean<TestHttpMethodService> apiBean = new ApiBean<>(TestHttpMethodService.class, this.getTESTApiActuator());
        try {
            TestHttpMethodDTO testHttpMethodDTO = new TestHttpMethodDTO();
            testHttpMethodDTO.setCode("CODE");
            testHttpMethodDTO.setNumber("17782263622");
            testHttpMethodDTO.setProdType("1");
            Objects.requireNonNull(apiBean.getObject()).queryTestMethod(testHttpMethodDTO, testHttpMethodDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    TESTApiActuator getTESTApiActuator() {
        return new TESTApiActuator(restTemplate, "", "");
    }

}
