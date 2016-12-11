package com.joko.IBA.SocketsExample;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Joko on 11.12.2016.
 */
public class Server {

    public static void main(String[] args) {
        ServerSocket s = null;
        try{
            s = new ServerSocket(5432);
        } catch (IOException e){
            e.printStackTrace();
        }

        while (true){
            try{
                Socket s1 = s.accept();
                OutputStream outputStream = s1.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
                writer.write("Some random message");
                writer.close();
                s1.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
