//package com.example.item;
//
//import com.example.item.domain.jdbc.BeanJdbcTemplate;
//import lombok.Setter;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import java.util.List;
//import java.util.Map;
//
//@SpringBootTest
//public class MyDataSourceTest {
//
//    @Setter(onMethod_ = @Autowired)
//    private JdbcTemplate jdbcTemplate;
//    @Setter(onMethod_ = @Autowired)
//    private BeanJdbcTemplate beanJdbcTemplate;
//
//    @Test
//    public void test1() {
//        final List<Map<String, Object>> maps1 = jdbcTemplate.queryForList("select * from dispatch_order");
//        for (Map<String, Object> map : maps1) {
//            System.out.println(map);
//        }
//        System.out.println("========================================");
//        final List<Map<String, Object>> maps2 = beanJdbcTemplate.queryForList("select * from dispatch_order");
//        for (Map<String, Object> map : maps2) {
//            System.out.println(map);
//        }
//    }
//
//}
