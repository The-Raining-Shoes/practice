package com.example.item.tools.webService.xmlParse;

import com.example.item.tools.webService.dto.GroupBase;

/**
 * 集团一致性账户欠费查询
 *
 * @author MaoHao
 * @date 2021年03月26日 15:30
 */
public class ParseBillQueryOwe {

    public static void main(String[] args) {
        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                     "   <soapenv:Body>\n" +
                     "      <ns1:callWebServiceResponse soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns1=\"http://webservice.bss.ztesoft.com\">\n" +
                     "         <callWebServiceReturn href=\"#id0\"/>\n" +
                     "      </ns1:callWebServiceResponse>\n" +
                     "      <multiRef id=\"id0\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns2:RespMessage\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns2=\"http://model.webservice.bsn.ztesoft.com\">\n" +
                     "         <content xsi:type=\"xsd:string\"><![CDATA[<?xml version=\"1.0\" encoding=\"UTF-8\"?><SAMResponse><Service-Information><Service-Result-Code>0</Service-Result-Code><Bill-Query-Information><Acct-ID>830000110001088482</Acct-ID><Acc-Nbr>15310677636</Acc-Nbr><PaymentFlag>0</PaymentFlag><Fee-Billing-Cycle><Billing-Cycle-ID>20210301</Billing-Cycle-ID><Acct_Item_Group><Acct_Item_Group-Id>0</Acct_Item_Group-Id><Acct-Item-Type><Acct-Item-Type-Name>5G升级包包月费</Acct-Item-Type-Name><Acct-Item-Charge>2514</Acct-Item-Charge></Acct-Item-Type><Acct-Item-Type><Acct-Item-Type-Name>全家福全国畅享</Acct-Item-Type-Name><Acct-Item-Charge>9900</Acct-Item-Charge></Acct-Item-Type></Acct_Item_Group><Charge-Payed>406</Charge-Payed><Sum_Charge>12820</Sum_Charge></Fee-Billing-Cycle></Bill-Query-Information></Service-Information></SAMResponse><Session-Id>CQWT@02320210323094928794</Session-Id>]]></content>\n" +
                     "         <respCode xsi:type=\"xsd:string\">0</respCode>\n" +
                     "         <srvFunction xsi:type=\"xsd:string\">call</srvFunction>\n" +
                     "         <srvModule xsi:type=\"xsd:string\">CallCJ3Service</srvModule>\n" +
                     "      </multiRef>\n" +
                     "   </soapenv:Body>\n" +
                     "</soapenv:Envelope>";
        GroupBase userGroupBaseVO = XmlUtils.convertXmlToBean(xml, GroupBase.class);
        System.out.println(userGroupBaseVO.getBody().getUserGroupBaseVO().getContent());
    }

}
