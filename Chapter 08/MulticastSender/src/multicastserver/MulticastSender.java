/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicastserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

/**
 *
 * @author Dr.Bala <bala.veerasamy@shct.edu.om>
 */
public class MulticastSender {
    public static void main(String[] args) {
        try { 
        MulticastSocket mSocket = new MulticastSocket( ); 
        InetAddress mAddr = InetAddress.getByName("224.0.0.1"); 
        String hostname = InetAddress.getLocalHost().getHostName(); 
        String sendString = "All the Citizens and Residents, Pls. Stay Home and Stay Safe"; 
        byte [ ] buffer = sendString.getBytes(); 
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length, mAddr, 4001); 
        mSocket.send(dp); 
        } 
        catch (SocketException se) { System.out.println("Socket Exception : " + se); } 
        catch (IOException e) { 
        System.out.println("Exception : " + e); } 
        } 

    }
    

