package com.cheham.dean.service;

import com.cheham.dean.common.DeanUtils;
import com.cheham.dean.request.GatewayRpcBean;

public class GatewayRemoteImpl implements Gateway {

    public Object findGatewayById(String id) {
        return DeanUtils.handle(generate(id,"findGatewayById"));
    }

    private GatewayRpcBean generate(String id, String method) {
        GatewayRpcBean bean = new GatewayRpcBean();
        bean.setMethod(method);
        bean.setId(id);
        return bean;
    }


}
