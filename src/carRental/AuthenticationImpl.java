package carRental;


import java.sql.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AuthenticationImpl extends UnicastRemoteObject implements Authentication {

	protected AuthenticationImpl() throws RemoteException {
		
		
	}
    
	@Override
	public boolean bookRide(String Licence,String cartype,String s,String d,String d1,String d2,String  k,String c,int amt) throws RemoteException 
	{   int l = c.length();
	     int km = Integer.parseInt(k);
	    System.out.println("lene " +l);
		if ((Licence != null && !Licence.isEmpty())&&!cartype.isEmpty()&&!s.isEmpty() &&!d.isEmpty() &&!d1.isEmpty()&& !d2.isEmpty() && l==10 && km>0 && amt>0      )
				{
					try
			       {
			        	Class.forName("com.mysql.jdbc.Driver");  
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/car","root","");  

                        Statement stmt=con.createStatement();  
                        System.out.println("success");
					    long cc = Long.parseLong(c);
						int lim =1;
						String ca = "select carid from cars where cartype='"+cartype+"' and available='"+"yes"+"' limit 1";
						PreparedStatement car= con.prepareStatement(ca) ;
                        int r3=-1;
						ResultSet rst =car.executeQuery();
			            rst.next();
                        if(rst == null)
						{
                          return false;
						}
						 String sd = rst.getString("carid");
						System.out.println(sd); 
                         String q3 ="update cars set available='"+"no"+"' where carid='"+sd+"'";
							PreparedStatement ps1= con.prepareStatement(q3) ;
						    r3= ps1.executeUpdate();						
			           
						
			            String q = "insert into userbook (licence,cartype,start,dest,sdate,till,km,contact)"+ "values(?,?,?,?,?,?,?,?)";
						String qq = "insert into booking (licid,carid)"+ "values(?,?)";
						String pay = "insert into payment (licid,carid,amount)"+ "values(?,?,?)";
                        // userbook
						PreparedStatement ps= con.prepareStatement(q) ;
                        ps.setString(1,Licence);
						ps.setString(2,cartype);
                        ps.setString(3,s);
                        ps.setString(4,d);
                        ps.setString(5,d1);
                        ps.setString(6,d2);
						ps.setInt(7,km);
                        ps.setLong(8,cc);
                        int r= ps.executeUpdate();
					     //boooking
						ps= con.prepareStatement(qq);
						ps.setString(1,Licence);
						ps.setString(2,sd);
						int rr= ps.executeUpdate();
						//payment
						ps= con.prepareStatement(pay);
						ps.setString(1,Licence);
						ps.setString(2,sd);
						ps.setInt(3,amt);
						int rpay= ps.executeUpdate();
                        
			            if( r==1&& rr==1&&rpay==1&&r3==1) {
				
				         return true;
			            }
		            }
					catch(Exception e)
					{
						System.out.print(e);
					}
				}		
		return false;
		
	}
	
	@Override
	public int RetR(String Licid,String carid,String km) throws RemoteException 
	{   int res =-1;
		if (!Licid.isEmpty() && !carid.isEmpty()&& !km.isEmpty())
				{
					try
			       {
			        	Class.forName("com.mysql.jdbc.Driver");  
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/car","root","");  

                        Statement stmt=con.createStatement();  
                        System.out.println("success");
			            String q = "select *  from userbook  where licence='"+Licid+"'";
                        PreparedStatement ps= con.prepareStatement(q) ;
                        
						ResultSet rs =ps.executeQuery();
			            rs.next();  
			            String sd = rs.getString("km");
						System.out.println(sd);
						int k =Integer.parseInt(sd);
						int nk =Integer.parseInt(km);
					    int d;int r2=0,r3=0,r4=0,r5=-1;
						if(nk-k>0)
						{
							d= k*10+450;
							res =  (nk-k)*20; 
							int np = d+res;
							String qq = "insert into receive (licid,carid,finalReading)"+ "values(?,?,?)";
                            PreparedStatement ps2= con.prepareStatement(qq) ;
                            ps2.setString(1,Licid);
						    ps2.setString(2,carid);
						    ps2.setInt(3,nk);
                            r2= ps2.executeUpdate();
							System.out.println("res "+res+ " np "+np +" nk "+nk);
							
							String q3 ="update userbook set km="+nk+" where licence='"+Licid+"'";
							PreparedStatement ps1= con.prepareStatement(q3) ;
						    r3= ps1.executeUpdate();
							
							
							String q4 ="update payment set amount="+np+" where licid='"+Licid+"'";
							PreparedStatement ps4= con.prepareStatement(q4) ;
						     r4= ps4.executeUpdate();
							 
							String q5 ="update cars set available='"+"yes"+"' where carid='"+carid+"'";
							ps4= con.prepareStatement(q5) ;
						     r5= ps4.executeUpdate(); 
							
						}
						else
						{
							res=0;
						}
					    if( rs !=null&&r2==1&&r3==1&&r4==1 &&r5==1) {
				
				         return res;
			            }
		            }
					catch(Exception e)
					{
						res =-1;
						System.out.print(e);
					}
				}	
             				
		return res;
		

	}
	
	
	
	@Override
	public String cancelride(String Licence,String amt) throws RemoteException 
	{
		if ((Licence != null && !Licence.isEmpty()))
				{
					try
			       {
			        	Class.forName("com.mysql.jdbc.Driver");  
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/car","root","");  

                        Statement stmt=con.createStatement();  
                        System.out.println("success");
						
						String pay= "select amount from payment where licid='"+Licence+"'";
                        PreparedStatement pas= con.prepareStatement(pay) ;
						ResultSet rs =pas.executeQuery();
			            rs.next();
						String sd = rs.getString("amount");
						int amtt = Integer.parseInt(sd);
						System.out.println(amtt);
						
						String qq="select carid from booking where licid='"+Licence+"'";
						pas =con.prepareStatement(qq);
						ResultSet rs2 =pas.executeQuery();
			            rs2.next();
						String sd1 = rs2.getString("carid");
						System.out.println("is "+sd1);
						  
			            String q = "delete from booking where licid='"+Licence+"'";
                        PreparedStatement ps= con.prepareStatement(q) ;
						int r= ps.executeUpdate();
						
						qq = "delete from userbook where licence='"+Licence+"'";
                        ps= con.prepareStatement(qq) ;
                        int rr= ps.executeUpdate();
						  
						String qqq = "delete from payment where licid='"+Licence+"'";
                        ps= con.prepareStatement(qqq) ;
                        int rrr= ps.executeUpdate();
						
						
						String yes="yes";
                       String q5 ="update cars set available='"+yes+"' where carid='"+sd1+"'";
					   ps= con.prepareStatement(q5) ;
					   int r5= ps.executeUpdate(); 
                        

			            if( rs2!=null&&r==1 && rr==1 && rrr==1&&r5==1) {
	                       amt=sd;			
				         return amt;
			            }
		            }
					catch(Exception e)
					{
						System.out.print(e);
					}
				}
         amt ="";				
		return amt;
		
	}
	
	@Override
	public boolean removeCar(String carid) throws RemoteException 
	{
		if ((carid != null && !carid.isEmpty()))
				{
					try
			       {
			        	Class.forName("com.mysql.jdbc.Driver");  
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/car","root","");  

                        Statement stmt=con.createStatement();  
                        System.out.println("success");
			            String q = "delete from cars where carid='"+carid+"'";
                        PreparedStatement ps= con.prepareStatement(q) ;
						 int r= ps.executeUpdate();
						
                       


			            if( r==1) {
				
				         return true;
			            }
		            }
					catch(Exception e)
					{
						System.out.print(e);
					}
				}		
		return false;
		
	}
	
	@Override
	public String viewBooking(String Licence,String res) throws RemoteException 
	{
		if ((Licence != null && !Licence.isEmpty()))
				{
					try
			       {
			        	Class.forName("com.mysql.jdbc.Driver");  
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/car","root","");  

                        Statement stmt=con.createStatement();  
                        System.out.println("success");
			            String q = "select sdate,till,start,dest,cartype   from userbook  where licence='"+Licence+"'";
                        PreparedStatement ps= con.prepareStatement(q) ;
                        
						 ResultSet rs =ps.executeQuery();
			            rs.next();
            //ResultSet rs=stmt.executeQuery("select Password from  newuser where name = uname");  
			            String sd = rs.getString("sdate");
						String till = rs.getString("till");
						String start = rs.getString("start");
						String dest = rs.getString("dest");
						String cartype = rs.getString("cartype");
						
						String q2 = "select carid  from booking  where licid='"+Licence+"'";
						 ps= con.prepareStatement(q2) ;
						rs =ps.executeQuery();
			            rs.next();
						String carid= rs.getString("carid");
						res ="You have booking from "+sd+" till "+till+" of "+cartype+" CarId "+carid+" from "+start+" to "+dest;
						
			            System.out.print(res);
						 
						
                        


			            if( rs !=null) {
				
				         return res;
			            }
		            }
					catch(Exception e)
					{
						System.out.print(e);
					}
				}	
             res="";				
		return res;
		
	}
	
	
	
	@Override
	public boolean authenticate(String userName, String password)
			throws RemoteException {

		if ((userName != null && !userName.isEmpty()) && (password != null && !password.isEmpty()))
				{
					try
			       {
			        	Class.forName("com.mysql.jdbc.Driver");  
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/car","root","");  

                        Statement stmt=con.createStatement();  
                        System.out.println("success");
			            PreparedStatement ps= con.prepareStatement("select Password from newuser where Name ='"+userName+"'");
	            		//ps.setString(1,uname);
			            ResultSet rs =ps.executeQuery();
			            rs.next();
            //ResultSet rs=stmt.executeQuery("select Password from  newuser where name = uname");  
			            String pass = rs.getString("password");
			            System.out.print(pass);

			            if( (password.equalsIgnoreCase(pass))) {
				
				         return true;
			            }
		            }
					catch(Exception e)
					{
						System.out.print(e);
					}
				}		
		return false;
	}
	
	@Override
	public boolean addCar(String cartype,String carid,String name,String Stat) 
			throws RemoteException {

		if ((carid != null && !carid.isEmpty()) && (cartype != null && !cartype.isEmpty())&&(Stat != null && ! Stat.isEmpty())&& !name.isEmpty())
				{
					try
			       {
			        	Class.forName("com.mysql.jdbc.Driver");  
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/car","root","");  

                        Statement stmt=con.createStatement();  
                        System.out.println("success");
			            String q = "insert into cars (carid,cartype,name,available)"+ "values(?,?,?,?)";
                        PreparedStatement ps= con.prepareStatement(q) ;
                        ps.setString(1,carid);
						ps.setString(2,cartype);
						ps.setString(3,name);
                        ps.setString(4,Stat);
                       
                        int r= ps.executeUpdate();


			            if( r==1) {
				
				         return true;
			            }
		            }
					catch(Exception e)
					{
						System.out.print(e);
					}
				}		
		return false;
	}
    @Override
	public boolean Usave(String userName,String lic,String password,String email,String address,String city,String contact) 
			throws RemoteException {
             
			 int k = contact.length();
			 System.out.println("lenghth if "+ k);
		if ((userName != null && !userName.isEmpty()) && (password != null && !password.isEmpty())&&(!email.isEmpty())&&( !address.isEmpty()) && !city.isEmpty() && k==10 )
				{
					try
			       {
			        	Class.forName("com.mysql.jdbc.Driver");  
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/car","root","");  
                        
						long cc = Long.parseLong(contact);
//                        Statement stmt=con.createStatement();  
                        System.out.println("success");
			            String q = "insert into newuser (name,licid,password,email,address,city,contact)"+ "values(?,?,?,?,?,?,?)";
                        PreparedStatement ps= con.prepareStatement(q) ;
                        ps.setString(1,userName);
						ps.setString(2,lic);
                        ps.setString(3,password);
                        ps.setString(4,email);
                        ps.setString(5,address);
                        ps.setString(6,city);
                        ps.setLong(7,cc);
                        int r= ps.executeUpdate();


			            if( r==1) {
				
				         return true;
			            }
		            }
					catch(Exception e)
					{
						System.out.print(e);
					}
				}		
		return false;
	}
}
