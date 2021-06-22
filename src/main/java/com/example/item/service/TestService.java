package com.example.item.service;

import com.example.item.domain.annation.AnnationTest;
import com.example.item.domain.repository.res.GoodsInfoRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Setter(onMethod_ = @Autowired)
    private GoodsInfoRepository goodsInfoRepository;

    @AnnationTest(testCode = "测试数据")
    public void tests() {
        System.out.println("切面测试");
    }

    @Cacheable(value = "test")
    public String testCache(String testCode) {
        System.out.println(testCode);
        return testCode;
//        GoodsInfo goodsInfo = goodsInfoRepository.findById(new BigInteger(testCode)).orElse(null);
//        assert goodsInfo != null;
//        return goodsInfo.getGoodsName();
    }
}
