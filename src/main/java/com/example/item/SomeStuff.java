package com.example.item;

import java.util.Hashtable;

/**
 * @author HXM
 * @date 2020年04月13日 9:18
 */
public class SomeStuff {
    public static void main(String[] args) {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("String", "String");
        System.out.println(hashtable.get("String"));
    }

}