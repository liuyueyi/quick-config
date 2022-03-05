package com.github.liuyueyi.quick.rmi;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalTime;

/**
 * 配置中心服务端
 *
 * @author yihui
 * @data 2022/3/5
 */
public class RmiServerDemo {
    public static class ConfigServer extends UnicastRemoteObject implements ConfigApi {
        public ConfigServer() throws RemoteException {
            super();
        }

        @Override
        public String configs() throws RemoteException {
            System.out.println("接收到请求:" + LocalTime.now());
            try (InputStream stream = this.getClass().getClassLoader().getResourceAsStream("config.properties")) {
                byte[] bytes = new byte[stream.available()];
                stream.read(bytes);
                return new String(bytes, StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
                return "500 error";
            }
        }
    }


    /**
     * 基于rmi提供一个配置中心服务
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.createRegistry(8082);
        ConfigServer server = new ConfigServer();
        registry.bind("config", server);
        System.out.println("服务已启动");
        Thread.currentThread().join();
    }

}
