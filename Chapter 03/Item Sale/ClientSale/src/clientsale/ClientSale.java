/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsale;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author bala
 */
public class ClientSale {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            double overall=0.0;
            int con=0;
         do{
            Socket c=new Socket("192.168.135.28",1000);
            
            DataInputStream in=new DataInputStream(c.getInputStream());
            DataOutputStream out=new DataOutputStream(c.getOutputStream());

            Scanner sin=new Scanner(System.in);
            System.out.println("Enter the Item");
            String item=sin.next();
            System.out.println("Enter the Price");
            double pri=sin.nextDouble();
            System.out.println("Enter the QTY");
            double qty=sin.nextDouble();
            
            InetAddress ip=InetAddress.getLocalHost();
            String ipadd=ip.getHostAddress();
            String hostname=ip.getHostName();
            
            out.writeUTF(ipadd);
            out.writeUTF(hostname);
            
            out.writeUTF(item);
            out.writeDouble(pri);
            out.writeDouble(qty);
            
            double amt=in.readDouble();
            overall+=amt;
             
            System.out.println("Press 1 to continue");
            con=sin.nextInt();
             
         }while(con==1);
         System.out.println("The amount to be paid " +overall);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
