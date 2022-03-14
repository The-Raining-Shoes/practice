package com.example.item.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.item.domain.entity.DispatchOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * 在对应的Mapper上面实现基本的接口就可以了
 */
@Mapper //代表持久层
public interface DispatchOrderMapper extends BaseMapper<DispatchOrder> {

}
