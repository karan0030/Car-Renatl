package carRental;



import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Authentication extends Remote {

	public boolean authenticate(String userName, String password) throws RemoteException ;
	
	public String cancelride(String Licence,String amt) throws RemoteException ;
	
	public boolean addCar(String cartype,String carid,String name,String Stat) throws RemoteException ;
	
	public int RetR(String Licid,String carid,String km) throws RemoteException ;
	
	public boolean removeCar(String carid) throws RemoteException ;
	
	public boolean bookRide(String Licence,String cartype,String s,String d,String d1,String d2,String k,String c,int amt) throws RemoteException ;
    
    public String viewBooking(String Licence,String res) throws RemoteException ;
	
	
	

	
	public boolean Usave(String userName,String lic,String password,String email,String address,String city,String contact) throws RemoteException ;
}

