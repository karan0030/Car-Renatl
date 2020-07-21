package carRental;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class BookRide extends JFrame {
	static BookRide frame;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new BookRide();
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
	public BookRide() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame frame = new JFrame("SetBounds Method Test");
	      frame.setSize(600, 700);
		setBounds(100, 100, 600, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Book  a  Ride");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNewLabel.setForeground(Color.GRAY);
		
		
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
	   
		
		JLabel LicId = new JLabel("Licence ID :");
		LicId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLabel CarType = new JLabel("Car Type :");
		CarType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLabel From = new JLabel("Start :");
		From.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLabel To = new JLabel("Destination :");
		To.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLabel Date1 = new JLabel("Book from ( dd\\mm\\yyyy ) :");
		Date1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLabel Date2 = new JLabel("Book Till ( dd\\mm\\yyyy ):");
		Date2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLabel UserContact = new JLabel("User Contact:");
		UserContact.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLabel km = new JLabel("Estimate distance in km :");
		km.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnBook = new JButton("Confirm");
		btnBook.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String cartype=textField_1.getText();
			String licid=textField_2.getText();
			String from=textField_3.getText();
			String to=textField_4.getText();
			String d1=textField_5.getText();
			String d2=textField_6.getText();
			String contact=textField_7.getText();
			String k=textField_8.getText();
			
        		Authentication authentication = null;
        try
	   {
		   int kk = Integer.parseInt(k);
		  // String carid = "xyz";
        int amt =  kk*10 +450;
		JOptionPane.showMessageDialog(BookRide.this,"Amount to be paid is (amount paid by upi by pressing ok) "+amt);
		
         authentication = (Authentication)Naming.lookup("rmi://localhost:5252/auth");
		 
          boolean status = authentication.bookRide(licid,cartype,from,to,d1,d2,k,contact,amt);
			
			if(status ) {
		         
        		JOptionPane.showMessageDialog(BookRide.this,"Your ride has been booked");
				//System.out.println(status);
				UserSuccess.main(new String[]{});
				frame.dispose();
				
				
			} else {
				JOptionPane.showMessageDialog(BookRide.this, "Can't  book right now check details again !!! ");
				System.out.println("can't book right now!!!!!!!");
			}
			
		
			
		} 
		catch (RemoteException ee) {
			
			System.out.println(ee.getMessage());
			ee.printStackTrace();
		}
		catch (MalformedURLException ee) {
			
			System.out.println(ee.getMessage());
			ee.printStackTrace();
		}
		catch (Exception ee)
        {
	       System.out.print(ee);
        }
		
			}
		});
		
		
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserSuccess.main(new String[]{});
				frame.dispose();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Note: Check Licence id before booking !");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1.setForeground(Color.RED);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(CarType)
								.addComponent(From)
								.addComponent(To)
								.addComponent(LicId)
								.addComponent(Date2))
							.addGap(387))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(Date1)
									.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))))
							.addGap(100))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(121)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(168, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(km)
					.addContainerGap(340, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(UserContact)
					.addContainerGap(407, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(84)
					.addComponent(btnBook, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(63)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(154, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel)
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(CarType)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(LicId)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(From)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(To)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(Date2)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(Date1)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(km)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(UserContact)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBook, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
					.addGap(157)
					.addComponent(lblNewLabel_1)
					.addGap(25))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
