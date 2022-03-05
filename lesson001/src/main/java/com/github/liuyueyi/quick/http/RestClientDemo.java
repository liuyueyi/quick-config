package com.github.liuyueyi.quick.http;

import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author yihui
 * @data 2022/3/5
 */
public class RestClientDemo {
    private static final String CONFIG_URL = "http://127.0.0.1:8081/config.properties";


    /**
     * 直接使用python启动一个简单的http服务器, 进行模拟这个case
     * - 进入 resources 目录下
     * - python3 -m http.server 8081
     * - python2 -m SimpleHTTPServer 8081
     *
     * @throws Exception
     */
    public static void getConfigByUrl() throws Exception {
        URL url = new URL(CONFIG_URL);
        String configs;
        try (InputStream stream = url.openStream()) {
            byte[] bytes = new byte[stream.available()];
            stream.read(bytes);
            configs = new String(bytes, StandardCharsets.UTF_8);
        }
        System.out.println("配置中心内容：\n---------->\n" + configs);
        System.out.println("<----------------");
    }

    public static void main(String[] args) throws Exception {
        getConfigByUrl();
    }
}
