
import java.net.DatagramPacket;
import java.net.DatagramSocket;
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
public class UDPReceiver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
try{
     DatagramSocket dsock = new DatagramSocket(7);
    byte arr1[] = new byte[150];
    DatagramPacket dpack = new DatagramPacket(arr1, arr1.length );
    while(true){
        dsock.receive(dpack);
        byte arr2[] = dpack.getData();
        int packSize = dpack.getLength();
        String s2 = new String(arr2, 0, packSize);
        System.out.println( new Date( ) + " " + dpack.getAddress( ) + " : " + dpack.getPort( ) + " "+s2);
        dsock.send(dpack); }
  }catch(Exception e){ }
 }  
}
