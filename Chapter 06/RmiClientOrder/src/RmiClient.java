
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.text.SimpleDateFormat;
import java.util.Date;
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
            System.out.println("Enter Person Name");           String pname=s.next();
            System.out.println("Enter Number  of  Items");  int numt=s.nextInt();
            System.out.println("Enter Food Name");            String mname=s.next();
            
        
           SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
          String date = df.format(new Date());
          
          df = new SimpleDateFormat("HH:mm:ss");
          String time = df.format(new Date());
          
            i.orderFood(pname, numt, mname, date, time);
            System.out.println(i.billRecipt());
            
            
        }catch(Exception e){System.out.println(e);}
    }
    
}
