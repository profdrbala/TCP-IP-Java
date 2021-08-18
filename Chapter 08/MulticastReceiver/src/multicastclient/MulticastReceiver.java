/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicastclient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

/**
 *
 * @author Dr.Bala <bala.veerasamy@shct.edu.om>
 */
public class MulticastReceiver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try { 
        MulticastSocket mSocket = new MulticastSocket(4001); 
        InetAddress mAddr = InetAddress.getByName("224.0.0.1"); 
        mSocket.joinGroup(mAddr); 
        byte [ ] buffer = new byte[512]; 
        while (true) { 
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length); 
        mSocket.receive(dp); 
        String str = new String(dp.getData()); System.out.println(str); 
        }//end of while 
        } 
        catch (SocketException se){ System.out.println("Socket Exception : " + se); } 
        catch (IOException e)            { System.out.println("Exception : " + e); } 
        } 

}
