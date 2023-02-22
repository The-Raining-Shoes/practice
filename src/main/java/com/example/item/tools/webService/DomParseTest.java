package com.example.item.tools.webService;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.List;

/**
 * @author HXM
 * @date 2021年03月23日 14:41
 */
public class DomParseTest {

    public static void main(String[] args) {
        String soap = "";
        try {
            Document doc = DocumentHelper.parseText(soap);//报文转成doc对象
            Element root = doc.getRootElement();//获取根元素，准备递归解析这个XML树
            List<Element> list = root.elements();//如果当前跟节点有子节点，找到子节点
            for (Element element : list) {
                System.out.println(element.element("multiRef"));
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

}
