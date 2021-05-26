package com.example.item.tools.webService.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * 智能账单BSN接口
 *
 * @author MaoHao
 * @date 2021年04月02日 9:55
 */
@Data
@XStreamAlias("soapenv:Envelope")
public class GetCusFeeVO {

    @XStreamAlias("soapenv:Body")
    private Body body;

    @Data
    public static class Body {
        @XStreamAlias("ns1:getCustFeeResponse")
        private CustFeeResponse callWebServiceResponse;
        @XStreamAlias("multiRef")
        private CustReturnBaseInfo custReturnBaseInfo;
    }

    @Data
    public static class CustFeeResponse {
        @XStreamAlias("getCustFeeReturn")
        private String getCustFeeReturn;
    }

    @Data
    public static class CustReturnBaseInfo {
        @XStreamAlias("billingCycleName")
        private String billingCycleName;
        @XStreamAlias("code")
        private String code;
        @XStreamAlias("curFeeTotal")
        private String curFeeTotal;
        @XStreamAlias("curPaidFee")
        private String curPaidFee;
        @XStreamAlias("curPayableFee")
        private String curPayableFee;
        @XStreamAlias("custCode")
        private String custCode;
        @XStreamAlias("custId")
        private String custId;
        @XStreamAlias("custName")
        private String custName;
        @XStreamAlias("description")
        private String description;
        @XStreamAlias("discountAmount")
        private String discountAmount;
        @XStreamAlias("discountFee")
        private String discountFee;
        @XStreamAlias("offerAmount")
        private String offerAmount;
        @XStreamAlias("offerFee")
        private String offerFee;
        @XStreamAlias("otherAmount")
        private String otherAmount;
        @XStreamAlias("otherCountAmount")
        private String otherCountAmount;
        @XStreamAlias("otherCountFee")
        private String otherCountFee;
        @XStreamAlias("otherFee")
        private String otherFee;
    }

}
