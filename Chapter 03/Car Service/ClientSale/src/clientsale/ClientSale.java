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
import java.util.Date;
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
            Socket c=new Socket("127.0.0.1",1000);
            DataInputStream in=new DataInputStream(c.getInputStream());
            DataOutputStream out=new DataOutputStream(c.getOutputStream());

            Scanner sin=new Scanner(System.in);
            System.out.println("Enter the License Number");
            String lnum=sin.next();
            
            System.out.println("Enter the Car Model Year");
            int cm=sin.nextInt();
            System.out.println("Enter the Kilometers Completed");
            int kc=sin.nextInt();
            
            Date d=new Date();
            String date=d.toString();
            
            
            InetAddress ip=InetAddress.getLocalHost();
            String ipadd=ip.getHostAddress();
            
            out.writeUTF(lnum);
            out.writeInt(cm);
            out.writeInt(kc);
            out.writeUTF(date);
            out.writeUTF(ipadd);
            
            double amt=in.readDouble();
         System.out.println("The amount to be paid " +amt);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
