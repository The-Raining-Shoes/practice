/**
 * Copyright 2018. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a href="http://www.chinaccs.com.cn/">重庆市通信服务产业有限公司</a>
 */
package com.example.item.domain.repository.res;

import com.example.item.domain.entity.GoodsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 测试类
 */
public interface GoodsInfoRepository extends JpaRepository<GoodsInfo, String> {
    
}
