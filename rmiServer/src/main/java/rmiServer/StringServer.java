package rmiServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StringServer extends UnicastRemoteObject implements StringServerInterface
{

	private static final long serialVersionUID = 5131965202173807807L;

	protected StringServer() throws RemoteException {}

	@Override
	public String concatStrings(String s1, String s2) throws RemoteException
	{
		return s1 + s2;
	}
	
	public static void main(String[] args)
	{
		try
		{
			StringServer rmiServer = new StringServer();
			Naming.rebind("STRINGS", rmiServer);
		}
		catch (RemoteException | MalformedURLException e)
		{
			e.printStackTrace();
		}
		
	}

}
