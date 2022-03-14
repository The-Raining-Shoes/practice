package com.example.item.thread.function;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

/**
 * function函式接口编程
 * 返回型接口
 */
@Transactional(propagation = Propagation.MANDATORY)
public class FunctionTest {

    @Setter(onMethod_ = @Autowired)
    static PlatformTransactionManager platformTransactionManager;

    public static void main(String[] args) {
        Function<String, Object> function = (str) -> str + "Test";
        System.out.println(function.apply("测试数据"));
    }

}
