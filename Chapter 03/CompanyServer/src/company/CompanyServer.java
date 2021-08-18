/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

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
public class CompanyServer {

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
                String ename=in.readUTF();
                String loc=in.readUTF();
                int exhours=in.readInt();
                String date=in.readUTF();
                
                double expay=0.0;
                
                if (exhours>=10)
                        expay=5 * exhours;
                else if (exhours>10 && exhours>=20)
                        expay= 10 * exhours;
                else if (exhours>20)
                        expay= 15 * exhours;
                else
                    expay=0;
                
                
                 
                File f = new File("c:\\data");              if(!f.exists()) f.mkdir();
                f = new File("c:\\data\\extra.txt");     if(!f.exists())  f.createNewFile();
                Writer wr=new FileWriter(f,true);
                            wr.write( ipadd + "\t");
                            wr.write(ename + "\t");
                            wr.write( loc + "\t");
                            wr.write(String.valueOf(exhours) + "\t");
                            wr.write(date + "\t");
                            wr.write(String.valueOf(expay) + "\t");                            
                            wr.close();

               out.writeDouble(expay);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
