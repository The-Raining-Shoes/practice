//package com.example.item.tools.webService;
//
//
//import javax.xml.namespace.QName;
//import javax.xml.ws.Service;
//import java.io.IOException;
//import java.net.URL;
//
///**
// * @author HXM
// * @date 2021年03月12日 11:15
// */
//public class ServiceToWebService {
//
//    public static void main(String[] args) throws IOException {
//        //创建WSDL的URL，注意不是服务地址
//        URL url = new URL("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl");
//        //创建服务名称
//        //1.namespaceURI - 命名空间地址 (wsdl文档中的targetNamespace)
//        //2.localPart - 服务视图名  ，wsdl文档中：<wsdl:service name="MobileCodeWS">
//        QName qname = new QName("http://WebXml.com.cn/", "MobileCodeWS");
//        //wsdlDocumentLocation - wsdl地址 ，serviceName - 服务名称
//        Service service = Service.create(url, qname);
//        //获取服务实现类  wsdl中：<wsdl:portType name="MobileCodeWSSoap">
//        MobileCodeWSSoap mobileCodeWSSoap = service.getPort(MobileCodeWSSoap.class);
//        //调用查询方法
//        String result = mobileCodeWSSoap.getMobileCodeInfo("1866666666", "");
//        System.out.println(result);
//    }
//
//}
