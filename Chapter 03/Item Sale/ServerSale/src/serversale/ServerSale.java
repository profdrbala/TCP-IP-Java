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
            
            String ipadd=in.readUTF();
            String host=in.readUTF();
            
            String item=in.readUTF();
            double pri=in.readDouble();
            double qty=in.readDouble();
            
            double amt=pri* qty;
            double dis=0.0;
            
            if(amt>=10)
                dis= amt* .10;
            else if(amt>=20)
                dis= amt* .20;
            else
                dis=0;
            
            double totamt=amt-dis;
            
            out.writeDouble(totamt);
            
            
            File f=new File("c:\\data");
                 f.mkdir();
                 f=new File("c:\\data\\sales.txt");
                 f.createNewFile();
            
            Writer w=new FileWriter("c:\\data\\sales.txt",true);
            w.write(" IP "+ ipadd);
            w.write(" Host " +host);
            w.write(" Item " + item);
            w.write(" Price " +String.valueOf(pri));
            w.write(" Qty " + String.valueOf(qty));
            w.write(" Tot Amt. " +String.valueOf(totamt));
            w.write(" Dis Amt. " + String.valueOf(dis));
            w.close();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
