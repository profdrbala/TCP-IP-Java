
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dr.Bala <bala.veerasamy@shct.edu.om>
 */
public class ClientProgram {
       public static void main(String[] args) {
        try{
        Socket cs=new Socket("127.0.0.1",1000);
        //read user input
        Scanner s=new Scanner(System.in);
        System.out.println("Ether your name");String name=s.nextLine();
        
        //writing message to server
        DataOutputStream out=new DataOutputStream(cs.getOutputStream());        
        out.writeUTF(name);
        
        //reading from server
        DataInputStream in=new DataInputStream(cs.getInputStream());
        String msg=in.readUTF();
        System.out.println(msg);
        

         }catch(Exception e){}
    }
}
