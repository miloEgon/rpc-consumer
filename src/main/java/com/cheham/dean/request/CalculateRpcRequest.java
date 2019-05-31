package com.cheham.dean.request;

import java.io.Serializable;

public class CalculateRpcRequest implements Serializable {

    private static final long serialVersionUID = 7503710091945320739L;

    private String method;

    private Integer param1;

    private Integer param2;

    public String getMethod() {
        return method;
    }

    public Integer getParam1() {
        return param1;
    }

    public Integer getParam2() {
        return param2;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setParam1(Integer param1) {
        this.param1 = param1;
    }

    public void setParam2(Integer param2) {
        this.param2 = param2;
    }

    @Override
    public String toString() {
        return "CalculateRpcRequest{" +
                "method='" + method + '\'' +
                ", param1=" + param1 +
                ", param2=" + param2 +
                '}';
    }
}
