/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portscanner;

import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Dr.Bala <bala.veerasamy@shct.edu.om>
 */
public class PortScanner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int start = 0;
    int stop = 0; 
    int n=1; 
    Scanner in=new Scanner(System.in); 
    System.out.println("Enter START port Number:");    start=in.nextInt(); 
    System.out.println("Enter END port Number:");        stop=in.nextInt(); 
    for(int i=start; i<=stop; i++) {
        try { 
            Socket ServerSok = new Socket("127.0.0.1",i); 
            System.out.println("Port in use: " + i ); 
            ServerSok.close(); 
        } catch (Exception e)  { System.out.println(e); } 
    }
    }
    
}
