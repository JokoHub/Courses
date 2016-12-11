package com.joko.IBA.SocketsExample;

import java.io.*;
import java.net.Socket;

/**
 * Created by Joko on 11.12.2016.
 */
public class Client {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("127.0.0.1", 5432);
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println(reader.readLine());
            reader.close();
            socket.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
