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


public class ReturnRide extends JFrame {
	static ReturnRide frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ReturnRide();
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
	public ReturnRide() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblReturnRide = new JLabel("Return Car");
		lblReturnRide.setForeground(Color.GRAY);
		lblReturnRide.setFont(new Font("Arial", Font.PLAIN, 21));
		
		JLabel LicId = new JLabel("Licence Id :");
		LicId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLabel carid = new JLabel("Car Id :");
		carid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLabel k = new JLabel("Final Reading (km) :");
		k.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		
		
		textField = new JTextField();
		textField.setColumns(10);
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		
		
		JButton btnReturnRide = new JButton("Proceed ");
		btnReturnRide.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReturnRide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String carId=textField_1.getText();
				String licid=textField.getText();
				String km=textField_2.getText();
				int res=0;
				
				Authentication authentication = null;
        try
	   {
           
         authentication = (Authentication)Naming.lookup("rmi://localhost:5252/auth");
           int status = authentication.RetR(licid,carId,km);
			
			if(status >=0) {
				
				if(status==0)
				{
					JOptionPane.showMessageDialog(ReturnRide.this, " Your ride has been return   !!!! ");
				System.out.println(" cancelled ");
				UserSuccess.main(new String[]{});
				frame.dispose();
				}
				else{
					
		         
        		JOptionPane.showMessageDialog(ReturnRide.this, "  Additional amount to be paid is "+status+" for late  ( click ok to pay ) ");
				JOptionPane.showMessageDialog(ReturnRide.this, " Your ride has been return   !!!! ");
				System.out.println(" Deleted ");
				UserSuccess.main(new String[]{});
				frame.dispose();
				}
				
			} else {
				JOptionPane.showMessageDialog(ReturnRide.this, "No Booking Found Check Details Again !!!! ");
				System.out.println("Can't find booking !!!!!!!");
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
		
		
		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserSuccess.main(new String[]{});
				frame.dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnReturnRide, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
									.addGap(37)
									.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
									.addGap(21))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(LicId)
										.addComponent(k)
										.addComponent(carid, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
									.addGap(47)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
										.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(124)
							.addComponent(lblReturnRide, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblReturnRide)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(LicId)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(carid)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(k)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnReturnRide, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(33))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
