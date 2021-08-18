/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airticket;

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
public class AirTicketClient {
    public static void main(String[] args) {
        try{
            Socket c=new Socket("127.0.0.1",1000);
            DataInputStream in=new DataInputStream(c.getInputStream());
            DataOutputStream out=new DataOutputStream(c.getOutputStream());
 
            Scanner sin=new Scanner(System.in);
            System.out.println("Enter the Traveller Names");
            String pnames=sin.next();
            System.out.println("Enter Number of travellers");
            int nts=sin.nextInt();
            System.out.println("Enter the Flight Number");
            String fno=sin.next();
            System.out.println("Enter where you travel from");
            String from=sin.next();
            System.out.println("Enter date/time of travel");
            String date=sin.next();

            out.writeUTF(pnames);
            out.writeInt(nts);
            out.writeUTF(fno);
            out.writeUTF(from);
            out.writeUTF(date);
            
            double amt=in.readDouble();
            System.out.println("The amount to be paid after the discount " +amt);
         
            double dis=in.readDouble();
            System.out.println("The discount you received" + dis);
            
        }catch(Exception e){
            System.out.println(e);
        }

    }
}
