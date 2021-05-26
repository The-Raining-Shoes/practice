package com.example.item.tools.webService.xmlParse;

import com.example.item.tools.webService.dto.GetCusFeeVO;

/**
 * BSN智能账单接口
 *
 * @author MaoHao
 * @date 2021年03月24日 15:37
 */
public class ParseGetCusFee {

    public static void main(String[] args) {
        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                     "   <soapenv:Body>\n" +
                     "      <ns1:getCustFeeResponse soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns1=\"http://bll.custserviceinfmgr.bsn.ztesoft.com\">\n" +
                     "         <getCustFeeReturn href=\"#id0\"/>\n" +
                     "      </ns1:getCustFeeResponse>\n" +
                     "      <multiRef id=\"id0\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns2:ResultNewDto\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns2=\"http://model.balancemgr.bsn.ztesoft.com\">\n" +
                     "         <billingCycleName xsi:type=\"xsd:string\">2021年03月01日至2021年03月31日</billingCycleName>\n" +
                     "         <code xsi:type=\"xsd:string\">success</code>\n" +
                     "         <curFeeTotal xsi:type=\"xsd:string\">235.0</curFeeTotal>\n" +
                     "         <curPaidFee xsi:type=\"xsd:string\">235.0</curPaidFee>\n" +
                     "         <curPayableFee xsi:type=\"xsd:string\">0</curPayableFee>\n" +
                     "         <custCode xsi:type=\"xsd:string\">2023134052990000</custCode>\n" +
                     "         <custId xsi:type=\"xsd:string\">800007329364</custId>\n" +
                     "         <custName xsi:type=\"xsd:string\">毛欣</custName>\n" +
                     "         <description xsi:type=\"xsd:string\" xsi:nil=\"true\"/>\n" +
                     "         <discountAmount xsi:type=\"xsd:string\" xsi:nil=\"true\"/>\n" +
                     "         <discountFee xsi:type=\"xsd:string\" xsi:nil=\"true\"/>\n" +
                     "         <offerAmount xsi:type=\"xsd:string\">217.0</offerAmount>\n" +
                     "         <offerFee xsi:type=\"xsd:string\">[{\"offerName\":\"全家福畅享169元套餐\",\"offerAmount\":\"169.00\",\"offerId\":\"20009741\"},{\"offerName\":\"100M副宽带38元/月\",\"offerAmount\":\"38.00\",\"offerId\":\"20001793\"},{\"offerName\":\"天翼高清尊享版10元/月\",\"offerAmount\":\"10.00\",\"offerId\":\"20005027\"}]</offerFee>\n" +
                     "         <otherAmount xsi:type=\"xsd:string\">18.0</otherAmount>\n" +
                     "         <otherCountAmount xsi:type=\"xsd:string\">18.0</otherCountAmount>\n" +
                     "         <otherCountFee xsi:type=\"xsd:string\">[{\"14\":18.00,\"detail\":[{\"accNum\":\"15310072613\",\"amount\":\"6.00\",\"offerName\":\"七彩铃音\",\"offerId\":null},{\"accNum\":\"18996339622\",\"amount\":\"10.00\",\"offerName\":\"副卡费用\",\"offerId\":null},{\"accNum\":\"18996339622\",\"amount\":\"6.00\",\"offerName\":\"视频彩铃6元包（2020年5月31日前免费）\",\"offerId\":\"20004622\"},{\"accNum\":\"18996339622\",\"amount\":\"2.00\",\"offerName\":\"漏话服务\",\"offerId\":null},{\"accNum\":\"18996339622\",\"amount\":\"-6.00\",\"offerName\":\"C网彩铃免费功能费【2018】\",\"offerId\":\"313810\"}]}]</otherCountFee>\n" +
                     "         <otherFee xsi:type=\"xsd:string\">{\"208511296:18996339622\":[{\"amount\":\"2.00\",\"offerName\":\"漏话服务\"},{\"amount\":\"10.00\",\"offerName\":\"副卡费用\"},{\"amount\":\"6.00\",\"offerName\":\"视频彩铃6元包（2020年5月31日前免费）\"},{\"amount\":\"-6.00\",\"offerName\":\"C网彩铃免费功能费【2018】\"}],\"208511296:15310072613\":[{\"amount\":\"6.00\",\"offerName\":\"七彩铃音\"}]}</otherFee>\n" +
                     "      </multiRef>\n" +
                     "   </soapenv:Body>\n" +
                     "</soapenv:Envelope>";
        GetCusFeeVO getCusFeeVO = XmlUtils.convertXmlToBean(xml, GetCusFeeVO.class);
        System.out.println(getCusFeeVO.getBody().getCustReturnBaseInfo().getOtherFee());
    }


}
