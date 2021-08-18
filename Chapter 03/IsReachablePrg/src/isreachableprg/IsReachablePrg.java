/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isreachableprg;

import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Dr.Bala <bala.veerasamy@shct.edu.om>
 */
public class IsReachablePrg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try{
          Scanner s=new Scanner(System.in);
           System.out.println("Enter the host name");
          String host=s.nextLine();
           
           InetAddress i=InetAddress.getByName(host);
           boolean status =i.isReachable(3000);
           
            String msg=null;
            if(status)
                msg = host + " is reachable";
            else
                msg = host + " is not reachable";
        
            System.out.println(msg);
           
       }catch(Exception e){
           System.out.println(e);
       }
    }
    
}
