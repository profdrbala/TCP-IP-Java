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
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Dr.Bala <bala.veerasamy@shct.edu.om>
 */
public class ROPClient {
    public static void main(String[] args) {
        try{
            Socket s=new Socket("127.0.0.1", 1000);
            InetAddress ip=InetAddress.getLocalHost();
            DataOutputStream out=new DataOutputStream(s.getOutputStream());
            out.writeUTF(ip.getHostAddress());
            Scanner inp=new Scanner(System.in);
            System.out.println("Enter the vehicle no. "); 
            String vehicle=inp.nextLine();
            System.out.println("Enter the location"); String location=inp.nextLine();
            System.out.println("Enter the speed in km");  int speed=inp.nextInt();
            out.writeUTF(vehicle);
            out.writeUTF(location);
            out.writeInt(speed);
            Date d=new Date();
            out.writeUTF(d.toString());
            DataInputStream in=new DataInputStream(s.getInputStream());
            System.out.println("The Penalty amount is "+ in.readDouble());
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
