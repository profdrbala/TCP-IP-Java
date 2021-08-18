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
public class CarServer {

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
                String car=in.readUTF();
                String location=in.readUTF();
                double price=in.readDouble();
                String date=in.readUTF();
                double amt=0.0, dis=0.0;
                 if (price < 7000)
                        dis=.1 * price;
                    else
                        dis=.2 * price;
                 
                 amt=price-dis;
                File f = new File("c:\\data");                  if(!f.exists()) f.mkdir();
                f = new File("c:\\data\\CarSales.txt");     if(!f.exists())  f.createNewFile();
                Writer wr=new FileWriter(f,true);
                            wr.write( ipadd + "\t");
                            wr.write(car + "\t");
                            wr.write( location + "\t");
                            wr.write(String.valueOf(price) + "\t");
                            wr.write(date + "\t");
                            wr.write(String.valueOf(dis) + "\t");                            
                            wr.close();
              DataOutputStream out=new DataOutputStream(c.getOutputStream());
               out.writeDouble(dis);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
