package com.example.item.tools.webService.xmlParse;

import com.example.item.tools.webService.dto.GetCusFeeVO;

/**
 * 账单接口
 *
 * @author MaoHao
 * @date 2021年03月24日 15:37
 */
public class ParseGetCusFee {

    public static void main(String[] args) {
        String xml = "";
        GetCusFeeVO getCusFeeVO = XmlUtils.convertXmlToBean(xml, GetCusFeeVO.class);
        System.out.println(getCusFeeVO.getBody().getCustReturnBaseInfo().getOtherFee());
    }


}
