/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urlreading;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 *
 * @author Dr.Bala <bala.veerasamy@shct.edu.om>
 */
public class Crawler {
   public static void main(String[] args) throws Exception {
       Scanner s=new Scanner(System.in);
       System.out.print("Enter the URL");
       String url=s.next();
       System.out.print("Enter the Port Number");
       int port=s.nextInt();
       System.out.print("Enter the File Name");
       String fn=s.next();
    URL g = new URL(url+ ":" + port + "/"+fn); 
    System.out.print(g.toString());
    BufferedReader in = new BufferedReader(new InputStreamReader(g.openStream()));
    
    String inputLine;
    while ((inputLine = in.readLine()) != null) System.out.println(inputLine);
    in.close();
}
}
