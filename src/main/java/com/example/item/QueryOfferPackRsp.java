package com.example.item;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class QueryOfferPackRsp {

    @SerializedName("offerpackid")
    private String offerPackId;

    @SerializedName("totalmessage")
    private String totalMessage;

    @SerializedName("speedrule")
    private String speedRule;

    @SerializedName("totalupstream")
    private String totalUpstream;

    @SerializedName("totaldownstrem")
    private String totalDownstream;

    @SerializedName("otherdesc")
    private String otherDesc;

    @SerializedName("exceedtariff")
    private String exceedTariff;

    @SerializedName("totalflow")
    private String totalFlow;

    @SerializedName("totalminu")
    private String totalMinute;

    @SerializedName("packrecord")
    private List<PackRecordLs> packRecord;

    @SerializedName("offerpackname")
    private String offerPackName;

    @Data
    public static class PackRecordLs {

        @SerializedName("totalminu")
        private String totalMinute;

        @SerializedName("offermessage")
        private String offerMessage;

        @SerializedName("offername")
        private String offerName;

        @SerializedName("offerflow")
        private String offerFlow;

        @SerializedName("offerupstream")
        private String offerUpstream;

        @SerializedName("offermms")
        private String offerMms;

        @SerializedName("offerid")
        private String offerId;

        @SerializedName("offerpresent")
        private String offerPresent;

        @SerializedName("membertype")
        private String memberType;

        @SerializedName("offerfee")
        private String offerFee;

        @SerializedName("effdate")
        private String effDate;

        @SerializedName("expdate")
        private String expDate;

        @SerializedName("offerminu")
        private String offerMinute;

    }

}
