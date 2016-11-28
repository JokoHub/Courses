package com.joko.tests;

import java.io.*;

/**
 * Created by User on 02.09.2016.
 */
public class InputStreamChange {

    public static void main(String[] args) throws IOException
    {
        //кладем данные в строку
        StringBuilder sb = new StringBuilder();
        sb.append("Lena").append('\n');
        sb.append("Olya").append('\n');
        sb.append("Anya").append('\n');
        String data = sb.toString();

        //ќборачиваем строку в класс ByteArrayInputStream
        InputStream is = new ByteArrayInputStream(data.getBytes());

        //подмен€ем in
        System.setIn(is);

        //вызываем обычный метод, который не подозревает о наших манипул€ци€х
        readAndPrintLine();
    }

    public static void readAndPrintLine() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);

        while (true)
        {
            String line = reader.readLine();
            if (line == null) break;
            System.out.println(line);
        }
        reader.close();
        isr.close();
    }
}
