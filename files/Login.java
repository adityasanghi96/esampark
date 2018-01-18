import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

	class Login extends JFrame implements ActionListener
	{
		JPanel logintemp,loginmaster,temp;
		JButton login,reset;
		JLabel username,password,head,log;
		static JTextField tusername;
		static JPasswordField tpassword;
		String t_username,t_password,t_username1,t_password1;

	Login()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Login");
		setSize(1360,700);
		setLocationRelativeTo(null); 
        setResizable(false);
        
		Color my = Color.decode("#DC3D24");
        Color myColor = Color.decode("#FFFFFF");
		
		head=new JLabel("Suvidha Center");
		head.setForeground(myColor);
		head.setFont(new Font("Garamond", Font.BOLD, 50));

		log=new JLabel("Login Here");
		log.setForeground(myColor);
		log.setFont(new Font("myColor", Font.BOLD, 34));
		
		username=new JLabel("User Name");
		password=new JLabel("Password");
		
		username.setForeground(myColor);
        username.setFont(new Font("Garamond", Font.BOLD, 20));
		password.setForeground(myColor);
        password.setFont(new Font("Garamond", Font.BOLD, 20));

		tusername=new JTextField(15);
		tpassword=new JPasswordField(15);
		tusername.setBackground(my);
        tusername.setForeground(myColor);
        tpassword.setBackground(my);
        tpassword.setForeground(myColor);
        
		login=new JButton("Login");
		reset=new JButton("Reset");
		login.setBackground(my);
        login.setForeground(myColor);
        login.setFont(new Font("Garamond", Font.BOLD, 20));
        reset.setBackground(my);
        reset.setForeground(myColor);
        reset.setFont(new Font("Garamond", Font.BOLD, 20));
        
		login.addActionListener(this);
		reset.addActionListener(this);
	
	tpassword.addKeyListener(new KeyAdapter() 
	   {
			public void keyPressed(KeyEvent e1) 
			{
				t_username1=tusername.getText().trim();
				t_password1=tpassword.getText().trim();
				int keyCode = e1.getKeyCode();
		
				if (keyCode== 10) 
				{
					if(t_username1.equals(""))
					{
						JOptionPane.showMessageDialog(loginmaster,"Enter Your Username");
					}
					else if(t_password1.equals(""))
					{
						JOptionPane.showMessageDialog(loginmaster,"Enter Your Password");
					}
					else
					{
						try
						{
							Class.forName("com.mysql.jdbc.Driver");
							Connection con = DriverManager.getConnection("jdbc:mysql:///suvidha","root","");
							Statement st = con.createStatement();
					
							String x = "Select * from employee_register where userid=+'"+t_username1+"' and password='"+t_password1+"'";
							ResultSet rd=st.executeQuery(x);
							if(rd.next())
							{
								Menu obj = new Menu(t_username1);
								setVisible(false);
							}
							else
							{
								String q = "Select * from admin where username=+'"+t_username1+"' and password='"+t_password1+"'";
								ResultSet rs=st.executeQuery(q);
								if(rs.next())
								{
									Admin_Main obj =new Admin_Main();
									setVisible(false);
								}
				 
								else
								{
									JOptionPane.showMessageDialog(loginmaster,"Enter correct Username Or Password");
									tusername.setText("");
									tpassword.setText("");
								}
							}
						}
				
						catch(Exception e)
						{
							System.out.println("Exception in login: \n"+e);
						}
					}
					
                }
			}
		});
		
			
			
		logintemp= new JPanel(new GridLayout(3,2,5,5));
			logintemp.setBackground(my);
			logintemp.add(username);
			logintemp.add(tusername);
			
			logintemp.add(password);
			logintemp.add(tpassword);
			
			logintemp.add(login);
			logintemp.add(reset);
						
		loginmaster= new JPanel(null);
		loginmaster.setBackground(my);
				loginmaster.add(head);
				head.setBounds(480,97,350,97);
			loginmaster.add(log);
				log.setBounds(551,186,201,50);
				
			loginmaster.add(logintemp);
				logintemp.setBounds(480,280,350,80);
		getContentPane().add(loginmaster);
		
		JButton btnTest = new JButton("Test");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 TestCaseLogin obj = new TestCaseLogin();
			}
		});
		btnTest.setBounds(1200, 612, 97, 25);
		loginmaster.add(btnTest);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		t_username=tusername.getText().trim();
		t_password=tpassword.getText().trim();
		
		if(ae.getSource()==reset)
		{
			tusername.setText("");
			tpassword.setText("");
		}
		
		if(ae.getSource()==login)
		{
			if(t_username.equals(""))
			{
				JOptionPane.showMessageDialog(loginmaster,"Enter Your Username");
			}
			else if(t_password.equals(""))
			{
				JOptionPane.showMessageDialog(loginmaster,"Enter Your Password");
			}
			else
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql:///suvidha","root","");
					Statement st = con.createStatement();
					
					String x = "Select * from employee_register where userid=+'"+t_username+"' and password='"+t_password+"'";
					ResultSet rd=st.executeQuery(x);
					
					if(rd.next())
					{
						Menu obj = new Menu(t_username);
						setVisible(false);
					}
					else
					{
						String q = "Select * from admin where username=+'"+t_username+"' and password='"+t_password+"'";
						ResultSet rs=st.executeQuery(q);
						if(rs.next())
						{
							Admin_Main obj =new Admin_Main();
							setVisible(false);
						}
				 
						else
						{
							JOptionPane.showMessageDialog(loginmaster,"Enter correct Username Or Password");
							tusername.setText("");
							tpassword.setText("");
						}
					}
				}
				
				catch(Exception e)
				{
					System.out.println("Exception in login: \n"+e);
				}
			}
		}
	}
	public static void main(String args[])
	{
		Login ob= new Login();
	}
}