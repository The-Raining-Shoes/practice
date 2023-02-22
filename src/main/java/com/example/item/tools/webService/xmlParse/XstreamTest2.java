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
        String xml = "";
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
