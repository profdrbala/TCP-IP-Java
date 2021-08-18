/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

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
public class EmployeeClient {

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
            System.out.println("Enter the Emplyee Name ");    String ename=inp.next();
            System.out.println("Enter the Location "); String loc=inp.next();
            System.out.println("Enter the extra hours");             int exhours=inp.nextInt();
            out.writeUTF(ename);
            out.writeUTF(loc);
            out.writeInt(exhours);
            
            Date d=new Date();
            out.writeUTF(d.toString());
            
            System.out.println("Pay the amount "+ in.readDouble());
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
