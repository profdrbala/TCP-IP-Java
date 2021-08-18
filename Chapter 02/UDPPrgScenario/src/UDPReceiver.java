
import java.net.DatagramPacket;
import java.net.DatagramSocket;
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
public class UDPReceiver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
try{
     DatagramSocket dsock = new DatagramSocket(1024);
    byte arr[] = new byte[100];
    DatagramPacket dpack = new DatagramPacket(arr, arr.length );
    while(true){
        dsock.receive(dpack);
        
        ByteBuffer byteBuffer = ByteBuffer.wrap(dpack.getData());
        
        System.out.println(byteBuffer.getInt());    
    }
  }catch(Exception e){ System.out.println(e);}
 }  
}
