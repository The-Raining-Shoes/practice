package com.example.item;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.item.domain.entity.DispatchOrder;
import com.example.item.domain.mapper.DispatchOrderMapper;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class MybatisTest {

    @Setter(onMethod_ = @Autowired)
    private JdbcTemplate jdbcTemplate;

    @Setter(onMethod_ = @Autowired)
    private DispatchOrderMapper dispatchOrderMapper;

    @Test
    public void selectById() {
        final DispatchOrder dispatchOrder = dispatchOrderMapper.selectById(1);
        System.out.println(dispatchOrder);
    }

    @Test
    public void selectAll() {
        // 查询参数是一个Wrapper，条件构造器，这里我们先不用 null
        // 查询全部数据
        final List<DispatchOrder> dispatchOrders = dispatchOrderMapper.selectList(null);
        dispatchOrders.forEach(System.out::println);
    }

    @Test
    public void insert() {
        QueryWrapper<DispatchOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("", "");
        DispatchOrder dispatchOrder = new DispatchOrder();
        dispatchOrder.setCode("测试啊");
        dispatchOrder.setStatus(1);
        final int insert = dispatchOrderMapper.insert(dispatchOrder);
        System.out.println(insert);
    }

    @Test
    public void update() {
        DispatchOrder dispatchOrder = new DispatchOrder();
        dispatchOrder.setId(57);
        dispatchOrder.setCode("测试修改、重复修改");
        dispatchOrderMapper.updateById(dispatchOrder);
    }

    @Test
    public void lockSuccessTest() {
        // 查询数据
        DispatchOrder dispatchOrder = dispatchOrderMapper.selectById(1);
        // 修改数据
        dispatchOrder.setCode("测试version字段");
        dispatchOrder.setStatus(2);
        // 根据mybatis-plus的mappler类根据id来修改数据
        dispatchOrderMapper.updateById(dispatchOrder);
    }

    @Test
    public void lockFailTest() {
        // 查询数据
        DispatchOrder dispatchOrder1 = dispatchOrderMapper.selectById(1);
        // 修改数据
        dispatchOrder1.setCode("测试version字段111");
        dispatchOrder1.setStatus(2);
        // 线程2进来
        DispatchOrder dispatchOrder2 = dispatchOrderMapper.selectById(1);
        dispatchOrder2.setCode("测试version字段222");
        // 根据mybatis-plus的mappler类根据id来修改数据
        dispatchOrderMapper.updateById(dispatchOrder2);
        dispatchOrderMapper.updateById(dispatchOrder1);
    }

    @Test
    public void batchQuery() {
        final List<DispatchOrder> dispatchOrders = dispatchOrderMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(dispatchOrders);
    }

    @Test
    public void queryByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", "测试修改");
        final List<DispatchOrder> dispatchOrders = dispatchOrderMapper.selectByMap(map);
        System.out.println(dispatchOrders);
    }

    @Test
    public void testPage() {
        Page<DispatchOrder> page = new Page<>(1, 5);
        dispatchOrderMapper.selectPage(page, null);
        System.out.println(page.getRecords());
    }

    @Test
    public void deleteTest() {
        dispatchOrderMapper.deleteById(1);
    }

}
