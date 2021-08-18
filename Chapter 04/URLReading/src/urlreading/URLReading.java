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

/**
 *
 * @author Dr.Bala <bala.veerasamy@shct.edu.om>
 */
public class URLReading {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) throws Exception {
    URL g = new URL("http://www.google.com/"); 
    BufferedReader in = new BufferedReader(new InputStreamReader(g.openStream()));
    
    String inputLine;
    while ((inputLine = in.readLine()) != null) System.out.println(inputLine);
    in.close();
    
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"); 

URLConnection yc = g.openConnection(); 

BufferedReader inn = new BufferedReader(new InputStreamReader(yc.getInputStream())); 

while ((inputLine = inn.readLine()) != null) System.out.println(inputLine); 
in.close(); 

}
    
}
