package com.example.item.tools.webService.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author HXM
 * @date 2021年04月01日 16:51
 */

@Data
@XStreamAlias("soapenv:Envelope")
public class GroupBase {

    @XStreamAlias("soapenv:Body")
    private Body Body;

    @Data
    public static class Body {
        @XStreamAlias("ns1:callWebServiceResponse")
        private CallWebServiceResponse CallWebServiceResponse;
        @XStreamAlias("multiRef")
        private UserGroupBaseVO userGroupBaseVO;
    }

    @Data
    public static class CallWebServiceResponse {
        @XStreamAlias("callWebServiceReturn")
        private String callWebServiceReturn;
    }

    @Data
    public static class UserGroupBaseVO {
        @XStreamAlias("content")
        private String content;
        @XStreamAlias("respCode")
        private String respCode;
        @XStreamAlias("srvFunction")
        private String srvFunction;
        @XStreamAlias("srvModule")
        private String srvModule;
    }
}


