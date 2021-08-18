
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

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
             RmiServer() throws RemoteException { 
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
    public String diplay() throws RemoteException {
        return "Hello Good Morning";
    }

    
    
}
