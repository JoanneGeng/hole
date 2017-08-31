package TestURL;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Time      2017/9/1 上午12:26
 * Author    JoanneGeng
 * File      TestDemo.java
 * Software  IntelliJ IDEA
 */
public class TestDemo {

    public static void main(String[] args) throws MalformedURLException {
        System.out.println("----------—————-正则---------------------");
        System.out.println(getImgUrl("http://wzw.zw.com?sss/www"));
        System.out.println(getImgUrl("http://wzw/www"));
        System.out.println(getImgUrl("http://sfs.zw.com?sss/www/sss"));
        System.out.println(getImgUrl("http://root:111@www.eidjfnf.com:80/data/info.html?query=1&data=/path/resovle"));
        System.out.println(getImgUrl("http://root:111@www.jahdocnd.com:80?www=sss/data/info.html?query=1&data=/path/resovle"));
        System.out.println("----------————-URL类---------------------");
        printUrl(new URL("http://sfs.zw.com?sss/www/sssindex.html?language=cn#j2se"));
        printUrl(new URL("http://root:12234@www.springtour.com:80?www=sss/data/info.html?query=1&data=/path/resovle"));
    }

    private static void printUrl(URL url) {
        System.out.println("URL 为：" + url.toString());
        System.out.println("协议为：" + url.getProtocol());
        System.out.println("验证信息：" + url.getAuthority());
        System.out.println("文件名及请求参数：" + url.getFile());
        System.out.println("主机名：" + url.getHost());
        System.out.println("路径：" + url.getPath());
        System.out.println("端口：" + url.getPort());
        System.out.println("默认端口：" + url.getDefaultPort());
        System.out.println("请求参数：" + url.getQuery());
        System.out.println("定位位置：" + url.getRef());
    }

    private static String getImgUrl(String url){
        String regxp = "[a-zA-z]+://[^\\s]" +"(.+?)/";
        Pattern pattern = Pattern.compile(regxp);
        Matcher matcher = pattern.matcher(url); //判空，不想写了
        StringBuffer sb = new StringBuffer();
        boolean result1 = matcher.find();
        while (result1) {
            matcher.appendReplacement(sb, "");
            result1 = matcher.find();
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

}
