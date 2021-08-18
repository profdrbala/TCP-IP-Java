
import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bala
 */
public interface RmiIntf extends Remote{
    public void orderFood(String pName, int numItem,String foodNames, String date, String time) throws RemoteException;
    public String billRecipt() throws RemoteException;
}
