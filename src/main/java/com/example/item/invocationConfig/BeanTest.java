package com.example.item.invocationConfig;

import lombok.Setter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <b>(BeanTest)</b>
 *
 * @author Rainy 2023-02-17 16:13:42
 * @version 1.0.0
 */
@Service
public class BeanTest implements InitializingBean {

    @Setter(onMethod_ = @Autowired)
    private TestInterface testInterface;

    @Override
    public void afterPropertiesSet() {
        System.out.println("11213122");
        testInterface.test();
        System.out.println(1);
    }

}
