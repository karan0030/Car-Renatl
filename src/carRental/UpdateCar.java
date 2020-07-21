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
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class UpdateCar extends JFrame {
	static UpdateCar frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
		private JTextField textField_5;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new UpdateCar();
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
	public UpdateCar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAdd = new JLabel("Update Car ");
		lblAdd.setForeground(Color.DARK_GRAY);
		lblAdd.setFont(new Font("Arial", Font.PLAIN, 24));
		
		JLabel CarType = new JLabel("Car Type:");
		CarType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLabel CarId = new JLabel("Car Id:");
		CarId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLabel ModelName= new JLabel("Model Name:");
		ModelName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLabel Status = new JLabel("Status :");
		Status.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLabel Update = new JLabel("Update ADD or Remove:");
		Update.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		
		textField = new JTextField();
		textField.setColumns(10);
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		
		
		
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			String cartype=textField.getText();
			String update=(textField_3.getText());
			String carid=textField_1.getText();
			String stat=textField_2.getText();
			String cname=textField_4.getText();
			
				Authentication authentication = null;
        try
	   {
           boolean status;
         authentication = (Authentication)Naming.lookup("rmi://localhost:5252/auth");
		  if(update.equalsIgnoreCase("add"))
		  {
			 status = authentication.addCar(cartype,carid,cname,stat);
		  }
		  else
		  {
			   status = authentication.removeCar(carid);
		  }  
			if(status) {
		         
        		JOptionPane.showMessageDialog(UpdateCar.this," Updated ");
				//System.out.println(status);
			AdminSuccess.main(new String[]{});
			frame.dispose();
				
				
			} else {
				JOptionPane.showMessageDialog(UpdateCar.this,"Failed  try later !!! ");
				System.out.println(" Failed  to update !!!!!!!");
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
		btnNewButton.setForeground(Color.DARK_GRAY);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AdminSuccess.main(new String[]{});
			frame.dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(133)
					.addComponent(lblAdd, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(131, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(CarId)
							.addComponent(CarType)
							.addComponent(ModelName)
							.addComponent(Status)
							.addComponent(Update)))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(textField_3)
							.addComponent(textField_2)
							.addComponent(textField_4)
							.addComponent(textField)
							.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblAdd)
							.addGap(49))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(CarType))
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(CarId))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(ModelName)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(Status)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(Update)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
					.addContainerGap(111, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
