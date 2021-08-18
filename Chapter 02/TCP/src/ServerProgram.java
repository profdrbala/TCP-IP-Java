/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dr.Bala <bala.veerasamy@shct.edu.om>
 */
import java.net.*;
import java.io.*;

public class ServerProgram {
    public static void main(String[] args) {
      try{
        ServerSocket ss=new ServerSocket(1000);
        Socket cs=ss.accept();
        //reading the client message
        DataInputStream in=new DataInputStream(cs.getInputStream());
        String cmsg=in.readUTF();
        System.out.println(cmsg);
        
        //writing message to client
        DataOutputStream out=new DataOutputStream(cs.getOutputStream());
        String smsg="Hellow " + cmsg;
        out.writeUTF(smsg);
         }catch(Exception e){}
    }
    
}
