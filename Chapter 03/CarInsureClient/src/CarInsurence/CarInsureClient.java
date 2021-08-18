/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarInsurence;

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
public class CarInsureClient {

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
            System.out.println("Enter the Owner Name ");    String oname=inp.next();
            System.out.println("Enter the Car Name "); String cname=inp.next();
            System.out.println("Enter the Car Value");  double cval=inp.nextDouble();
            out.writeUTF(oname);
            out.writeUTF(cname);
            out.writeDouble(cval);
            
            Date d=new Date();
            out.writeUTF(d.toString());
            
            System.out.println(in.readDouble());
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
