

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
public class Select {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       try{
           
           Class.forName("org.apache.derby.jdbc.ClientDriver");
           Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/TCP","bala","bala");
           Statement sta=con.createStatement();
           Scanner s=new Scanner(System.in);
           System.out.println("Enter SNo To find:"); 
           int sno= s.nextInt();
           String sql ="select * from student where sno=" + sno;
           System.out.println(sql);
           ResultSet rs=sta.executeQuery(sql);
           System.out.println("sno\tsname\tphone");
           boolean found=false;
           while(rs.next()){
               System.out.print(rs.getInt("sno"));
               System.out.print("\t" + rs.getString("sname"));
               System.out.print("\t" + rs.getLong("phone"));
               System.out.println();
               found=true;
           }
           if(found==false)
               System.out.println("The sno not found");
       } catch(Exception  e) {
           
           System.out.println(e);
       }
       
    }
    
}
