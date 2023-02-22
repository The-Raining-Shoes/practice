package com.example.item.tools.webService.xmlParse2;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RatableResourceXParseTest {

    public static void main(String[] args) throws DocumentException {
        String soap = "";
        new RatableResourceXParseTest().parse(soap);
    }

    public void parse(String soap) throws DocumentException {
        Document doc = DocumentHelper.parseText(soap);//报文转成doc对象
        Element root = doc.getRootElement();//获取根元素，准备递归解析这个XML树
        getCode(root.element("Body"));
    }

    public void getCode(Element root) {
        BigDecimal overBill = BigDecimal.ZERO;
        BigDecimal overFlow = BigDecimal.ZERO;
        boolean ifLimit = false;
        if (root.elements() != null) {
            List<TestMode> resultList = new ArrayList<>();
            List<Element> list = root.elements();//如果当前跟节点有子节点，找到子节点
            for (Element e : list) {//遍历每个节点
                if (e.elements().size() > 0) {
                    if (e.getName().equals("multiRef")) {
                        if (null != e.element("accNbr") && "17782263622".equals(e.element("accNbr").getTextTrim())) {
                            // 溢出金额（分）
                            if (e.element("unitTypeId").getTextTrim().equals("1")) {
                                overBill = overBill.add(new BigDecimal(e.element("overTop").getTextTrim()));
                            }
                            // 溢出流量（KB）
                            else if (e.element("unitTypeId").getTextTrim().equals("3")) {
                                overFlow = overFlow.add(new BigDecimal(e.element("overTop").getTextTrim()));
                            }
                        }
                        if (null != e.element("productOffName") && null != e.element("offerType")) {
                            TestMode testMode = new TestMode();
                            testMode.setOfferType(e.element("offerType").getTextTrim());
                            testMode.setProdOfferInstanceId(e.element("prodOfferInstanceId") == null ? "" : e.element("prodOfferInstanceId").getTextTrim());
                            testMode.setProductOffName(e.element("productOffName") == null ? "" : e.element("productOffName").getTextTrim());
                            testMode.setProductOfferId(e.element("productOfferId") == null ? "" : e.element("productOfferId").getTextTrim());
                            resultList.add(testMode);
                        }
                        if (null != e.element("ratableResourceId")) {
                            String ratableResourceId = e.element("ratableResourceId").getTextTrim();
                            if (ratableResourceId.equals("331101")) {
                                ifLimit = true;
                            }
                        }
                    }
                }
            }
            for (TestMode s : resultList) {
                System.out.println(s);
            }
            System.out.println(overBill);
            System.out.println(overFlow);
            System.out.println(ifLimit);
        }
    }

    @Data
    @EqualsAndHashCode(callSuper = false)
    public static class TestMode {
        private String offerType;
        private String prodOfferInstanceId;
        private String productOffName;
        private String productOfferId;
    }

}
