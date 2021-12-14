package com.example.item.utils;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 上下文获取
 *
 */
public class ContextUtil {

    /**
     * 获取用户真实IP地址，不使用request.getRemoteAddr()的原因是有可能用户使用了代理软件方式避免真实IP地址,
     * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值
     *
     * @return ip
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (isUnknown(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (isUnknown(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (isUnknown(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (isUnknown(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (isUnknown(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (isUnknown(ip)) {
            ip = request.getRemoteAddr();
        }
        // 不是空取第一个
        if (!isUnknown(ip)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            if (ip.contains(",")) {
                ip = ip.split(",")[0];
            }
        }
        return ip;
    }

    private static boolean isUnknown(String ip) {
        return CheckUtil.isBlank(ip) || "unknown".equalsIgnoreCase(ip);
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes =
            (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            throw new RuntimeException();
        }
        return requestAttributes.getRequest();
    }

    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    public static Pageable getPageRequest() {
        return getPageRequest(Sort.unsorted());
    }


    /**
     * 获取分页参数
     *
     * @param sort 排序对象
     * @return Pageable
     */
    public static Pageable getPageRequest(Sort sort) {
        try {
            int pageNo = Integer.parseInt(getRequest().getParameter("pageNo"));
            int pageSize = Integer.parseInt(getRequest().getParameter("pageSize"));
            return PageRequest.of(pageNo - 1, pageSize, sort);
        } catch (Exception e) {
            return PageRequest.of(0, 10, sort);
        }

    }

    public static void setReqSerial(String serial) {
        REQ_SERIAL.set(serial);
    }

    public static String getReqSerial() {
        if (REQ_SERIAL.get() == null) {
            setReqSerial(UUID.randomUUID().toString().replaceAll("-", ""));
        }
        return REQ_SERIAL.get();
    }

    public static ArrayList<String> getReqOperationTableNames() {
        return REQ_OPERATION_TABLE_NAME.get();
    }

    public static String getReqOperationTableNameStr() {
        ArrayList<String> tableNames = REQ_OPERATION_TABLE_NAME.get();
        if (Objects.nonNull(tableNames)) {
            return String.join(",", tableNames);
        }
        return null;
    }

    public static void addOperationTableName(String name) {
        ArrayList<String> tableNames = REQ_OPERATION_TABLE_NAME.get();
        if (Objects.isNull(tableNames)) {
            tableNames = new ArrayList<>();
        } else {
            if (tableNames.contains(name)) {
                return;
            }
        }
        tableNames.add(name);
        REQ_OPERATION_TABLE_NAME.set(tableNames);
    }

    // 请求流水号
    private static ThreadLocal<String> REQ_SERIAL = new ThreadLocal<>();
    private static ThreadLocal<ArrayList<String>> REQ_OPERATION_TABLE_NAME = new ThreadLocal<>();

    private static String getValue(String key, Map<String, Object> map) {
        if (map.containsKey(key)) {
            return null == map.get(key) ? null : map.get(key).toString();
        }
        return null;
    }

    private static Integer getIntValue(String key, Map<String, Object> map) {
        if (map.containsKey(key)) {
            return null == map.get(key) ? null : Integer.valueOf(map.get(key).toString());
        }
        return null;
    }

    @Data
    private static class CurrUserBean {
        private String address;
        private String comment;
        private String del;
        private String email;
        private int errorCount;
        private String fullPing;
        private String hobby;
        private int id;
        private String isRealName;
        private int level;
        private String msn;
        private String name;
        private String partyPost;
        private String personalityUserName;
        private String politicalOutlook;
        private String postCode;
        private String sex;
        private String simplePing;
        private int sort;
        private String userName;
    }

    @NoArgsConstructor
    @Data
    private static class PrivilegesBean {
        /**
         * checked : false
         * children : []
         * code : jjjc_test
         * icon : www.baidu.com
         * iconClass : www.baidu.com
         * id : 2157
         * leaf : false
         * link : www.baidu.com
         * sort : 1
         * text : 纪检监察test
         */
        private boolean checked;
        private String code;
        private String icon;
        private String iconClass;
        private Integer id;
        private Boolean leaf;
        private String link;
        private int sort;
        private String text;
        private List<PrivilegesBean> children;

    }


    @NoArgsConstructor
    @Data
    private static class MenuGroupsBean {
        /**
         * cname : 纪检监察测试组
         * ename : jjjc_test_Group
         * id : 561
         * isDefault : 1
         * sort : 1
         * status : 1
         */

        private String cname;
        private String ename;
        private int id;
        private int isDefault;
        private int sort;
        private int status;
    }


    @NoArgsConstructor
    @Data
    private static class ButtonsBean {
        /**
         * buttons -> [{"code":"tt2","name":"tt2","url":"tt2"}]
         */
        private String code;
        private String name;
        private String url;
    }
}
