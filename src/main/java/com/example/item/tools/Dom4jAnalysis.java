package com.example.item.tools;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>(Dom4jAnalysis)</b>
 *
 * @author Rainy 2023-02-23 10:53:23
 * @version 1.0.0
 */
public class Dom4jAnalysis {

    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<RECORDS>\n" +
                "\n" +
                "\n" +
                "<FormInfo xxx=\"房屋安全鉴定报告和复核鉴定报告备案\" bbb=\"房屋安全鉴定报告和复核鉴定报告备案\">\n" +
                "<Item id=\"applyCardNumbe11111111111111111r\">91330110571494382J</Item>\n" +
                "<Item name=\"applyName\">浙江中能工程检测有限公司</Item>\n" +
                "<Item name=\"applyAddress\">杭州钱江经济开发区顺风路536号18幢</Item>\n" +
                "<Item name=\"legalRepresentative\">蔡奖权</Item>\n" +
                "<Item name=\"telphone\">13067912377</Item>\n" +
                "<Item name=\"legalCardTypeCode\">居民身份证</Item>\n" +
                "<Item name=\"frCardNumber\">330724197903174819</Item>\n" +
                "<Item name=\"contactName\">徐婷</Item>\n" +
                "<Item name=\"contactPhone\">15869148498</Item>\n" +
                "<Item name=\"contactCardType\">居民身份证</Item>\n" +
                "<Item name=\"contactCardNumber\">330724197903174819</Item>\n" +
                "</FormInfo>\n" +
                "\n" +
                "<FormInfo name=\"信用基本信息\">\n" +
                "<Item name=\"xydj\">A</Item>\n" +
                "<Item name=\"xyfs\">111</Item>\n" +
                "</FormInfo>\n" +
                "<FormInfo name=\"房屋安全鉴定报告和复核鉴定报告备案事项\">\n" +
                "<Item name=\"jddwmc\">张三（测试）</Item>\n" +
                "<Item name=\"xmmc\">张三（测试）</Item>\n" +
                "<Item name=\"xmdz\">张三（测试）</Item>\n" +
                "<Item name=\"bgbh\">国dj125884</Item>\n" +
                "<Item name=\"sffhjd\">是</Item>\n" +
                "<Item name=\"jddj\">B</Item>\n" +
                "<Item name=\"wtr\">张三（测试）</Item>\n" +
                "<Item name=\"jggzwtr\">否</Item>\n" +
                "<Item name=\"lxrxm\">张三（测试）</Item>\n" +
                "<Item name=\"sqrq\">2019-11-29</Item>\n" +
                "<Item name=\"lxrsj\">15857946002</Item>\n" +
                "<Item name=\"bz\"></Item>\n" +
                "<Item name=\"validityBeginDate\">2014-11-29</Item>\n" +
                "<Item name=\"validityEndDate\">2019-11-29</Item>\n" +
                "<Item name=\"hb\">125884</Item>\n" +
                "</FormInfo>\n" +
                "<FormInfo name=\"送达方式\">\n" +
                "<Item name=\"isNeedPost\">窗口领取</Item>\n" +
                "<Item name=\"company\">顺丰</Item>\n" +
                "<Item name=\"payType\">到付</Item>\n" +
                "<Item name=\"postName\">测试</Item>\n" +
                "<Item name=\"expressPhone\">15857946002</Item>\n" +
                "<Item name=\"postRegionText\">杭州钱江经济开发区顺风路536号18幢</Item>\n" +
                "<Item name=\"postAddress\">杭州钱江经济开发区顺风路536号18幢</Item>\n" +
                "<Item name=\"postcode\">320016</Item>\n" +
                "</FormInfo>\n" +
                "</RECORDS>";


        SAXReader reader = new SAXReader();
        try {
            Document document = DocumentHelper.parseText(xml);

            Element rootElement = document.getRootElement();
            //遍历根节点的子节点,用Element对象的elementIterator获取子节点的迭代器

            Iterator<Element> iterator = rootElement.elementIterator();
            //遍历迭代器，获取根节点的信息
            while (iterator.hasNext()) {
                System.out.println("------开始遍历xml---------");
                Element book = iterator.next();

                List<Attribute> bookattributes = book.attributes();
                for (Attribute attribute : bookattributes) {
                    System.out.println("属性名： " + attribute.getName() + "--属性值："
                            + attribute.getValue());
                }
                //遍历book节点子节点，elementIterator得到迭代器
                Iterator it2 = book.elementIterator();

                LinkedHashMap<String, String> map = new LinkedHashMap();
                while (it2.hasNext()) {
                    Element bookChild = (Element) it2.next();

                    // xml 子节点的属性
                    List attr = bookChild.attributes();
                    for (int i = 0; i < attr.size(); i++) {
                        Attribute attribute = (Attribute) attr.get(i);
                        String name = attribute.getValue();
                        map.put(attribute.getValue(), bookChild.getStringValue());
                        System.out.println("--节点名 name= " + name);
                        System.out.println("--节点值：" + bookChild.getStringValue());
                    }
                    //   System.out.println("--节点值：" + bookChild.getStringValue());
                }
                System.out.println("------结束遍历xml---------");

                for (Map.Entry entry : map.entrySet()) {
                    System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
                }
            }


        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

}
