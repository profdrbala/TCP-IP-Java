
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
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
public class RmiClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            LocateRegistry.getRegistry(1099);
            RmiIntf i=(RmiIntf)Naming.lookup("first");
  
            Scanner s=new Scanner(System.in);
            System.out.println("Enter SNO"); int sno=s.nextInt();
            System.out.println("Enter SNname"); String sname=s.next();
            System.out.println("Enter Phone"); long ph=s.nextLong();
            
            String sql="insert into Student values("
                    + sno 
                    + ",'" + sname + "',"
                    + ph + ")";
            String o=i.insert(sql);
            System.out.println(o);
            
            
            System.out.println("Enter 'SNO' to get deleted :"); sno=s.nextInt();
            
            sql="delete from Student where sid=" + sno;
            o=i.delete(sql);
            System.out.println(o);
            
            
            System.out.println("Enter 'SNO' to get updated :"); sno=s.nextInt();
            
            System.out.println("Enter SNname"); sname=s.next();
            System.out.println("Enter Phone"); ph=s.nextLong();
            
            sql="update student set sname='"
                    + sname + "', phone="
                    + ph + "where sid=" + sno;
            o=i.update(sql);
            System.out.println(o);
            
            
        }catch(Exception e){System.out.println(e);}
    }
    
}
