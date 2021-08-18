/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InsurenceCompany;

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
public class InsureServer {

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
                String oname=in.readUTF();
                String cname=in.readUTF();
                double cval=in.readDouble();
                String date=in.readUTF();
                
                double insAmt=0.0;
                
                if (cval<1000)
                        insAmt= .10 * cval;
                else if (cval>=1000 || cval<=5000)
                        insAmt= .20 * cval;
                else if (cval>5000)
                        insAmt= .30 * cval;
                else
                    insAmt=0;
                
                
                 
                File f = new File("c:\\data");              if(!f.exists()) f.mkdir();
                f = new File("c:\\data\\Insure.txt");     if(!f.exists())  f.createNewFile();
                Writer wr=new FileWriter(f,true);
                            wr.write( ipadd + "\t");
                            wr.write(oname + "\t");
                            wr.write(cname + "\t");
                            wr.write(String.valueOf(cval) + "\t");
                            wr.write(date + "\t");
                            wr.write(String.valueOf(insAmt));                            
                            wr.close();

               out.writeDouble(insAmt);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
