package com.cheham.dean.app;

import com.cheham.dean.service.Calculater;
import com.cheham.dean.service.CalculatorRemoteImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComsumerApp {

    private static Logger logger = LoggerFactory.getLogger(ComsumerApp.class);

    public static void main(String[] args) {
        Calculater calculater = new CalculatorRemoteImpl();
        int result1 = calculater.add(25, 487);
        logger.info("结果是："+result1);
        int result2 = calculater.subtract(100, 1);
        logger.info("结果是："+result2);
    }
}
