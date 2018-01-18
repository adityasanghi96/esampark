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

class Employee_Register extends JFrame implements ActionListener{
	JPanel ptemp,pgender,pmaster;
	JButton submit,reset;
	String name,userid,joining,shift,password,phone,state,city,street,email;
	JLabel emp_name,emp_userid,emp_password,emp_joining,emp_work,emp_phone,emp_gender,emp_email,emp_street,emp_city,emp_state,head;
	static JTextField  temp_name;
	static JTextField temp_userid;
	static JTextField temp_joining;
	static JTextField temp_phone;
	static JTextField temp_email;
	static JTextField temp_street;
	static JTextField temp_city;
	static JTextField temp_state;
	static JRadioButton male;
	static JRadioButton female;
	static JPasswordField temp_password;
	static JComboBox temp_shift;
	String date;
	private JButton btnTest;
	
	Employee_Register(){
		setTitle("Employee Registeration");
		setSize(680, 500);
        setLocationRelativeTo(null); 
        setResizable(false);
        
		Color my = Color.decode("#DC3D24");
        Color myColor = Color.decode("#FFFFFF");

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		date = df.format(new Date());
		
		emp_name=new JLabel("Employee Name");
			emp_name.setForeground(myColor);
			emp_name.setFont(new Font("Garamond", Font.BOLD, 20));
		emp_userid=new JLabel("Login-id");
			emp_userid.setForeground(myColor);
			emp_userid.setFont(new Font("Garamond", Font.BOLD, 20));
		emp_password=new JLabel("Password");		
			emp_password.setForeground(myColor);
			emp_password.setFont(new Font("Garamond", Font.BOLD, 20));
		emp_joining=new JLabel("Date Of joining");
			emp_joining.setForeground(myColor);
			emp_joining.setFont(new Font("Garamond", Font.BOLD, 20));
		emp_work=new JLabel("Work Type");
			emp_work.setForeground(myColor);
			emp_work.setFont(new Font("Garamond", Font.BOLD, 20));
		emp_phone=new JLabel("Phone Number");
			emp_phone.setForeground(myColor);
			emp_phone.setFont(new Font("Garamond", Font.BOLD, 20));
		emp_gender=new JLabel("Gender");
			emp_gender.setForeground(myColor);
			emp_gender.setFont(new Font("Garamond", Font.BOLD, 20));
		emp_state=new JLabel("State");
			emp_state.setForeground(myColor);
			emp_state.setFont(new Font("Garamond", Font.BOLD, 20));
		emp_city=new JLabel("City");
			emp_city.setForeground(myColor);
			emp_city.setFont(new Font("Garamond", Font.BOLD, 20));
		emp_street=new JLabel("Street");
			emp_street.setForeground(myColor);
			emp_street.setFont(new Font("Garamond", Font.BOLD, 20));
		emp_email=new JLabel("Email-Id");
			emp_email.setForeground(myColor);
			emp_email.setFont(new Font("Garamond", Font.BOLD, 20));
		head=new JLabel("Register Employee");
			head.setForeground(myColor);
			head.setFont(new Font("Garamond", Font.BOLD, 34));
				
		temp_name=new JTextField(10);
			temp_name.setBackground(my);
			temp_name.setForeground(myColor);
        
		temp_state=new JTextField(10);
			temp_state.setBackground(my);
			temp_state.setForeground(myColor);
		temp_city=new JTextField(10);
			temp_city.setBackground(my);
			temp_city.setForeground(myColor);
		temp_street=new JTextField(10);
			temp_street.setBackground(my);
			temp_street.setForeground(myColor);
		temp_userid=new JTextField(10);
			temp_userid.setBackground(my);
			temp_userid.setForeground(myColor);
			temp_userid.setEnabled(false);
			
		temp_joining=new JTextField(10);
			temp_joining.setBackground(my);
			temp_joining.setForeground(myColor);
			temp_joining.setText(date);
			temp_joining.setEnabled(false);
		temp_shift = new JComboBox();
			temp_shift.setBackground(my);
			temp_shift.setForeground(myColor);
			temp_shift.addItem("--Select Work--");
			temp_shift.addItem("Water Bill");
			temp_shift.addItem("Electricity Bill");
			temp_shift.addItem("Pay Chlaan");
		temp_password=new JPasswordField(10);
			temp_password.setBackground(my);
			temp_password.setForeground(myColor);
			temp_password.setEnabled(false);
        temp_email=new JTextField(10);
			temp_email.setBackground(my);
			temp_email.setForeground(myColor);
			temp_email.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) 
			{
				int keyCode = e.getKeyCode();
				String test=temp_email.getText().trim();
				if (e.getKeyCode() == 10) 
				{
					if(test.equals("")){
						JOptionPane.showMessageDialog(pmaster,"Email-ID is Required");	
					}else{
						String exp="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"; 
						CharSequence seq = test;
						Pattern pattern = Pattern.compile(exp,Pattern.CASE_INSENSITIVE); 
						Matcher m = pattern.matcher(seq);
						if (m.matches()) {
							temp_email.setEnabled(false);
					
							String alphaNumerics = "abcdefghijklmnopqrstuvwxyz1234567890";
							String t = "";
							for (int i = 0; i < 5; i++) 
							{
								t =t+ alphaNumerics.charAt((int) (Math.random() * alphaNumerics.length()));
								temp_userid.setText("E"+t);
								temp_password.setText("E"+t);
							}
						
						}
							else{
								JOptionPane.showMessageDialog(pmaster,"Email id is not valid");
							}
					}
					
				}
			}
		});		
		
		temp_phone=new JTextField(10);
			temp_phone.setBackground(my);
			temp_phone.setForeground(myColor);
			
    	male = new JRadioButton("Male");
			male.setSelected(true);
		female = new JRadioButton("Female");
		
		ButtonGroup bg = new ButtonGroup();
			bg.add(male);
			bg.add(female);
		JPanel pgender= new JPanel();
			pgender.setBackground(my);
			pgender.setForeground(my);
			pgender.add(male);
			pgender.add(female);
		
		submit=new JButton("Register");
			submit.setBackground(my);
			submit.setForeground(myColor);
			submit.setFont(new Font("Garamond", Font.BOLD, 20));
			submit.addActionListener(this);
		reset=new JButton("Reset");
			reset.setBackground(my);
			reset.setForeground(myColor);
			reset.setFont(new Font("Garamond", Font.BOLD, 20));
			reset.addActionListener(this);
		
		ptemp=new JPanel(new GridLayout(13,2,5,5));
			ptemp.setBackground(my);
        
			ptemp.add(emp_name);
			ptemp.add(temp_name);
			
			ptemp.add(emp_gender);
			ptemp.add(pgender);
			
			ptemp.add(emp_phone);
			ptemp.add(temp_phone);
			
			ptemp.add(emp_street);
			ptemp.add(temp_street);
			
			ptemp.add(emp_city);
			ptemp.add(temp_city);
			
			ptemp.add(emp_state);
			ptemp.add(temp_state);
			
			ptemp.add(emp_email);
			ptemp.add(temp_email);
			
			ptemp.add(emp_userid);
			ptemp.add(temp_userid);
			
			ptemp.add(emp_password);
			ptemp.add(temp_password);
			
			ptemp.add(emp_joining);
			ptemp.add(temp_joining);
			
			ptemp.add(emp_work);
			ptemp.add(temp_shift);
			
			ptemp.add(submit);
			ptemp.add(reset);
			
		pmaster=new JPanel(null);
			pmaster.setBackground(my);
        
			pmaster.add(head);
				head.setBounds(180,10,400,100);	
			pmaster.add(ptemp);
				ptemp.setBounds(170,100,350,380);
			getContentPane().add(pmaster);
			
			btnTest = new JButton("Test");
			btnTest.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					TestCaseEmployee obj = new TestCaseEmployee();
				}
			});
			btnTest.setBounds(577, 440, 97, 25);
			pmaster.add(btnTest);
		setLocationRelativeTo(null);
		setResizable(false);			
		setVisible(true);			
	}
	public void actionPerformed(ActionEvent ae)
	{
		name=temp_name.getText().trim();
		userid=temp_userid.getText().trim();
		password=temp_password.getText().trim();
		joining=temp_joining.getText().trim();
		shift=(String)temp_shift.getSelectedItem();
		phone=temp_phone.getText().trim();
		email=temp_email.getText().trim();
		street=temp_street.getText().trim();
		state=temp_state.getText().trim();
		city=temp_city.getText().trim();
		String sgender = "";
		if(male.isSelected())
		{
			sgender = male.getText();
		}		
		else
		{
			sgender =female.getText();
		}
		if(ae.getSource()==reset)
		{
			temp_name.setText("");
			temp_userid.setText("");
			temp_joining.setText(date);
			temp_shift.setSelectedItem("--Select Work--");
			temp_password.setText("");
			temp_phone.setText("");
			temp_state.setText("");
			temp_city.setText("");
			temp_street.setText("");
			temp_email.setText("");
			temp_email.setEnabled(true);
			male.setSelected(true);
		}
		if(ae.getSource()==submit)
		{
			
			String exp2="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"; 
			CharSequence seq2 = email;
			Pattern pattern2 = Pattern.compile(exp2,Pattern.CASE_INSENSITIVE); 
			Matcher m2 = pattern2.matcher(seq2);
			if(name.equals(""))
			{
				JOptionPane.showMessageDialog(pmaster,"Please Enter Employee Name");
			}
		
			else if(phone.equals(""))
			{
				JOptionPane.showMessageDialog(pmaster,"Please Enter Employee Phone Number");
			}
			else if(street.equals(""))
			{
				JOptionPane.showMessageDialog(pmaster,"Please Enter Street");
			}
			else if(city.equals(""))
			{
				JOptionPane.showMessageDialog(pmaster,"Please Enter City ");
			}
			else if(state.equals(""))
			{
				JOptionPane.showMessageDialog(pmaster,"Please Enter State");
			}
			else if(email.equals(""))
			{
				JOptionPane.showMessageDialog(pmaster,"Please Enter Employee Email");
			}
			else if(shift.equals(""))
			{
			 JOptionPane.showMessageDialog(pmaster,"Please Enter Employee Shift Timing");
			}
			else if(!validtext(name))
				JOptionPane.showMessageDialog(pmaster,"Please Enter Valid Employee Name");
			else if(!validphone(phone))
				JOptionPane.showMessageDialog(pmaster,"Please Enter Valid Phone Number");
			else if(!validtext(city))
				JOptionPane.showMessageDialog(pmaster,"Please Enter Valid City Name");
			else if(!validtext(state))
				JOptionPane.showMessageDialog(pmaster,"Please Enter Valid State Name");
			else if (!m2.matches())
				JOptionPane.showMessageDialog(pmaster,"Please Enter Valid Email");
			else if(userid.equals("")||password.equals("")){
				JOptionPane.showMessageDialog(pmaster,"Username and Password is autogenerated");
				JOptionPane.showMessageDialog(pmaster,"Take Focus on ''Email textfield'' enter email id  and press Enter");
			}
			else
			{	String exp="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"; 
				CharSequence seq = email;
				Pattern pattern = Pattern.compile(exp,Pattern.CASE_INSENSITIVE); 
				Matcher m = pattern.matcher(seq);
				if (m.matches()) {
					temp_email.setEnabled(false);
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql:///suvidha","root","");
						Statement st = con.createStatement();
						String q="insert into employee_register(name,userid,password,gender,joining,shift,phone,email,street,state,city)values('"+name+"','"+userid+"','"+password+"','"+sgender+"','"+joining+"','"+shift+"','"+phone+"','"+email+"','"+street+"','"+state+"','"+city+"')";
						int i=st.executeUpdate(q);
						if(i>0)
						{
							JOptionPane.showMessageDialog(pmaster,"Employee Registered");
							setVisible(false);
						}
					}
					catch(Exception e)
					{
						System.out.println("Exceptionn e: "+e);
					}
				}
				else{
					JOptionPane.showMessageDialog(pmaster,"Email id is not valid");
					temp_email.setText("");
				}
			}
		}
	}
	boolean validtext(String s1)
	{
		char[] s=s1.toCharArray();
		for(int i=0;i<s.length;i++)
			if(s[i]!=' ')
			if((s[i]<65)||(s[i]>122)||(s[i]>90 && s[i]<97))
				return false;
	return true;
						
	}		
	
	boolean validphone(String s1)
	{
		char[] s=s1.toCharArray();
		if(s.length!=10)
			return false;
		for(int i=0;i<s.length;i++)
			if((s[i]<'0')||(s[i]>'9'))
				return false;
	return true;
						
	}
}