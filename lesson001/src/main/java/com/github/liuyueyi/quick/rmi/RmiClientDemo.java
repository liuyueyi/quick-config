package com.github.liuyueyi.quick.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * 客户端
 *
 * @author yihui
 * @data 2022/3/5
 */
public class RmiClientDemo {

    /**
     * 通过rmi访问服务端接口
     */
    public static void getConfigByRmi() throws Exception {
        Registry registry = LocateRegistry.getRegistry(8082);
        ConfigApi configApi = (ConfigApi) registry.lookup("config");
        String configs = configApi.configs();
        System.out.println("配置中心内容：\n---------->\n" + configs);
        System.out.println("<----------------");
    }

    public static void main(String[] args) throws Exception {
        getConfigByRmi();
    }
}
