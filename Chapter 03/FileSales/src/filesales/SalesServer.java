/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesales;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Dr.Bala <bala.veerasamy@shct.edu.om>
 */
public class SalesServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            ServerSocket s=new ServerSocket(1000);
            Socket c;
            while(true){
                c=s.accept();
                DataInputStream in=new DataInputStream(c.getInputStream());
                String ipadd=in.readUTF();
                String hostname=in.readUTF();
                
                String item=in.readUTF();
                double price=in.readDouble();
                double qty=in.readDouble();
                double amt=price * qty;

                File f = new File("c:\\data");  
                if(!f.exists()) f.mkdir();
                f = new File("c:\\data\\Sales.txt"); 
                if(!f.exists())  f.createNewFile();

                Writer wr=new FileWriter(f,true);
                            wr.write( ipadd + "\t");
                            wr.write(hostname + "\t");
                            wr.write(item + "\t");
                            wr.write(String.valueOf(price) + "\t");
                            wr.write(String.valueOf(qty) + "\t");
                            wr.write(String.valueOf(amt) + "\t");
                            wr.write(System.lineSeparator());
                            wr.close();

                DataOutputStream out=new DataOutputStream(c.getOutputStream());
                out.writeDouble(amt);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
