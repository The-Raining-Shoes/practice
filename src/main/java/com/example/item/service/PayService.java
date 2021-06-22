package com.example.item.service;

import com.alipay.api.AlipayApiException;
import com.example.item.domain.entity.AlipayBean;

/**
 * @author HXM
 * @date 2020年11月09日 15:56
 */
public interface PayService {
    //支付宝
    String aliPay(AlipayBean alipayBean) throws AlipayApiException;
}
