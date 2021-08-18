
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
      RmiServer() throws RemoteException { 
          try{
            Class.forName("org.apache.derby.jdbc.ClientDriver"); //javadb driver
            con=DriverManager.getConnection("jdbc:derby://localhost:1527/TCP", "bala", "bala");
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
    public String insert(String sql) throws RemoteException {
        try{
        sta.executeUpdate(sql);   
        }catch(Exception e){System.out.println(e);}
        return "Your record is inserted";
    }

    @Override
    public String delete(String sql) throws RemoteException {
        try{
        sta.executeUpdate(sql);   
        }catch(Exception e){System.out.println(e);}
        return "Your record is deleted";
    }

    @Override
    public String update(String sql) throws RemoteException {
        try{
        sta.executeUpdate(sql);   
        }catch(Exception e){System.out.println(e);}
        return "Your record is updated";
    }

    @Override
    public String select(String sql) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

    
    
}
