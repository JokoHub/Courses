package com.joko.tests;

/**
 * Created by User on 29.09.2016.
 */
/* ���������� ����� ����
1) ���� IP-����� � ����� �������, ���������� ��������� ����� ���� - ����� getNetAddress.
����������� �������� ����������� ���������� (���������� �).
������:
IP-�����:       11000000 10101000 00000001 00000010 (192.168.1.2)
����� �������:  11111111 11111111 11111110 00000000 (255.255.254.0)
����� ����:     11000000 10101000 00000000 00000000 (192.168.0.0)
2) ����������� ����� print, ������� ������� � ������� ������ � �������� ����
3) ����� main �� ��������� � ������������
*/

public class ByteReading {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] myArray = new byte[4];
        for (int i = 0; i < ip.length; i++){
            myArray[i] = (byte)(ip[i] & mask[i]);
        }
        return myArray;
    }

    public static void print(byte[] bytes) {
        for(int i=0; i<bytes.length; i++){
            byte b = bytes[i];
            for(int j=7; j>=0; j--){
                System.out.print((b>>j)&1);
            }
            System.out.print(" ");
        }
        System.out.println();
    }

    //11000000 >> 7 = 11111111 & 00000001 = 00000001 = 1
    // � �.�.
}
