package carRental;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Font;

public class First extends JFrame {
	
	
	static First frame = new First();
	private JPanel contentPane;
	
	 JLabel pic;
	    Timer tm;
	    int x = 0;
	    //Images Path In Array
	    String[] list = {
	                      "pic/1.jpg",//0
	                      "pic/2.jpg",//1
	                      "pic/3.jpg",//2
	                      "pic/4.jpg"//3
	                    };
	    
	    public First(){

	    
	    		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    		setBounds(100, 100, 450, 300);
	    		contentPane = new JPanel();
	    		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    		contentPane.setLayout(new BorderLayout(0, 0));
	    		setContentPane(contentPane);
	    	

	    	
	    	
	      //  super("Java SlideShow");
	        pic = new JLabel();

	        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	        pic.setBounds(0,0,840,640);
	        // setVisible(true);

	        // pic.setBounds(40, 30, 1250, 650);

	        //Call The Function SetImageSize
	        SetImageSize(3);
	               //set a timer
	        tm = new Timer(1500,new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	                SetImageSize(x);
	                x =x+1;
	                if(x >= list.length )
	                {   x=0;tm.stop();
	                	Car.main(new String[]{});
	                	frame.dispose();
	                }
	                	 
	            }
	        });
	        getContentPane().add(pic, BorderLayout.WEST);
	        tm.start();
	        getContentPane().setLayout(null);
	        setSize(840, 640);
	        getContentPane().setBackground(Color.decode("#000000"));
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setVisible(true);
	    }

	    //function to resize the image 
	    public void SetImageSize(int i){
	        ImageIcon icon = new ImageIcon(list[i]);
	        Image img = icon.getImage();
	        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
	        ImageIcon newImc = new ImageIcon(newImg);
	        pic.setIcon(newImc);
	    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
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
	
}
