package carRental;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


public class AviewBook extends JFrame {
	static AviewBook frame;
	private JPanel contentPane;
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AviewBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AviewBook() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 416, 250);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		
//		JLabel lblAviewBook = new JLabel("View Booking");
//		lblAviewBook.setForeground(Color.GRAY);
//		lblAviewBook.setFont(new Font("Arial", Font.PLAIN, 24));
//		
//		JLabel LicId = new JLabel("Licence Id :");
//		LicId.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		
//		
//		
//		textField = new JTextField();
//		textField.setColumns(10);
//		
//		
//		
//		JButton btnAviewBook = new JButton("Confirm");
//		btnAviewBook.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		btnAviewBook.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String licId=textField.getText();
//				
//				Authentication authentication = null;
//        try
//	   {
//           String res="";
//         authentication = (Authentication)Naming.lookup("rmi://localhost:5252/auth");
//           String status = authentication.viewBooking(licId,res);
//			
//			if(!status.isEmpty()) {
//		         
//        		JOptionPane.showMessageDialog(AviewBook.this, status);
//				//System.out.println(status);
//				AdminSuccess.main(new String[]{});
//				frame.dispose();
//				
//				
//			} else {
//				JOptionPane.showMessageDialog(AviewBook.this, "Can't find  booking ");
//				System.out.println("cant find booking !!!!!!!");
//			}
//			
//		
//			
//		} 
//		catch (RemoteException ee) {
//			
//			System.out.println(ee.getMessage());
//			ee.printStackTrace();
//		}
//		catch (MalformedURLException ee) {
//			
//			System.out.println(ee.getMessage());
//			ee.printStackTrace();
//		}
//		catch (Exception ee)
//        {
//	       System.out.print(ee);
//        }
//				
//				
//		}
//		});
//		
//		JLabel lblNewLabel = new JLabel(" ");
//		lblNewLabel.setForeground(Color.RED);
//		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
//		
//		JButton btnBack = new JButton("Back");
//		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		btnBack.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			  AdminSuccess.main(new String[]{});
//				frame.dispose();
//			}
//		});
//		GroupLayout gl_contentPane = new GroupLayout(contentPane);
//		gl_contentPane.setHorizontalGroup(
//			gl_contentPane.createParallelGroup(Alignment.TRAILING)
//				.addGroup(gl_contentPane.createSequentialGroup()
//					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//						.addGroup(gl_contentPane.createSequentialGroup()
//							.addGap(124)
//							.addComponent(lblAviewBook))
//						.addGroup(gl_contentPane.createSequentialGroup()
//							.addGap(31)
//							.addComponent(LicId)
//							.addGap(32)
//							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)))
//					.addContainerGap(96, GroupLayout.PREFERRED_SIZE))
//				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
//					.addGap(50)
//					.addComponent(btnAviewBook, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
//					.addGap(69)
//					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
//					.addContainerGap(99, Short.MAX_VALUE))
//		);
//		gl_contentPane.setVerticalGroup(
//			gl_contentPane.createParallelGroup(Alignment.LEADING)
//				.addGroup(gl_contentPane.createSequentialGroup()
//					.addComponent(lblAviewBook)
//					.addGap(26)
//					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
//						.addComponent(LicId)
//						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
//					.addGap(31)
//					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
//						.addComponent(btnAviewBook, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
//						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
//					.addContainerGap(58, Short.MAX_VALUE))
//		);
//		contentPane.setLayout(gl_contentPane);
//	}
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		String data[][]=null;
		String column[]=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");  
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/car","root","");  

			PreparedStatement ps=con.prepareStatement("select * from booking",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=ps.executeQuery(); 
			//  add content
			ResultSetMetaData rsmd=rs.getMetaData();
			int cols=rsmd.getColumnCount();
			column=new String[cols];
			for(int i=1;i<=cols;i++){
				column[i-1]=rsmd.getColumnName(i);
			}
			
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();

			data=new String[rows][cols];
			int count=0;
			while(rs.next()){
				for(int i=1;i<=cols;i++){
					data[count][i-1]=rs.getString(i);
				}
				count++;
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		
		JTable table = new JTable(data,column);
		JScrollPane sp=new JScrollPane(table);
		
		contentPane.add(sp, BorderLayout.CENTER);
}
}
