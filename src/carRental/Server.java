package carRental;


import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	
	// Port Number you can change based on your system availability
	//private static final int PORT = 5252;

	public static void main(String[] args) {
		
		try {
			
			// Defining Object
			Authentication authentication = new AuthenticationImpl();
			
			// Creating RMI Registry with Port
			Registry registry = LocateRegistry.createRegistry(5252);
			
			// Binding the Object
			registry.bind("auth", authentication);
			
			System.out.println("Authentication Service running at "+"5352"+" port...");
			
		} catch (RemoteException e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
}
