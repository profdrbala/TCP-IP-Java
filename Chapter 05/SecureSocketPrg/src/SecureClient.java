/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.DataOutputStream;
import java.util.Scanner;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/**
 *
 * @author Dr.Bala <bala.veerasamy@shct.edu.om>
 */
public class SecureClient {
    public static void main(String[] args) {
        try {
            SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslsocket = (SSLSocket) sslsocketfactory.createSocket("127.0.0.1", 1000);
            Scanner input= new Scanner(System.in);
            DataOutputStream dout=new DataOutputStream(sslsocket.getOutputStream());
            System.out.println("Enter Your Secure Data:");
            String str = input.nextLine();
            dout.writeUTF(str);
            sslsocket.close();
        } catch (Exception exception) {
        exception.printStackTrace();
        }
    }
}
