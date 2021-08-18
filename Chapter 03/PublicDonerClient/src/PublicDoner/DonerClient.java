/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicDoner;

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
public class DonerClient {

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
            System.out.println("Enter the Doner Name ");    String dname=inp.next();
            System.out.println("Enter the Doner Address "); String add=inp.next();
            System.out.println("Enter the fund amount to donate");  double famount=inp.nextDouble();
            out.writeUTF(dname);
            out.writeUTF(add);
            out.writeDouble(famount);
            
            Date d=new Date();
            out.writeUTF(d.toString());
            
            System.out.println(in.readUTF());
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
