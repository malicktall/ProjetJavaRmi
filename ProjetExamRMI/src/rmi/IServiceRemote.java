package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServiceRemote extends Remote {
    public void ServiceInsert(String code, String libelle) throws RemoteException;
}