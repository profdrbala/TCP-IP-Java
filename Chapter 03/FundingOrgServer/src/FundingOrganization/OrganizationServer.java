/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FundingOrganization;

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
public class OrganizationServer {

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
                String dname=in.readUTF();
                String add=in.readUTF();
                double famount=in.readDouble();
                String date=in.readUTF();
                
                String msg=null;
                
                if (famount<100)
                        msg="Thanks, really appreciated";
                else if (famount>=100 || famount<=500)
                        msg="Thanks, You're a lifesaver";
                else if (famount>500)
                        msg="Thank you from the bottom of our heart";
                else
                    msg="You are expected to donate";
                
                
                 
                File f = new File("c:\\data");              if(!f.exists()) f.mkdir();
                f = new File("c:\\data\\fund.txt");     if(!f.exists())  f.createNewFile();
                Writer wr=new FileWriter(f,true);
                            wr.write( ipadd + "\t");
                            wr.write(dname + "\t");
                            wr.write( add + "\t");
                            wr.write(String.valueOf(famount) + "\t");
                            wr.write(date + "\t");
                            wr.write(msg);                            
                            wr.close();

               out.writeUTF(msg);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
