import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class Chlaan extends JFrame implements ActionListener
{
	JPanel pmenu,pmaster;
	JLabel vehi_num,chlaan_type,fine,fine_paid,balance,head;
	JTextField t_vehi_num,t_chlaan_type,t_fine,t_finepaid,t_balance;
	String  fine1,vehicle,taken,chlaantype,fine_check,bal1;
	int fine2,fine_1,bal;
	JButton submit,reset;

	Chlaan(String t)
	{
		taken=t;
		setTitle("Chlaan");
		setSize(680, 500);
        setLocationRelativeTo(null); 
        setResizable(false);
        
		Color my = Color.decode("#DC3D24");
        Color myColor = Color.decode("#FFFFFF");
		
		head=new JLabel("Pay Chlaan");
			head.setForeground(myColor);
			head.setFont(new Font("Garamond", Font.BOLD, 34));	
		
		
		vehi_num=new JLabel("Vehicle Number");
			vehi_num.setForeground(myColor);
			vehi_num.setFont(new Font("Garamond", Font.BOLD, 20));	
		
		chlaan_type=new JLabel("Chlaan Type");
			chlaan_type.setForeground(myColor);
			chlaan_type.setFont(new Font("Garamond", Font.BOLD, 20));	
		fine=new JLabel("Fine to be Paid");
			fine.setForeground(myColor);
			fine.setFont(new Font("Garamond", Font.BOLD, 20));	
		fine_paid=new JLabel("Fine Paid");
			fine_paid.setForeground(myColor);
			fine_paid.setFont(new Font("Garamond", Font.BOLD, 20));	
		balance=new JLabel("Balance Given");
			balance.setForeground(myColor);
			balance.setFont(new Font("Garamond", Font.BOLD, 20));	
		submit=new JButton("Pay");
		reset=new JButton("Reset");
		submit.setBackground(my);
		submit.setForeground(myColor);
		submit.setFont(new Font("Garamond", Font.BOLD, 20));

		reset.setBackground(my);
		reset.setForeground(myColor);
		reset.setFont(new Font("Garamond", Font.BOLD, 20));
		
		t_chlaan_type=new JTextField(10);
			t_chlaan_type.setBackground(my);
			t_chlaan_type.setForeground(myColor);
			t_chlaan_type.setEnabled(false);
		t_fine=new JTextField(10);
			t_fine.setBackground(my);
			t_fine.setForeground(myColor);
			t_fine.setEnabled(false);
		t_balance=new JTextField(10);
			t_balance.setBackground(my);
			t_balance.setForeground(myColor);
			t_balance.setEnabled(false);

		t_vehi_num=new JTextField(10);
			t_vehi_num.setBackground(my);
			t_vehi_num.setForeground(myColor);
		t_vehi_num.addKeyListener(new KeyAdapter() 
			{
				public void keyPressed(KeyEvent e) 
				{
					int keyCode = e.getKeyCode();
					if(e.getKeyCode() == 10) 
					{
						vehicle=t_vehi_num.getText().trim();
							t_vehi_num.setEnabled(false);
						try
						{
							Class.forName("com.mysql.jdbc.Driver");
							Connection con = DriverManager.getConnection("jdbc:mysql:///suvidha","root","");
							Statement st = con.createStatement();
							String x = "Select * from chlaan where vehicle='"+vehicle+"' ";
							ResultSet rd=st.executeQuery(x);
							if(rd.next())
							{
								int check=Integer.parseInt(rd.getString(7));
								
								if(check>0)
								{
									JOptionPane.showMessageDialog(pmaster,"Bill is already Paid");
									t_vehi_num.setEnabled(true);
								}
								else
								{
									fine1=rd.getString(4);
										fine_1=Integer.parseInt(fine1);
									chlaantype=rd.getString(3);
									
									t_fine.setText(fine1);
									t_chlaan_type.setText(chlaantype);
								}
							}
							else
							{
								JOptionPane.showMessageDialog(pmaster,"Vehicle Number is not Correct");
								t_vehi_num.setEnabled(true);
							}
						}
						catch(Exception e1)
						{
							System.out.println("Exception in fetching: " +e1);
						}
						
					}
				}
			});	
			t_finepaid=new JTextField(10);		
				t_finepaid.setBackground(my);
				t_finepaid.setForeground(myColor);
			t_finepaid.addKeyListener(new KeyAdapter() 
			{
				public void keyPressed(KeyEvent ev) 
				{
					int keyCode = ev.getKeyCode();
					if(ev.getKeyCode() == 10) 
					{
						t_finepaid.setEnabled(false);
						fine2=Integer.parseInt(t_finepaid.getText().trim());
						
						if(fine2>=fine_1)
						{
							if(fine_1==(fine2-1000))
							{
								JOptionPane.showMessageDialog(pmaster,"You are giving Insufficient Extra Amount");
								t_finepaid.setEnabled(true);
							}
							else
							{
								bal=fine2-fine_1;
									bal1=String.valueOf(bal);
								t_balance.setText(bal1);
									t_balance.setEnabled(false);
							}
						}
						else
						{
							JOptionPane.showMessageDialog(pmaster,"Balance is not Enough");
							t_finepaid.setEnabled(true);
						}
					}
				}
			});	
	
			pmenu=new JPanel(new GridLayout(6,2,5,5));

			pmenu.add(vehi_num);
			pmenu.add(t_vehi_num);
						
			pmenu.add(chlaan_type);
			pmenu.add(t_chlaan_type);
			
			pmenu.add(fine);
			pmenu.add(t_fine);
			
			pmenu.add(fine_paid);
			pmenu.add(t_finepaid);
			
			pmenu.add(balance);
			pmenu.add(t_balance);
						
			pmenu.add(submit);
			pmenu.add(reset);

		pmaster=new JPanel(null);
			pmaster.setBackground(my);
			pmenu.setBackground(my);
			pmaster.add(head);
				head.setBounds(180,10,400,100);
			
			pmaster.add(pmenu);
				pmenu.setBounds(170,100,350,250);
		add(pmaster);

		reset.addActionListener(this);
		submit.addActionListener(this);		
		setLocationRelativeTo(null);
		setResizable(false);			
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==reset)
		{
			t_vehi_num.setText("");
				t_vehi_num.setEnabled(true);
			t_fine.setText("");
			t_finepaid.setText("");
				t_finepaid.setEnabled(true);
			t_balance.setText("");
			t_chlaan_type.setText("");
		}
		vehicle=t_vehi_num.getText().trim();
		fine_check=t_finepaid.getText().trim();
		
		if(ae.getSource()==submit)
		{
			if(vehicle.equals(""))
			{
				JOptionPane.showMessageDialog(pmaster,"Enter Vehicle Number");
			}
			else if(fine_check.equals(""))
			{
				JOptionPane.showMessageDialog(pmaster,"Enter Fine to be pay");
			}
		
			else
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql:///suvidha","root","");
					Statement st = con.createStatement();
			
					String u="Update chlaan set fine_paid='"+fine_check+"',balance='"+bal1+"',status='1' where vehicle='"+vehicle+"' ";
					int i=st.executeUpdate(u);
					if(i>0)
					{
						JOptionPane.showMessageDialog(pmaster,"Bill Paid");
						setVisible(false);
					}
				}
				catch(Exception e)
				{
					System.out.println("Exception in Updation: " +e);
				}
			}
		}		
	}
}