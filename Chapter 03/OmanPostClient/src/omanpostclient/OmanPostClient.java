/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omanpostclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Dr. Bala
 */
public class OmanPostClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Socket s=new Socket("127.0.0.1", 1024);
            DataOutputStream out=new DataOutputStream(s.getOutputStream());
            DataInputStream in=new DataInputStream(s.getInputStream());

            InetAddress ip=InetAddress.getLocalHost();
            out.writeUTF(ip.getHostAddress());

            Scanner inp=new Scanner(System.in);
            System.out.println("Enter the sender address ");    String from=inp.next();
            System.out.println("Enter the recepient address "); String to=inp.next();
            System.out.println("Enter the amount");             double amount=inp.nextInt();
            out.writeUTF(from);
            out.writeUTF(to);
            out.writeDouble(amount);
            
            Date d=new Date();
            out.writeUTF(d.toString());
            
            System.out.println("Pay the amount "+ in.readDouble());
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
