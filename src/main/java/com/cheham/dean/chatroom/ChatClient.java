package com.cheham.dean.chatroom;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {

    private static final String HOST = "10.10.2.56";

    private static final int PORT = 12306;

    private static final Logger log = LoggerFactory.getLogger(ChatClient.class);

    public static void main(String[] args) {
        new ChatClient().run();
    }

    public String getLocalhost() {
        try {
            InetAddress address = InetAddress.getLocalHost();
            return address.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void run() {
        Socket socket = null;
        PrintWriter sender = null;
        BufferedReader input = null;
        BufferedReader receiver = null;
        try {
            socket = new Socket(HOST, PORT); //创建套接字
            sender = new PrintWriter(socket.getOutputStream()); //发送者
            receiver = new BufferedReader(new InputStreamReader(socket.getInputStream())); //接受者
            String msg = null;
            do {
                System.out.print(getLocalhost()+"说：");
                input = new BufferedReader(new InputStreamReader(System.in));
                msg = input.readLine();
                if (msg.equalsIgnoreCase("bye")) break;
                sender.println(msg); //发送消息
                sender.flush();
                log.info(String.format(HOST+"说：%s", receiver.readLine())); //接受回复
            } while (StringUtils.isNotEmpty(msg));
            receiver.close();
            input.close();
            sender.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                receiver.close();
                input.close();
                sender.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }





}
