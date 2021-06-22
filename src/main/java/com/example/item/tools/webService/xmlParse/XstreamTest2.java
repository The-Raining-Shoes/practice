package com.example.item.tools.webService.xmlParse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.io.xml.DomDriver;
import lombok.Data;

import java.util.List;

/**
 * 集团累积量查询
 *
 * @author HXM
 * @date 2021年03月31日 9:25
 */
public class XstreamTest2 {

    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                     "<SAMResponse>\n" +
                     "  <Service-Information>\n" +
                     "    <Service-Result-Code>0</Service-Result-Code>\n" +
                     "    <Product_OFF_info>\n" +
                     "      <Product-Offer-Id>830000000020008583</Product-Offer-Id>\n" +
                     "      <ProdOfferInstanceId>310162685510</ProdOfferInstanceId>\n" +
                     "      <Product_OFF_Name>5G畅享融合129元套餐关联包</Product_OFF_Name>\n" +
                     "      <Offer-Type>22</Offer-Type>\n" +
                     "      <Respond-Ratable-Query>\n" +
                     "        <Owner-Type>2</Owner-Type>\n" +
                     "        <Owner-ID>310162685510</Owner-ID>\n" +
                     "        <Ratable-Resource-ID>131100</Ratable-Resource-ID>\n" +
                     "        <Ratable-Resource-name>国内语音时长</Ratable-Resource-name>\n" +
                     "        <BeginTime>20210301000000</BeginTime>\n" +
                     "        <EndTime>20210331235959</EndTime>\n" +
                     "        <Ratable_Amount>200</Ratable_Amount>\n" +
                     "        <Balance-Amount>0</Balance-Amount>\n" +
                     "        <Usage-Amount>200</Usage-Amount>\n" +
                     "        <UnitType_Id>1</UnitType_Id>\n" +
                     "      </Respond-Ratable-Query>\n" +
                     "    </Product_OFF_info>\n" +
                     "    <Product_OFF_info>\n" +
                     "      <Product-Offer-Id>830000000020001672</Product-Offer-Id>\n" +
                     "      <ProdOfferInstanceId>310162685505</ProdOfferInstanceId>\n" +
                     "      <Product_OFF_Name>201910-5G畅享129元套餐201910</Product_OFF_Name>\n" +
                     "      <Offer-Type>21</Offer-Type>\n" +
                     "      <Respond-Ratable-Query>\n" +
                     "        <Owner-Type>2</Owner-Type>\n" +
                     "        <Owner-ID>310162685505</Owner-ID>\n" +
                     "        <Ratable-Resource-ID>131100</Ratable-Resource-ID>\n" +
                     "        <Ratable-Resource-name>国内语音时长</Ratable-Resource-name>\n" +
                     "        <BeginTime>20210301000000</BeginTime>\n" +
                     "        <EndTime>20210331235959</EndTime>\n" +
                     "        <Ratable_Amount>500</Ratable_Amount>\n" +
                     "        <Balance-Amount>0</Balance-Amount>\n" +
                     "        <Usage-Amount>500</Usage-Amount>\n" +
                     "        <UnitType_Id>1</UnitType_Id>\n" +
                     "      </Respond-Ratable-Query>\n" +
                     "      <Respond-Ratable-Query>\n" +
                     "        <Owner-Type>2</Owner-Type>\n" +
                     "        <Owner-ID>310162685505</Owner-ID>\n" +
                     "        <Ratable-Resource-ID>332100</Ratable-Resource-ID>\n" +
                     "        <Ratable-Resource-name>国内流量(结转入)</Ratable-Resource-name>\n" +
                     "        <BeginTime>20210301000000</BeginTime>\n" +
                     "        <EndTime>20210331235959</EndTime>\n" +
                     "        <Ratable_Amount>31457280</Ratable_Amount>\n" +
                     "        <Balance-Amount>24714159</Balance-Amount>\n" +
                     "        <Usage-Amount>6743121</Usage-Amount>\n" +
                     "        <UnitType_Id>3</UnitType_Id>\n" +
                     "      </Respond-Ratable-Query>\n" +
                     "      <Respond-Ratable-Query>\n" +
                     "        <Owner-Type>2</Owner-Type>\n" +
                     "        <Owner-ID>310162685505</Owner-ID>\n" +
                     "        <Ratable-Resource-ID>331100</Ratable-Resource-ID>\n" +
                     "        <Ratable-Resource-name>国内流量</Ratable-Resource-name>\n" +
                     "        <BeginTime>20210301000000</BeginTime>\n" +
                     "        <EndTime>20210331235959</EndTime>\n" +
                     "        <Ratable_Amount>31457280</Ratable_Amount>\n" +
                     "        <Balance-Amount>31457280</Balance-Amount>\n" +
                     "        <Usage-Amount>0</Usage-Amount>\n" +
                     "        <UnitType_Id>3</UnitType_Id>\n" +
                     "      </Respond-Ratable-Query>\n" +
                     "    </Product_OFF_info>\n" +
                     "  </Service-Information>\n" +
                     "</SAMResponse>\n";
        XStream xStream = new XStream(new DomDriver());
        xStream.processAnnotations(DataList.class);
        DataList dataList = (DataList) xStream.fromXML(xml);
        System.out.println(dataList);
    }

    @Data
    @XStreamAlias("SAMResponse")
    public static class DataList {
        @XStreamAlias("Service-Information")
        private Information information;

        @Data
        public static class Information {
            @XStreamAlias(value = "Service-Result-Code")
            private String resultCode;
            @XStreamImplicit(itemFieldName = "Product_OFF_info")
            List<Information1> info;
        }

        @Data
        public static class Information1 {
            @XStreamAlias(value = "Product-Offer-Id")
            private String offerId;
            @XStreamAlias(value = "ProdOfferInstanceId")
            private String instanceId;
            @XStreamAlias(value = "Product_OFF_Name")
            private String produceOffName;
            @XStreamAlias(value = "Offer-Type")
            private String offerType;
            @XStreamImplicit(itemFieldName = "Respond-Ratable-Query")
            private List<RatableQuery> ratableQuery;
        }

        @Data
        public static class RatableQuery {
            @XStreamAlias(value = "Owner-Type")
            private String ownerType;
            @XStreamAlias(value = "Owner-ID")
            private String ownerId;
            @XStreamAlias(value = "Ratable-Resource-ID")
            private String ratableResourceId;
            @XStreamAlias(value = "Ratable-Resource-name")
            private String ratableResourceName;
            @XStreamAlias(value = "BeginTime")
            private String beginTime;
            @XStreamAlias(value = "EndTime")
            private String endTime;
            @XStreamAlias(value = "Ratable_Amount")
            private String ratableAmount;
            @XStreamAlias(value = "Balance-Amount")
            private String balanceAmount;
            @XStreamAlias(value = "Usage-Amount")
            private String usageAmount;
            @XStreamAlias(value = "UnitType_Id")
            private String unitTypeId;
        }
    }

}
