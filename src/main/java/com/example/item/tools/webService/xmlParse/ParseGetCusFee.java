package com.example.item.tools.webService.xmlParse;

import com.example.item.utils.JsonUtil;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * BSN智能账单接口
 *
 * @author MaoHao
 * @date 2021年03月24日 15:37
 */
public class ParseGetCusFee {

    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><soapenv:Body><ns1:getCustFeeResponse soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns1=\"http://bll.custserviceinfmgr.bsn.ztesoft.com\"><getCustFeeReturn href=\"#id0\"/></ns1:getCustFeeResponse><multiRef id=\"id0\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns2:ResultNewDto\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns2=\"http://model.balancemgr.bsn.ztesoft.com\"><billingCycleName xsi:type=\"xsd:string\">2021&#x5E74;02&#x6708;01&#x65E5;&#x81F3;2021&#x5E74;02&#x6708;28&#x65E5;</billingCycleName><code xsi:type=\"xsd:string\">success</code><curFeeTotal xsi:type=\"xsd:string\">235.1</curFeeTotal><curPaidFee xsi:type=\"xsd:string\">235.1</curPaidFee><curPayableFee xsi:type=\"xsd:string\">0</curPayableFee><custCode xsi:type=\"xsd:string\">2023134052990000</custCode><custId xsi:type=\"xsd:string\">800007329364</custId><custName xsi:type=\"xsd:string\">&#x6BDB;&#x6B23;</custName><description xsi:type=\"xsd:string\" xsi:nil=\"true\"/><discountAmount xsi:type=\"xsd:string\" xsi:nil=\"true\"/><discountFee xsi:type=\"xsd:string\" xsi:nil=\"true\"/><offerAmount xsi:type=\"xsd:string\">217.0</offerAmount><offerFee xsi:type=\"xsd:string\">[{&quot;offerName&quot;:&quot;&#x5168;&#x5BB6;&#x798F;&#x7545;&#x4EAB;169&#x5143;&#x5957;&#x9910;&quot;,&quot;offerAmount&quot;:&quot;169.00&quot;,&quot;offerId&quot;:&quot;20009741&quot;},{&quot;offerName&quot;:&quot;100M&#x526F;&#x5BBD;&#x5E26;38&#x5143;/&#x6708;&quot;,&quot;offerAmount&quot;:&quot;38.00&quot;,&quot;offerId&quot;:&quot;20001793&quot;},{&quot;offerName&quot;:&quot;&#x5929;&#x7FFC;&#x9AD8;&#x6E05;&#x5C0A;&#x4EAB;&#x7248;10&#x5143;/&#x6708;&quot;,&quot;offerAmount&quot;:&quot;10.00&quot;,&quot;offerId&quot;:&quot;20005027&quot;}]</offerFee><otherAmount xsi:type=\"xsd:string\">18.1</otherAmount><otherCountAmount xsi:type=\"xsd:string\">18.1</otherCountAmount><otherCountFee xsi:type=\"xsd:string\">[{&quot;12&quot;:&quot;0.10&quot;,&quot;detail&quot;:[{&quot;accNum&quot;:&quot;17312302713&quot;,&quot;amount&quot;:&quot;0.10&quot;,&quot;offerName&quot;:&quot;&#x4E50;&#x4EAB;&#x5BB6;&#x6D41;&#x91CF;&#x8F6C;&#x77ED;&#x4FE1;&#x8D39;&#x7528;&quot;}]},{&quot;14&quot;:18.00,&quot;detail&quot;:[{&quot;accNum&quot;:&quot;17312372613&quot;,&quot;amount&quot;:&quot;6.00&quot;,&quot;offerName&quot;:&quot;&#x4E03;&#x5F69;&#x94C3;&#x97F3;&quot;,&quot;offerId&quot;:null},{&quot;accNum&quot;:&quot;18888887777&quot;,&quot;amount&quot;:&quot;10.00&quot;,&quot;offerName&quot;:&quot;&#x526F;&#x5361;&#x8D39;&#x7528;&quot;,&quot;offerId&quot;:null},{&quot;accNum&quot;:&quot;18888887222&quot;,&quot;amount&quot;:&quot;6.00&quot;,&quot;offerName&quot;:&quot;&#x89C6;&#x9891;&#x5F69;&#x94C3;6&#x5143;&#x5305;&#xFF08;2020&#x5E74;5&#x6708;31&#x65E5;&#x524D;&#x514D;&#x8D39;&#xFF09;&quot;,&quot;offerId&quot;:&quot;20004622&quot;},{&quot;accNum&quot;:&quot;17995339622&quot;,&quot;amount&quot;:&quot;2.00&quot;,&quot;offerName&quot;:&quot;&#x6F0F;&#x8BDD;&#x670D;&#x52A1;&quot;,&quot;offerId&quot;:null},{&quot;accNum&quot;:&quot;17995339622&quot;,&quot;amount&quot;:&quot;-6.00&quot;,&quot;offerName&quot;:&quot;C&#x7F51;&#x5F69;&#x94C3;&#x514D;&#x8D39;&#x529F;&#x80FD;&#x8D39;&#x3010;2018&#x3011;&quot;,&quot;offerId&quot;:&quot;313810&quot;}]}]</otherCountFee><otherFee xsi:type=\"xsd:string\">{&quot;208511296:17995339622&quot;:[{&quot;amount&quot;:&quot;2.00&quot;,&quot;offerName&quot;:&quot;&#x6F0F;&#x8BDD;&#x670D;&#x52A1;&quot;},{&quot;amount&quot;:&quot;10.00&quot;,&quot;offerName&quot;:&quot;&#x526F;&#x5361;&#x8D39;&#x7528;&quot;},{&quot;amount&quot;:&quot;6.00&quot;,&quot;offerName&quot;:&quot;&#x89C6;&#x9891;&#x5F69;&#x94C3;6&#x5143;&#x5305;&#xFF08;2020&#x5E74;5&#x6708;31&#x65E5;&#x524D;&#x514D;&#x8D39;&#xFF09;&quot;},{&quot;amount&quot;:&quot;-6.00&quot;,&quot;offerName&quot;:&quot;C&#x7F51;&#x5F69;&#x94C3;&#x514D;&#x8D39;&#x529F;&#x80FD;&#x8D39;&#x3010;2018&#x3011;&quot;}],&quot;208511296:17312372613&quot;:[{&quot;amount&quot;:&quot;6.00&quot;,&quot;offerName&quot;:&quot;&#x4E03;&#x5F69;&#x94C3;&#x97F3;&quot;},{&quot;amount&quot;:&quot;0.10&quot;,&quot;offerName&quot;:&quot;&#x4E50;&#x4EAB;&#x5BB6;&#x6D41;&#x91CF;&#x8F6C;&#x77ED;&#x4FE1;&#x8D39;&#x7528;&quot;}]}</otherFee></multiRef></soapenv:Body></soapenv:Envelope>\n";
        new ParseGetCusFee().parse(xml);
    }

    private void parse(String xml) {
        Document doc;//报文转成doc对象
        Map<String, Object> map;
        try {
            doc = DocumentHelper.parseText(xml);
            Element root = doc.getRootElement().element("Body");//获取根元素，准备递归解析这个XML树
            List<UserInfo> result = new ArrayList<>();
            if (root.elements().size() > 0) {
                for (Element element : root.elements()) {
                    if (element.getName().equals("multiRef")) {
                        Element otherFee = element.element("otherFee");
                        String userMobile = otherFee.getTextTrim();
                        map = JsonUtil.fromJson(userMobile, new TypeToken<Map<String, Object>>() {
                        }.getType());
                        for (String key : map.keySet()) {
                            UserInfo userInfo = new UserInfo();
                            String value = map.get(key).toString();
                            userInfo.setUserMobile(key.split(":")[1]);
                            List<UserBill> commentList = JsonUtil.fromJson(value, new TypeToken<List<UserBill>>() {
                            }.getType());
                            userInfo.setUserBill(commentList);
                            result.add(userInfo);
                        }
                    }
                }
            }
            for (UserInfo l : result) {
                System.out.println(l);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @Data
    static class UserInfo {
        private String userMobile;
        private List<UserBill> userBill;
    }

    @Data
    public static class UserBill {
        private BigDecimal amount;
        private String offerName;
    }

}
