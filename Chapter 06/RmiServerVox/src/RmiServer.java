
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
    String pName;
    int numTicket;
    String movieName;
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
    public void buyTiket(String pName, int numTicket, String movieName, String date, String time) throws RemoteException {
       try{
           this.pName=pName;
           this.numTicket=numTicket;
           this.movieName=movieName;
           this.date=date;
           double dis;
           if(numTicket <= 3){
                           
                          this.amount=(numTicket * 2.5) - (numTicket * 2.5) * .10;
           }
           else{
                          this.amount=(numTicket * 2.5) - (numTicket * 2.5) * .20;
           }
        
          String sql="insert into ticket values('"
                    + pName  + "'," 
                    + numTicket + ",'"
                    + movieName + "','"
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
    public String issueTicket() throws RemoteException {
        return "\n" + pName + 
                    "\t" + numTicket +
                   "\t" + movieName +
                   "\t" + date +
                   "\t" + amount;
    }

}
