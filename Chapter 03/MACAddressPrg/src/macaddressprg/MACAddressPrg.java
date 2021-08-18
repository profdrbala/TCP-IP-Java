/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macaddressprg;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Arrays;
import java.util.Enumeration;

/**
 *
 * @author Dr.Bala <bala.veerasamy@shct.edu.om>
 */
public class MACAddressPrg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try
            {
            InetAddress address = InetAddress.getLocalHost();
            NetworkInterface nwi = NetworkInterface.getByInetAddress(address);
            byte mac[] = nwi.getHardwareAddress();
              System.out.println(nwi.getDisplayName());
             System.out.println(nwi.getMTU());             
             System.out.println(nwi.supportsMulticast());
             System.out.println(nwi.getName());
             System.out.println(nwi.isLoopback());
             System.out.println(nwi.isPointToPoint());
             System.out.println(nwi.isVirtual());
             
            System.out.print("MAC address is:  ");
                for(byte b : mac)
                    System.out.print(String.format("%02x", b&0xff) + "-");
                
                Enumeration enu = NetworkInterface.getNetworkInterfaces();
                while (enu.hasMoreElements()) 
                                System.out.println(enu.nextElement());
                

                
            } catch(Exception e)    {    System.out.println(e);    }
    }
}
