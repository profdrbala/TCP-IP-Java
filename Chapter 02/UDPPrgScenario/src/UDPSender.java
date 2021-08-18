
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dr.Bala <bala.veerasamy@shct.edu.om>
 */
public class UDPSender {
public static void main( String args[] ) throws Exception {
    InetAddress add = InetAddress.getByName("127.0.0.1"); 
    DatagramSocket dsock = new DatagramSocket( );
    
    byte arr[] =new byte[100];
    
    ByteBuffer bb = ByteBuffer.allocate(4); 
    bb.putInt(10); 
    arr=bb.array();
    
    DatagramPacket dpack = new DatagramPacket(arr, arr.length, add, 1024);
    dsock.send(dpack); // send the packet
    
   
  }
}
