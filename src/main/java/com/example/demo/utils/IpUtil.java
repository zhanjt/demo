package com.example.demo.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <功能说明>
 *
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/7/29  | 修改内容
 */
public class IpUtil {

    public static void main(String[] args) throws UnknownHostException {
        //获取当前服务器ip
        InetAddress ia = InetAddress.getLocalHost();
        String localIp=ia.getHostAddress();
        System.out.println(localIp);
    }
}
