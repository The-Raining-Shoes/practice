package com.example.item.tools.webService.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;

import java.util.List;

/**
 * 接口返回实体
 *
 * @author MaoHao
 * @date 2021年04月02日 9:12
 */
@Data
@XStreamAlias("SAMResponse")
public class BillQueryOweVO {

    @XStreamAlias("Service-Information")
    private Information information;

    @Data
    public static class Information {
        @XStreamAlias("Service-Result-Code")
        private String serviceResultCode;

        @XStreamAlias("Bill-Query-Information")
        private BillQueryInformation billQueryInformation;
    }

    @Data
    public static class BillQueryInformation {
        @XStreamAlias("Acct-ID")
        private String acctId;
        @XStreamAlias("Acc-Nbr")
        private String accNbr;
        @XStreamAlias("PaymentFlag")
        private String paymentFlag;
        @XStreamAlias("Fee-Billing-Cycle")
        private FeeBillingCycle feeBillingCycle;
    }

    @Data
    public static class FeeBillingCycle {
        @XStreamAlias("Billing-Cycle-ID")
        private String BillingCycleID;
        @XStreamAlias("Acct_Item_Group")
        private AcctItemGroup acctItemGroup;
        @XStreamAlias("Charge-Payed")
        private String ChargePayed;
        @XStreamAlias("Sum_Charge")
        private String SumCharge;
    }

    @Data
    public static class AcctItemGroup {
        @XStreamAlias("Acct_Item_Group-Id")
        private String AcctItemGroupId;
        @XStreamImplicit(itemFieldName = "Acct-Item-Type")
        List<AcctItemType> acctItemTypes;
    }

    @Data
    public static class AcctItemType {
        @XStreamAlias("Acct-Item-Type-Name")
        private String AcctItemTypeName;
        @XStreamAlias("Acct-Item-Charge")
        private String AcctItemCharge;
    }
}

