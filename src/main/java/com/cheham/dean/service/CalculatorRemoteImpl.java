package com.cheham.dean.service;

import com.cheham.dean.common.DeanUtils;
import com.cheham.dean.request.CalculateRpcRequest;

public class CalculatorRemoteImpl implements Calculater {

    public Object subtract(int a, int b) {
        return DeanUtils.handle(generate(a,b,"subtract"));
    }

    public Object add(int a, int b) {
        return DeanUtils.handle(generate(a,b,"add"));
    }

    private CalculateRpcRequest generate(int a, int b, String method) {
        CalculateRpcRequest bean = new CalculateRpcRequest();
        bean.setMethod(method);
        bean.setParam1(a);
        bean.setParam2(b);
        return bean;
    }

}
