package com.example.item.tools.webService.xmlParse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;

import java.util.List;

/**
 * @author HXM
 * @date 2021年03月31日 9:25
 */
public class XstreamTest {

    public static void main(String[] args) {
        String xml = "\n" +
                     "<?xml version=\"1.0\" encoding=\"GBK\" standalone=\"yes\"?>\n" +
                     "<Data>  \n" +
                     "  <Head>\n" +
                     "    <occ01>1</occ01>\n" +
                     "    <occ02>内部客户</occ02>\n" +
                     "    <occ18>内部客户</occ18>\n" +
                     "    <occacti>Y</occacti>\n" +
                     "    <occdate>2019-04-11</occdate>\n" +
                     "  </Head>\n" +
                     "  <Head>\n" +
                     "    <occ01>2</occ01>\n" +
                     "    <occ02>临时客户</occ02>\n" +
                     "    <occ18>临时客户</occ18>\n" +
                     "    <occacti>Y</occacti>\n" +
                     "    <occdate>2019-04-11</occdate>\n" +
                     "  </Head>\n" +
                     "  <Head>\n" +
                     "    <occ01>3</occ01>\n" +
                     "    <occ02>其他个人</occ02>\n" +
                     "    <occ18>其他个人</occ18>\n" +
                     "    <occacti>Y</occacti>\n" +
                     "    <occdate>2019-04-30</occdate>\n" +
                     "  </Head>\n" +
                     "</Data>";
        XStream xStream = new XStream();
        xStream.processAnnotations(DataList.class);
        DataList dataList = (DataList) xStream.fromXML(xml);
        System.out.println(dataList);
    }

    @Data
    @XStreamAlias("Data")
    public static class DataList {
        @XStreamImplicit(itemFieldName = "Head")
        private List<TestXmlClass> list;
    }

    @Data
    public static class TestXmlClass {
        private String occ01;
        private String occ02;
        private String occ18;
        private String occacti;
        private String occdate;
    }

}
