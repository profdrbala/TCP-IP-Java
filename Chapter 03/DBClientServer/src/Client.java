
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bala
 */
public class Client {
    public static void main(String ss[]){
        try{
            Socket c=new Socket("127.0.0.1",1000);
            DataOutputStream out=new  DataOutputStream(c.getOutputStream());
            DataInputStream in=new DataInputStream(c.getInputStream());
            
            Scanner s=new Scanner(System.in);
            System.out.println("Choose the following"
                    + "\n1. Insert"
                    + "\n2. Update"
                    + "\n3. Delete"
                    + "\n4. Select");
            int ch= s.nextInt();
            out.writeInt(ch);
            int sno;
            String sname;
            long ph;
            
            switch(ch){
                case 1:
                    System.out.println("Enter SNo:");   sno= s.nextInt();
                    System.out.println("Enter SName:"); sname= s.next();
                    System.out.println("Enter Phone:"); ph= s.nextLong();
                    

                    out.writeInt(sno);
                    out.writeUTF(sname);
                    out.writeLong(ph);
                    System.out.println(in.readUTF());
                        break;
                case 2:
                     System.out.println("Enter SNo To Update:"); sno= s.nextInt();
                     System.out.println("Enter SName:"); sname= s.next();
                     System.out.println("Enter Phone:"); ph= s.nextLong();
                     out.writeInt(sno);
                     out.writeUTF(sname);
                     out.writeLong(ph);
                     System.out.println(in.readUTF());
                     break;
                case 3:
                     System.out.println("Enter SNo To delete:"); sno= s.nextInt();
                     out.writeInt(sno);
                     System.out.println(in.readUTF());
                     break;
                case 4:
                     System.out.println("Enter SNo To select:"); sno= s.nextInt();
                     out.writeInt(sno);
                     
//                     if(in.readUTF().equals("")){
//                            System.out.println("Not found");
//                     }
//                     else{
                         System.out.println("sno\tsname\tphone");
                         System.out.print(in.readInt() + "\t" + in.readUTF() + "\t" + in.readLong());
                         
                         
//                     }
                             
                     break;
            }
           
           
            
            
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
