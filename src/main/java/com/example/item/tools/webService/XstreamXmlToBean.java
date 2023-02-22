package com.example.item.tools.webService;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author HXM
 * @date 2021年03月23日 11:31
 */
public class XstreamXmlToBean {

    public static void main(String[] args) {
        String xml = "";
        //创建xstream对象
        XStream xStream = new XStream();
        //解决xStream:Security framework of XStream not initialized, XStream is probably vulnerable
        XStream.setupDefaultSecurity(xStream);
        xStream.allowTypes(new Class[]{Tests.class});
        xStream.setClassLoader(Tests.class.getClassLoader());
        //将字符串类型的xml转换为对象
        Testss bank = (Testss) xStream.fromXML(xml);
        System.out.println(bank);
    }

    @Data
    @EqualsAndHashCode(callSuper = false)
    public static class Testss {
        List<Tests> code;
    }

    @Data
    @EqualsAndHashCode(callSuper = false)
    @XStreamAlias("multiRef")
    public static class Tests {

        @XStreamAlias("accNbr")
        private String accNbr;

        @XStreamAlias("overTop")
        private long overTop;

        @XStreamAlias("unitTypeId")
        private Integer unitTypeId;

        @XStreamAlias("useValue")
        private long useValue;

    }

}
