/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omanpostserver;

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
public class OmanPostServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            ServerSocket s=new ServerSocket(1024);
            Socket c;
            while(true){
                c=s.accept();
                DataInputStream in=new DataInputStream(c.getInputStream());
                DataOutputStream out=new DataOutputStream(c.getOutputStream());
                
                String ipadd=in.readUTF();
                String from=in.readUTF();
                String to=in.readUTF();
                double amount=in.readDouble();
                String date=in.readUTF();
                
                double dis=0.0;
                String type=null;
                if (type=="Normal Post")
                        dis=.01 * amount;
                else if (type=="Register Post")
                        dis=.05 * amount;
                else if (type=="EMS Post")
                        dis=.10 * amount;
                else
                    dis=0;
                double tot=amount-dis;
                
                 
                File f = new File("c:\\data");              if(!f.exists()) f.mkdir();
                f = new File("c:\\data\\Post.txt");     if(!f.exists())  f.createNewFile();
                Writer wr=new FileWriter(f,true);
                            wr.write( ipadd + "\t");
                            wr.write(from + "\t");
                            wr.write( to + "\t");
                            wr.write(String.valueOf(amount) + "\t");
                            wr.write(date + "\t");
                            wr.write(String.valueOf(dis) + "\t");                            
                            wr.write(String.valueOf(amount) + "\t");                            
                            wr.close();

               out.writeDouble(amount);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
