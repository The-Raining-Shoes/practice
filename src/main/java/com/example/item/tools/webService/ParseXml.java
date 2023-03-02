package com.example.item.tools.webService;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.HashMap;
import java.util.List;

/**
 * @author HXM
 * @date 2021年03月23日 14:00
 */
public class ParseXml {

    public HashMap<String, Object> map = new HashMap<>();

    public HashMap<String, Object> parse(String soap) throws DocumentException {
        Document doc = DocumentHelper.parseText(soap);//报文转成doc对象
        Element root = doc.getRootElement();//获取根元素，准备递归解析这个XML树
        getCode(root);
        return map;
    }

    public static void main(String[] args) throws DocumentException {
    }

    public void getCode(Element root) {
        if (root.elements() != null) {
            List<Element> list = root.elements();//如果当前跟节点有子节点，找到子节点
            for (Element e : list) {//遍历每个节点
                if (e.elements().size() > 0) {
                    System.out.println("处理节点" + e.getName());
                    getCode(e);//当前节点不为空的话，递归遍历子节点；
                }
                if (e.elements().size() == 0) {
                    System.out.println(e.getName() + "-" + e.getTextTrim());
//                    map.put(e.getName(), e.getTextTrim());
                }//如果为叶子节点，那么直接把名字和值放入map
            }
        }
    }

}
