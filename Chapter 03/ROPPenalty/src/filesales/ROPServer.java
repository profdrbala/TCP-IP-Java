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
public class ROPServer {

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
                String vehicle=in.readUTF();
                String location=in.readUTF();
                int speed=in.readInt();
                String date=in.readUTF();
                double penalty=0.0;
                 if (speed > 135 && speed <=150)
                        penalty=10.0;
                    else
                        penalty=15.0;
                File f = new File("c:\\data");                  if(!f.exists()) f.mkdir();
                f = new File("c:\\data\\Penaly.txt");     if(!f.exists())  f.createNewFile();
                Writer wr=new FileWriter(f,true);
                            wr.write( ipadd + "\t");
                            wr.write(vehicle + "\t");
                            wr.write( location + "\t");
                            wr.write(String.valueOf(speed) + "\t");
                            wr.write(date + "\t");
                            wr.write(String.valueOf(penalty) + "\t");
                            wr.write(System.lineSeparator());
                            wr.close();
              DataOutputStream out=new DataOutputStream(c.getOutputStream());
               out.writeDouble(penalty);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
