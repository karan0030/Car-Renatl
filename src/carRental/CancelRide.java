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
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;


public class CancelRide extends JFrame {
	static CancelRide frame;
	private JPanel contentPane;
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new CancelRide();
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
	public CancelRide() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 250);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		
		JLabel lblCancelRide = new JLabel("Cancel Booking");
		lblCancelRide.setForeground(Color.GRAY);
		lblCancelRide.setFont(new Font("Arial", Font.BOLD, 21));
		
		JLabel LicId = new JLabel("Licence Id :");
		LicId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		
		textField = new JTextField();
		textField.setColumns(10);
		
		
		
		JButton btnCancelRide = new JButton("Confirm");
		btnCancelRide.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelRide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String licId=textField.getText();
				String amt="";
				Authentication authentication = null;
        try
	   {
           
         authentication = (Authentication)Naming.lookup("rmi://localhost:5252/auth");
           String status = authentication.cancelride(licId,amt);
			
			if(!status.isEmpty()) {
		         
        		JOptionPane.showMessageDialog(CancelRide.this, " Your ride has been canceled refund of rs "+status+" will be initaiated soon");
				System.out.println(" Deleted ");
				UserSuccess.main(new String[]{});
				frame.dispose();
				
				
			} else {
				JOptionPane.showMessageDialog(CancelRide.this, "No Booking found Check licence id  again !!!! ");
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
			//	UserSuccess.main(new String[]{});
				frame.dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addComponent(LicId)
							.addGap(32)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCancelRide, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCancelRide, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(211, Short.MAX_VALUE)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
					.addGap(84))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCancelRide)
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(LicId)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancelRide, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(79, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
