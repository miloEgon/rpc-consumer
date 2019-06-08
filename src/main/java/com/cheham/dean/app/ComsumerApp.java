package com.cheham.dean.app;

import com.cheham.dean.service.Calculater;
import com.cheham.dean.service.CalculatorRemoteImpl;
import com.cheham.dean.service.Gateway;
import com.cheham.dean.service.GatewayRemoteImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComsumerApp {

    private static Logger logger = LoggerFactory.getLogger(ComsumerApp.class);

    public static void main(String[] args) {
        Calculater calculater = new CalculatorRemoteImpl();
        Object result1 = calculater.add(25, 487);
        logger.info("结果是："+result1);
        Object result2 = calculater.subtract(100, 1);
        logger.info("结果是："+result2);
//        Gateway gateway = new GatewayRemoteImpl();
//        Object result = gateway.findGatewayById("CXAA18AAA0100071");
//        logger.info("结果是："+result);
    }


}
