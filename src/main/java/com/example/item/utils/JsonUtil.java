package com.example.item.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Java对象和JSON字符串相互转化工具类
 */
public final class JsonUtil {

    private JsonUtil() {
    }

    private static Gson gson = new GsonBuilder().registerTypeAdapter(new TypeToken<Map<String, Object>>() {
    }.getType(), (JsonDeserializer<Map<String, Object>>) (json, typeOfT, context) -> {
        Map<String, Object> map = new HashMap<>();
        JsonObject jsonObject = json.getAsJsonObject();
        Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
        for (Map.Entry<String, JsonElement> entry : entrySet) {
            Object ot = entry.getValue();
            if (ot instanceof JsonPrimitive) {
                map.put(entry.getKey(), ((JsonPrimitive) ot).getAsString());
            } else {
                map.put(entry.getKey(), ot);
            }
        }
        return map;
    }).setDateFormat("yyyy-MM-dd HH:mm").create();

    /**
     * 对象转换成json字符串
     *
     * @param obj Object
     * @return String
     */
    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    /**
     * json字符串转成对象
     *
     * @param str  String
     * @param type Type
     * @return T
     */
    public static <T> T fromJson(String str, Type type) {
        return gson.fromJson(str, type);
    }

    /**
     * json字符串转成对象
     *
     * @param str  String
     * @param type Class<T>
     * @return T
     */
    public static <T> T fromJson(String str, Class<T> type) {
        return gson.fromJson(str, type);
    }

}
