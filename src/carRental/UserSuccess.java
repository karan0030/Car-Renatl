package carRental;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserSuccess extends JFrame {
	static UserSuccess frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new UserSuccess();
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
	public UserSuccess() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 433);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel UserSection = new JLabel("Welcome to Car Rental");
		UserSection.setFont(new Font("Arial", Font.PLAIN, 24));
		
		JButton ret = new JButton("Return car ");
        ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ReturnRide.main(new String[]{});
			frame.dispose();
			}
		});
		ret.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton typ = new JButton("Car types ");
        typ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Ctype.main(new String[]{});
			frame.dispose();
			}
		});
		typ.setFont(new Font("Arial", Font.PLAIN, 14));
		
	
		JButton btnBookRide = new JButton("Book Ride");
		btnBookRide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookRide.main(new String[]{});
				frame.dispose();
			}
		});
		btnBookRide.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton btnViewBooking = new JButton("View Booking");
		btnViewBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewBooking.main(new String[]{});
				frame.dispose();
			}
		});
		btnViewBooking.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton btncancelRide = new JButton("Cancel Ride ");
		btncancelRide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelRide.main(new String[]{});
				frame.dispose();
			}
		});
		btncancelRide.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Car.main(new String[]{});
				frame.dispose();
			}
		});
		btnLogout.setFont(new Font("Arial", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(132)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.CENTER)
								.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
								.addComponent(btncancelRide, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnViewBooking, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBookRide, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
								.addComponent(ret, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
								.addComponent(typ, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(107)
							.addComponent(UserSection, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(UserSection)
					.addGap(18)
					.addComponent(typ, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnBookRide, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnViewBooking, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btncancelRide, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(ret, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}

