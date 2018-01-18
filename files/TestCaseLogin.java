import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.util.regex.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

class TestCaseLogin extends JFrame implements ActionListener{
	JPanel ptemp,pmaster;
	JButton Custom,tc1,tc3;
	JLabel emp_password,username,head;
	JTextField  temp_username;
	JPasswordField temp_password;
	private JButton tc2;
	private JButton tc4;
	
	
	TestCaseLogin(){
		setTitle("Test Case");
		setSize(680, 500);
        setLocationRelativeTo(null); 
        setResizable(false);
        
		Color my = Color.decode("#DC3D24");
        Color myColor = Color.decode("#FFFFFF");

		emp_password=new JLabel("Password");		
			emp_password.setForeground(myColor);
			emp_password.setFont(new Font("Garamond", Font.BOLD, 20));
		username=new JLabel("UserName");
			username.setForeground(myColor);
			username.setFont(new Font("Garamond", Font.BOLD, 20));
		head=new JLabel("Test Case");
			head.setForeground(myColor);
			head.setFont(new Font("Garamond", Font.BOLD, 34));
		temp_password=new JPasswordField(10);
			temp_password.setBackground(my);
			temp_password.setForeground(myColor);
        temp_username=new JTextField(10);
			temp_username.setBackground(my);
			temp_username.setForeground(myColor);
		ButtonGroup bg = new ButtonGroup();
		
		Custom=new JButton("Check Custom Input");
			Custom.setBackground(my);
			Custom.setForeground(myColor);
			Custom.setFont(new Font("Garamond", Font.BOLD, 20));
			Custom.addActionListener(this);
			

			tc1=new JButton("Test Case 1");
			tc1.setBackground(my);
			tc1.setForeground(myColor);
			tc1.setFont(new Font("Garamond", Font.BOLD, 20));
			tc1.addActionListener(this);
			
			tc3=new JButton("Test Case 3");
			tc3.setBackground(my);
			tc3.setForeground(myColor);
			tc3.setFont(new Font("Garamond", Font.BOLD, 20));
			tc3.addActionListener(this);
		
			
		ptemp=new JPanel(new GridLayout(13,2,5,5));
			ptemp.setBackground(my);
			
			ptemp.add(username);
			ptemp.add(temp_username);
			
			ptemp.add(emp_password);
			ptemp.add(temp_password);
			
			ptemp.add(Custom);
			
			ptemp.add(tc1);
			
			tc2 = new JButton("Test Case 2");
			tc2.setForeground(Color.WHITE);
			tc2.setFont(new Font("Garamond", Font.BOLD, 20));
			tc2.setBackground(new Color(220, 61, 36));
			tc2.addActionListener(this);
			ptemp.add(tc2);
			ptemp.add(tc3);
			
		pmaster=new JPanel(null);
			pmaster.setBackground(my);
        
			pmaster.add(head);
				head.setBounds(281,13,174,100);	
			pmaster.add(ptemp);
				ptemp.setBounds(170,100,350,380);
				
				tc4 = new JButton("Test Case 4");
				tc4.setForeground(Color.WHITE);
				tc4.setFont(new Font("Garamond", Font.BOLD, 20));
				tc4.setBackground(new Color(220, 61, 36));
				tc4.addActionListener(this);
				ptemp.add(tc4);
				
				
			getContentPane().add(pmaster);
		setLocationRelativeTo(null);
		setResizable(false);			
		setVisible(true);			
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==tc1)
		{
			Login.tusername.setText("admin");
			Login.tpassword.setText("1234567");
		}
		if(ae.getSource()==tc2)
		{
			Login.tusername.setText("aayu");
			Login.tpassword.setText("aayu");
		}
		if(ae.getSource()==tc3)
		{
			Login.tusername.setText("aarchi");
			Login.tpassword.setText("aarchi");
		}
		if(ae.getSource()==tc4)
		{
			Login.tusername.setText("xyz");
			Login.tpassword.setText("mno");
		}
		if(ae.getSource()==Custom)
		{
			String test1=temp_username.getText().trim();
			String test2=temp_password.getText().trim();
			Login.tusername.setText(test1);
			Login.tpassword.setText(test2);
		}
	}
}