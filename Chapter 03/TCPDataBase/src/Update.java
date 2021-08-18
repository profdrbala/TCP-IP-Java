

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 66s1315
 */
public class Update {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       try{
           
           Class.forName("org.apache.derby.jdbc.ClientDriver");
           Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/TCP","bala","bala");
           Statement sta=con.createStatement();
           Scanner s=new Scanner(System.in);
            System.out.println("Enter SNo To Update:"); int sno= s.nextInt();
            System.out.println("Enter SName:"); String sname= s.next();
            System.out.println("Enter Phone:"); long ph= s.nextLong();
           
            String sql = "update student set SNAME='" + sname + "' , PHONE=" + ph + "where SNO =" + sno;
           System.out.println(sql);
           sta.executeUpdate(sql);
           
       } catch(Exception  e) {
           
           System.out.println(e);
       }
       
    }
    
}
