package rmiServer;

import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringServerTest
{
	
	StringServer stringServer;
	Registry stringRegistry;

	@BeforeEach
	void setUp() throws Exception
	{
		stringServer = new StringServer();
		stringRegistry = LocateRegistry.createRegistry(1099);
		stringRegistry.rebind("STRINGS", stringServer);
	}

	@AfterEach
	void tearDown() throws Exception
	{
		stringRegistry.unbind("STRINGS");
	}

	@Test
	void testConcatStrings()
	{
		String s1 = "Hello";
		String s2 = " ";
		String s3 = "World";
		String s4 = "!";
		
		try
		{
			String concat1 = stringServer.concatStrings(s1, s2);
			assertEquals("Hello ", concat1);
			
			String concat2 = stringServer.concatStrings(concat1, s3);
			assertEquals("Hello World", concat2);
			
			String concat3 = stringServer.concatStrings(concat2, s4);
			assertEquals("Hello World!", concat3);
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
	}

}
