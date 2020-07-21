package carRental;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



class Ctype extends JFrame  implements ActionListener
{
	static Ctype frame;
ImageIcon m[];
JLabel l;
JButton b,b1;
int i,l1;
JPanel p;
private JButton btnBack;

public Ctype()
{
   getContentPane().setLayout(new BorderLayout( ));
   setSize(620,600);
   setVisible(true);
   JPanel p=new JPanel(new FlowLayout());
   p.setBackground(Color.BLACK);
   b=new JButton("Pre");
   b.setFont(new Font("Tahoma", Font.PLAIN, 14));
   b1=new JButton("Next");
   b1.setFont(new Font("Tahoma", Font.PLAIN, 14));
   p.add(b);
   p.add(b1);
   getContentPane().add(p,BorderLayout.SOUTH);
   
   btnBack = new JButton("Back");
   btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
   btnBack.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			UserSuccess.main(new String[]{});
			frame.dispose();
		}
	});
   
   p.add(btnBack);
   b.addActionListener(this);
   b1.addActionListener(this);
   m = new ImageIcon[4];
   m[0] = new ImageIcon("pic/11.jpg");
   m[1] = new ImageIcon("pic/22.jpg");
   m[2] = new ImageIcon("pic/33.jpg");
   m[3] = new ImageIcon("pic/44.jpg");
   l = new JLabel();
   l.setForeground(Color.DARK_GRAY);
   l.setBackground(Color.WHITE);
   l.setBounds(140, 140,840,640);
   getContentPane().add(l,BorderLayout.CENTER);
//   l.setIcon(m[0]);
   l.setIcon(new ImageIcon(m[0].getImage().getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_DEFAULT)));
//   l.drawImage(m[0], 0, 0, getWidth(), getHeight(), this);

}
public  void actionPerformed(ActionEvent e)
{

   if(e.getSource()==b)
   {
       if(i==0)
       {  
    	   i=3;
          // JOptionPane.showMessageDialog(null,"This is First Image");
       }
       else
           {
           i=i-1;
//           l.setIcon(m[i]);
           l.setIcon(new ImageIcon(m[i].getImage().getScaledInstance(l.getWidth(),l.getHeight(), Image.SCALE_DEFAULT)));
       }
   }
   if(e.getSource()==b1)
   {
       if(i==m.length-1)
       {  
    	   i=0;
          // JOptionPane.showMessageDialog(null,"This is LastImage");
       }
       else
           {
           i=i+1;
//           l.setIcon(m[i]);
           l.setIcon(new ImageIcon(m[i].getImage().getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_DEFAULT)));
           }
			}

    }

public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				frame= new Ctype();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}



}