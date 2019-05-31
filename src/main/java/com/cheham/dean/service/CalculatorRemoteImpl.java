package com.cheham.dean.service;

import com.cheham.dean.request.CalculateRpcRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class CalculatorRemoteImpl implements Calculater {
    private static final int PORT = 9090;

    private static Logger logger = LoggerFactory.getLogger(CalculatorRemoteImpl.class);

    public int subtract(int a, int b) {
        return calc(a,b,"subtract");
    }

    public int add(int a, int b) {
        return calc(a,b,"add");
    }

    private int calc(int a, int b, String method) {
        List<String> list = lookUpProviders();
        String address = chooseTarget(list);

        try {
            Socket socket = new Socket(address, PORT);
            //将请求序列化
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            //发送请求
            CalculateRpcRequest request = generate(a, b, method);
            oos.writeObject(request);
            //将返回值反序列化
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Object response = ois.readObject();

            if (response instanceof Integer) {
                return (Integer) response;
            } else {
                throw new InternalError();
            }
        } catch (Exception e) {
            logger.info("fail",e);
            throw new InternalError();
        }
    }

    private CalculateRpcRequest generate(int a, int b, String method) {
        CalculateRpcRequest request = new CalculateRpcRequest();
        request.setMethod(method);
        request.setParam1(a);
        request.setParam2(b);
        return request;
    }

    private String chooseTarget(List<String> providers) {
        if (null == providers || providers.size() == 0) {
            throw new IllegalArgumentException();
        }
        return providers.get(1);
    }

    private List<String> lookUpProviders() {
        List<String> list = new ArrayList<String>();
        list.add("127.0.0.1");
        list.add("122.112.216.37");
        return list;
    }


}
