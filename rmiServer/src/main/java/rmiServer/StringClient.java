package rmiServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class StringClient
{

	public static void main(String[] args)
	{
		try
		{
			StringServerInterface ss = (StringServerInterface) Naming.lookup("rmi://localhost/STRINGS");
			String concatString = ss.concatStrings("String1", "String2");
			System.out.println(concatString);
		}
		catch (RemoteException | MalformedURLException | NotBoundException e)
		{
			e.printStackTrace();
		}
	}

}
