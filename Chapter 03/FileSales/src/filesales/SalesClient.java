/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesales;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Dr.Bala <bala.veerasamy@shct.edu.om>
 */
public class SalesClient {
    public static void main(String[] args) {
        try{
            Socket s=new Socket("127.0.0.1", 1000);
            
            Scanner inp=new Scanner(System.in);
            System.out.println("Enter the item name"); String item=inp.nextLine();
            System.out.println("Enter the item price");  double price=inp.nextDouble();
            System.out.println("Enter the item quantity"); double qty=inp.nextDouble();

            InetAddress ip=InetAddress.getLocalHost();
            DataOutputStream out=new DataOutputStream(s.getOutputStream());
            
            out.writeUTF(ip.getHostAddress());
            out.writeUTF(ip.getHostName());
            
            out.writeUTF(item);
            out.writeDouble(price);
            out.writeDouble(qty);
            DataInputStream in=new DataInputStream(s.getInputStream());
            System.out.println(in.readDouble());
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
