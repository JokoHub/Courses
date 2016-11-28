package com.joko.tests;

import java.io.*;

/**
 * Created by User on 02.09.2016.
 */
public class InputStreamChange {

    public static void main(String[] args) throws IOException
    {
        //������ ������ � ������
        StringBuilder sb = new StringBuilder();
        sb.append("Lena").append('\n');
        sb.append("Olya").append('\n');
        sb.append("Anya").append('\n');
        String data = sb.toString();

        //����������� ������ � ����� ByteArrayInputStream
        InputStream is = new ByteArrayInputStream(data.getBytes());

        //��������� in
        System.setIn(is);

        //�������� ������� �����, ������� �� ����������� � ����� ������������
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
