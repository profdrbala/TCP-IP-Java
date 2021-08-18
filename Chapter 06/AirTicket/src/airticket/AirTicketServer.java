/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airticket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Dr. Bala
 */
public class AirTicketServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            ServerSocket s=new ServerSocket(1000);
            while(true){
            Socket c=s.accept();
            DataInputStream in=new DataInputStream(c.getInputStream());
            DataOutputStream out=new DataOutputStream(c.getOutputStream());
                   
            String pnames=in.readUTF();
            int nts=in.readInt();
            String fno=in.readUTF();
            String from=in.readUTF();
            String date=in.readUTF();
            
 
            double amount = 0.0;
            double dis = 0.0;
            if(nts >=1 && nts <= 5){
                dis= nts *10;
                amount= (nts * 50) - dis;
            }
            else {
                dis= nts * 20;
                amount= (nts * 50) - dis;
            }
            
            out.writeDouble(amount);
            out.writeDouble(dis);
            
            File f=new File("c:\\data");
                 f.mkdir();
                 f=new File("c:\\data\\ticket.txt");
                 f.createNewFile();
            
            Writer w=new FileWriter("c:\\data\\ticket.txt",true);
            w.write(" Name of travellers " + pnames);
            w.write(" Number of travellers " + nts);
            w.write(" Flight No " + fno);
            w.write(" Travel from " + from);
            w.write(" Ticket Amount " + amount);
            w.write(" Discount  " + dis);
            w.close();
            }
        }catch(Exception e){
            System.out.println(e);
        }


    }
    
}
