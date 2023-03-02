package com.example.item.tools.webService.xmlParse;

import com.example.item.tools.webService.dto.BillQueryOweVO;
import com.example.item.tools.webService.dto.GroupBase;

/**
 * 账户欠费查询
 *
 * @author MaoHao
 * @date 2021年03月26日 15:30
 */
public class ParseBillQueryOwe {

    public static void main(String[] args) {
        String xml = "";
        GroupBase userGroupBaseVO = XmlUtils.convertXmlToBean(xml, GroupBase.class);
        BillQueryOweVO billQueryOweVO = XmlUtils.convertXmlToBean(userGroupBaseVO.getBody().getUserGroupBaseVO().getContent().split("<Session-Id>")[0], BillQueryOweVO.class);
        System.out.println(billQueryOweVO);
    }

}
