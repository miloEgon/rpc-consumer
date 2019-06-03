package com.cheham.dean.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    private static final Logger log = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) {
        new Client().run();
    }

    public void run() {
        try {
            Socket socket = new Socket("127.0.0.1",8888);
            final BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            final Scanner input = new Scanner(System.in);

            Thread readThread = new Thread(){
                @Override
                public void run() {
                    while (true) {
                        String msg = null;
                        try {
                            msg = br.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        log.info("服务器说："+msg);
                    }
                }
            };
            Thread writeThread = new Thread(){
                @Override
                public void run() {
                    while (true) {
                        try {
                            bw.write(input.next()+"\n");
                            bw.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            readThread.start();
            writeThread.start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
