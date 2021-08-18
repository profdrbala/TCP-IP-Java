
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author bala
 */
public class RmiServer extends UnicastRemoteObject implements RmiIntf {
    Connection con;
    Statement sta;
    String iName;
    int numItems;
    String foodName;
    String date;
    double amount;
    
      RmiServer() throws RemoteException { 
          try{
            Class.forName("org.apache.derby.jdbc.ClientDriver"); //javadb driver
            con=DriverManager.getConnection("jdbc:derby://localhost:1527/MYDB", "bala", "bala");
            sta=con.createStatement();
          } catch(Exception e){            System.out.println(e);        }    
       }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            LocateRegistry.createRegistry(1099);
            RmiServer rs=new RmiServer();
            Naming.bind("first", rs);
            System.out.println("Server Started");
        }catch(Exception e){System.out.println(e);}
    }


    @Override
    public void orderFood(String iName, int numItems, String foodName, String date, String time) throws RemoteException {
       try{
           this.iName=iName;
           this.numItems=numItems;
           this.foodName=foodName;
           this.date=date;
           double dis;
           this.amount=numItems * 1;
           if( amount <= 5){
                           
                          this.amount=(numItems * 1) - (numItems * 1) * .05;
           }
           else{
                          this.amount=(numItems * 1) - (numItems * 1) * .10;
           }
        
          String sql="insert into food values('"
                    + iName  + "'," 
                    + numItems + ",'"
                    + foodName + "','"
                    + date + "','"
                    + time + "',"
                    + amount + ")";
          System.out.println(sql);
         sta.executeUpdate(sql);
       }catch(Exception e){
           System.out.println(e);
       }
        
    }

    @Override
    public String billRecipt() throws RemoteException {
        return "\n" + iName + 
                    "\t" + numItems +
                   "\t" + foodName +
                   "\t" + date +
                   "\t" + amount;
    }

}
