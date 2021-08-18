
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author bala
 */
public class RmiClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            LocateRegistry.getRegistry(1099);
            RmiIntf i=(RmiIntf)Naming.lookup("first");
            String s=i.diplay();
            System.out.println(s);
        }catch(Exception e){System.out.println(e);}
    }
    
}
