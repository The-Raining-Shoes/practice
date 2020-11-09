package com.example.item.service.impl;

import com.alipay.api.AlipayApiException;
import com.example.item.domain.entity.AlipayBean;
import com.example.item.service.PayService;
import com.example.item.utils.AlipayUtil;
import org.springframework.stereotype.Service;

/**
 * @author HXM
 * @date 2020年11月09日 15:56
 */

/* 支付服务 */
@Service(value = "alipayOrderService")
public class PayServiceImpl implements PayService {
    @Override
    public String aliPay(AlipayBean alipayBean) throws AlipayApiException {
        return AlipayUtil.connect(alipayBean);
    }
}
