
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
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
    InetAddress add = InetAddress.getByName("10.153.66.47"); 
    DatagramSocket dsock = new DatagramSocket( );
    String message1 = "This is client calling";
    byte arr[] = message1.getBytes( );
    DatagramPacket dpack = new DatagramPacket(arr, arr.length, add, 7);
    dsock.send(dpack); // send the packet
    
    
    Date sendTime = new Date( ); // note the time of sending the message dsock.receive(dpack); // receive the packet
    String message2 = new String(dpack.getData( ));
    Date receiveTime = new Date( ); // note the time of receiving the message
    System.out.println((receiveTime.getTime( ) - sendTime.getTime( )) + " milliseconds echo time for " + message2);
  }
}
