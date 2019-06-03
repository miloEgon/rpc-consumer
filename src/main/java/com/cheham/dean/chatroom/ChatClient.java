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

//    private static final String HOST = "10.10.2.56";
    private static final String HOST = "127.0.0.1";

    private static final int PORT = 12306;

    private static final Logger log = LoggerFactory.getLogger(ChatClient.class);

    private InetAddress localAddr = null;

    private String localHost = null;

    public static void main(String[] args) {
        new ChatClient().run();
    }

    public String getLocalHost() {
        try {
            localAddr = InetAddress.getLocalHost();
            localHost = localAddr.getHostAddress();
            if (localHost.equals(HOST)) return "客户端";
            else return localHost;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getServerHost() {
        if (HOST.equals("127.0.0.1"))
            return "服务端";
        return HOST;
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
            String send_msg = null;
            String receive_msg = null;
            do {
                System.out.print(getLocalHost()+"说：");
                input = new BufferedReader(new InputStreamReader(System.in));
                send_msg = input.readLine();
                sender.println(send_msg); //发送消息
                sender.flush();

                if (send_msg.equalsIgnoreCase("bye")) break;

                receive_msg = receiver.readLine();
                log.info(String.format(getServerHost()+"说：%s", receive_msg)); //接受回复

                if (receive_msg.equalsIgnoreCase("bye")) break;
            } while (StringUtils.isNotEmpty(send_msg));
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
