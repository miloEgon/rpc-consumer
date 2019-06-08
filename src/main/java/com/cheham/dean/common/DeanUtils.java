package com.cheham.dean.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class DeanUtils {

    public static final int PORT = 9090;

    private static final Logger log = LoggerFactory.getLogger(DeanUtils.class);

    public static String chooseTarget(List<String> providers) {
        if (null == providers || providers.size() == 0) {
            throw new IllegalArgumentException();
        }
        return providers.get(0);
    }

    public static List<String> lookUpProviders() {
        List<String> list = new ArrayList<String>();
        list.add("127.0.0.1");
        list.add("122.112.216.37");
        return list;
    }

    public static Object handle(Object object) {
        List<String> list = lookUpProviders();
        String address = chooseTarget(list);
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            socket = new Socket(address, DeanUtils.PORT);
            //将请求序列化
            oos = new ObjectOutputStream(socket.getOutputStream());
            //发送请求
            oos.writeObject(object);
            //将返回值反序列化
            ois = new ObjectInputStream(socket.getInputStream());
            Object resp = ois.readObject();

            return resp;
        } catch (Exception e) {
            log.info("fail",e);
            e.printStackTrace();
        } finally {
            try {
                ois.close();
                oos.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
