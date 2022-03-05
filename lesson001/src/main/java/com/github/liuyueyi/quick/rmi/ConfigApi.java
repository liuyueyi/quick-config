package com.github.liuyueyi.quick.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author yihui
 * @data 2022/3/5
 */
public interface ConfigApi extends Remote {
    String configs() throws RemoteException;
}

