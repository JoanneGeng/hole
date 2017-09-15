package com.tc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Time      2017/9/1 上午12:26
 * Author    JoanneGeng
 * File      TestDemo.java
 * Software  IntelliJ IDEA
 * 正则提取html标签中的element
 */
public class TestDemo {

    public static void main(String[] args) {
        String str5 = "<data><item>3</item><item>5</item></data>";
        String str3 = "<data><item>fff</item></data>";
        String str4 = "<data><item>";
        String str6 = "";
        String str7 = "fff</item></data>";
//        System.out.println(split(str3));
//        System.out.println(split(str4));
//        System.out.println(split(str5));
//        System.out.println(split(str6));
//        System.out.println(split(str7));
        System.out.println(pattern1(str5));
        System.out.println(pattern2(str5));
        System.out.println(split(str5));
    }
    private static List<String> split(String string) {
        String[] str = string.replaceAll("^<(\\S*?)[^>]*><(\\S*?)[^>]*>" ,"")
                .split("<(\\S*?)[^>]*><(\\S*?)[^>]*>");
        List<String> stringList = Arrays.asList(str);
        return stringList;
    }

    private static List<String> pattern1(String string) {
        List<String> stringList = new ArrayList<>();
        Pattern pattern = Pattern.compile("(?<=>).*?(?=<)");
        Matcher m = pattern.matcher(string);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            if (!m.group().equals("")) {
                stringList.add(m.group());
            }
        }
        return stringList;
    }

    private static List<String> pattern2(String string) {
        List<String> stringList = new ArrayList<>();
        Pattern pattern = Pattern.compile("<item>(.+?)</item>");
        Matcher m = pattern.matcher(string);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            stringList.add(m.group(1));
        }
        return stringList;
    }

}
