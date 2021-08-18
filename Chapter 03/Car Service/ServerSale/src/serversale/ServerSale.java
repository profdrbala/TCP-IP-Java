/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversale;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author bala
 */
public class ServerSale {

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
            
            String lnum=in.readUTF();
            int cm=in.readInt();
            int kc=in.readInt();
            String date=in.readUTF();
            String ipadd=in.readUTF();
            
            double amount = 0.0;
            if(kc >=1 && kc <= 100000)
                amount=40;
            else
                amount=80;
            
            out.writeDouble(amount);
            
            
            File f=new File("c:\\data");
                 f.mkdir();
                 f=new File("c:\\data\\service.txt");
                 f.createNewFile();
            
            Writer w=new FileWriter("c:\\data\\service.txt",true);
            w.write(" License Number " + lnum);            
            w.write(" Car model year " + cm);
            w.write(" KM completed " + kc);
            w.write(" Date of service " + date);
            w.write(" Bill Amount " + amount);
            w.write(" IP "+ ipadd);
            w.close();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}

