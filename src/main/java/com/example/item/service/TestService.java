package com.example.item.service;

import com.example.item.domain.annation.AnnationTest;
import com.example.item.domain.entity.GoodsInfo;
import com.example.item.domain.repository.res.GoodsInfoRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class TestService {

    @Setter(onMethod_ = @Autowired)
    private GoodsInfoRepository goodsInfoRepository;

    @AnnationTest(testCode = "测试数据")
    public void tests() {
        System.out.println("切面测试");
    }

    public String testCache(String testCode) {
        GoodsInfo goodsInfo = goodsInfoRepository.findById(new BigInteger(testCode)).orElse(null);
        assert goodsInfo != null;
        return goodsInfo.getGoodsName();
    }
}
