package com.example.item.tools.webService.xmlParse;

import com.example.item.utils.CheckUtil;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.Map;

/**
 * 集团一致性账户欠费查询
 *
 * @author MaoHao
 * @date 2021年03月26日 15:30
 */
public class ParseBillQueryOwe {

    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><soapenv:Body><ns1:callWebServiceResponse soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns1=\"http://webservice.bss.ztesoft.com\"><callWebServiceReturn href=\"#id0\"/></ns1:callWebServiceResponse><multiRef id=\"id0\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns2:RespMessage\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns2=\"http://model.webservice.bsn.ztesoft.com\"><content xsi:type=\"xsd:string\">&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot;?&gt;&lt;SAMResponse&gt;&lt;Service-Information&gt;&lt;Service-Result-Code&gt;0&lt;/Service-Result-Code&gt;&lt;/Service-Information&gt;&lt;/SAMResponse&gt;&lt;Session-Id&gt;CQWT@02320210323094928794&lt;/Session-Id&gt;</content><respCode xsi:type=\"xsd:string\">0</respCode><srvFunction xsi:type=\"xsd:string\">call</srvFunction><srvModule xsi:type=\"xsd:string\">CallCJ3Service</srvModule></multiRef></soapenv:Body></soapenv:Envelope>\n";
        new ParseBillQueryOwe().parse(xml);
    }

    private void parse(String xml) {
        Document doc;//报文转成doc对象
        Map<String, Object> map;
        try {
            doc = DocumentHelper.parseText(xml);
            Element root = doc.getRootElement().element("Body");//获取根元素，准备递归解析这个XML树
            if (root.elements().size() > 0) {
                Element element = root.element("multiRef").element("respCode");
                if (CheckUtil.isNotBlank(element)) {
                    if ("0".equals(element.getTextTrim())) {
                        System.out.println("接口返回成功");
                        System.out.println(root.element("multiRef").element("content").getTextTrim());
                    }
                }

            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }


}
