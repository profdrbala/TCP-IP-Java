
import java.net.InetAddress;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dr.Bala <bala.veerasamy@shct.edu.om>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     try{
        //Get IP address of a given domain/hostname:
        InetAddress address1 = InetAddress.getByName("www.google.com");
        System.out.println(address1.getHostAddress());
        
        //Get hostname from IP address:
            InetAddress address2 = InetAddress.getByName("8.8.8.8");
            System.out.println(address2.getHostName());
            
         //getByName
            byte[] ipAddr = new byte[] { (byte)172, (byte)217, 18, (byte)132 };
            
            InetAddress address3 = InetAddress.getByAddress(ipAddr);
            String hostname = address3.getHostName();
            System.out.println(hostname);
            
          //List all IP addresses associate with a hostname/domain:
          InetAddress[] google = InetAddress.getAllByName("google.com");
            for (InetAddress addr : google) {
                System.out.println(addr.getHostAddress());
            }
        
          //Get the localhost address:  
            InetAddress localhost = InetAddress.getLocalHost();
            System.out.println(localhost);
            
     }catch(Exception e){
     System.out.println("Runtime Error: " + e);
     }
    }
    
}
