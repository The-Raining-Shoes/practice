package com.example.item.tools.webService.xmlParse;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 使用量接口
 *
 * @author MaoHao
 * @date 2021年03月23日 14:00
 */
public class ParseGetRatableResource {

    public HashMap<String, Object> map = new HashMap<>();

    public void parse(String soap) throws DocumentException {
        Document doc = DocumentHelper.parseText(soap);//报文转成doc对象
        Element root = doc.getRootElement();//获取根元素，准备递归解析这个XML树
        getCode(root.element("Body"));
    }

    public static void main(String[] args) throws DocumentException {
        String soap = "";
        //初始化报文，调用parse方法，获得结果map，然后按照需求取得字段，或者转化为其他格式
        new ParseGetRatableResource().parse(soap);
    }

    public void getCode(Element root) {
        if (root.elements() != null) {
            List<TestMode> resultList = new ArrayList<>();
            List<Element> list = root.elements();//如果当前跟节点有子节点，找到子节点
            for (Element e : list) {//遍历每个节点
                if (e.elements().size() > 0) {
                    if (e.getName().equals("multiRef")) {
                        if (null != e.element("accNbr")) {
                            TestMode testMode = new TestMode();
                            testMode.setAccNbr(e.element("accNbr").getTextTrim());
                            testMode.setOverTop(e.element("overTop") == null ? "" : e.element("overTop").getTextTrim());
                            testMode.setUnitTypeId(e.element("unitTypeId") == null ? "" : e.element("unitTypeId").getTextTrim());
                            testMode.setUseValue(e.element("useValue") == null ? "" : e.element("useValue").getTextTrim());
                            resultList.add(testMode);
                        }
                    }
                }
            }
            for (TestMode s : resultList) {
                System.out.println(s);
            }
        }
    }

    @Data
    @EqualsAndHashCode(callSuper = false)
    public static class TestMode {
        private String accNbr;
        private String overTop;
        private String unitTypeId;
        private String useValue;
    }

}
