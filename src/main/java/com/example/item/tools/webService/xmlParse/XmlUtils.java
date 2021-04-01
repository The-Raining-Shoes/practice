package com.example.item.tools.webService.xmlParse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.dom4j.Document;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HXM
 * @date 2021年03月30日 15:55
 */
public class XmlUtils {

    @SuppressWarnings("unchecked")
    public static <T> T convertXmlToBean(String xml, Class<T> t) {
        XStream xStream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xStream);
        xStream.allowTypesByRegExp(new String[]{".*"});
        xStream.processAnnotations(t);
        return (T) xStream.fromXML(xml);
    }

    public static Map<String, Object> Dom2Map(Document doc) {
        Map<String, Object> map = new HashMap<>();
        if (doc == null) {
            return map;
        }
        Element root = doc.getRootElement();
        for (Element e : root.elements()) {
            List<Element> list = e.elements();
            if (list.size() > 0) {
                map.put(e.getName(), Dom2Map(e));
            } else {
                map.put(e.getName(), e.getText());
            }
        }
        return map;
    }

    public static Map<String, Object> Dom2Map(Element e) {
        Map<String, Object> map = new HashMap<>();
        List<Element> list = e.elements();
        if (list.size() > 0) {
            for (Element iter : list) {
                List<Object> mapList = new ArrayList<>();
                if (iter.elements().size() > 0) {
                    Map<String, Object> m = Dom2Map(iter);
                    if (map.get(iter.getName()) != null) {
                        Object obj = map.get(iter.getName());
                        if (!obj.getClass().getName().equals("java.util.ArrayList")) {
                            mapList = new ArrayList<>();
                            mapList.add(obj);
                            mapList.add(m);
                        }
                        map.put(iter.getName(), mapList);
                    } else {
                        map.put(iter.getName(), m);
                    }
                } else {
                    if (map.get(iter.getName()) != null) {
                        Object obj = map.get(iter.getName());
                        if (!obj.getClass().getName().equals("java.util.ArrayList")) {
                            mapList = new ArrayList<>();
                            mapList.add(obj);
                            mapList.add(iter.getText());
                        }
                        map.put(iter.getName(), mapList);
                    } else {
                        map.put(iter.getName(), iter.getText());
                    }
                }
            }
        } else {
            map.put(e.getName(), e.getText());
        }
        return map;
    }

}
