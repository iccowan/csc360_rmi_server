package rmiServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StringServerInterface extends Remote
{
	public String concatStrings(String s1, String s2) throws RemoteException;
}
