package com.example.item.method;

/**
 * 处理重复参数
 */
public class DealDoubleUrl {
    
    public static String dealDoubleParam(String organUrl, String tagParam, String tagValue) {
        int index = organUrl.indexOf("?");
        String url;
        // 链接无?携带参数
        if (index == -1) {
            url = organUrl.concat("?").concat(tagParam + "=" + tagValue);
        } else {
            url = organUrl.substring(0, index);
            String params = organUrl.substring(index + 1);
            if (params.length() == 0) {
                url = organUrl.concat(tagParam + "=" + tagValue);
                return url;
            }
            String[] split = params.split("&");
            boolean ifFind = false;
            for (int i = 0; i < split.length; i++) {
                // 相同参数不重复处理
                if (url.contains(split[i].split("=")[0])) {
                    continue;
                }
                url = url.concat(i == 0 ? "?" : "&");
                if (split[i].contains(tagParam)) {
                    ifFind = true;
                    int urlIndex = split[i].indexOf("=");
                    if (urlIndex == -1) {
                        url = url.concat(split[i]).concat("=").concat(tagValue);
                    } else {
                        url = url.concat(split[i].substring(0, split[i].indexOf("=") + 1).concat(tagValue));
                    }
                } else {
                    url = url.concat(split[i]);
                }
            }
            if (!ifFind) {
                String str = "&" + tagParam + "=" + tagValue;
                url = url.concat(str);
            }
        }
        return url;
    }

}
