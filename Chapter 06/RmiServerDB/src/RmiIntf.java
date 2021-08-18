
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
    public String insert(String sql) throws RemoteException;
    public String delete(String sql) throws RemoteException;
    public String update(String sql) throws RemoteException;
    public String select(String sql) throws RemoteException;
}
