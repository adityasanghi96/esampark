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

class TestCaseEmployee extends JFrame implements ActionListener{
	JPanel ptemp,pgender,pmaster;
	JButton tc1,tc2;
	String name,userid,joining,shift,password,phone,state,city,street,email;
	JLabel emp_name,emp_work,emp_phone,emp_gender,emp_email,emp_street,emp_city,emp_state,head;
	JTextField  temp_name,temp_phone,temp_email,temp_street,temp_city,temp_state;
	JRadioButton male,female;
	JComboBox temp_shift;
	String date;
	private JButton Custom;
	private JButton tc3;
	private JButton tc4;
	
	TestCaseEmployee(){
		setTitle("Employee Registeration");
		setSize(680, 500);
        setLocationRelativeTo(null); 
        setResizable(false);
        
		Color my = Color.decode("#DC3D24");
        Color myColor = Color.decode("#FFFFFF");

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		date = df.format(new Date());
		
		emp_name=new JLabel("Employee Name");
		emp_name.setBounds(0, 4, 172, 21);
			emp_name.setForeground(myColor);
			emp_name.setFont(new Font("Garamond", Font.BOLD, 20));
		emp_work=new JLabel("Work Type");
		emp_work.setBounds(0, 217, 172, 21);
			emp_work.setForeground(myColor);
			emp_work.setFont(new Font("Garamond", Font.BOLD, 20));
		emp_phone=new JLabel("Phone Number");
		emp_phone.setBounds(0, 85, 172, 21);
			emp_phone.setForeground(myColor);
			emp_phone.setFont(new Font("Garamond", Font.BOLD, 20));
		emp_gender=new JLabel("Gender");
		emp_gender.setBounds(0, 38, 172, 21);
			emp_gender.setForeground(myColor);
			emp_gender.setFont(new Font("Garamond", Font.BOLD, 20));
		emp_state=new JLabel("State");
		emp_state.setBounds(0, 163, 172, 21);
			emp_state.setForeground(myColor);
			emp_state.setFont(new Font("Garamond", Font.BOLD, 20));
		emp_city=new JLabel("City");
		emp_city.setBounds(0, 137, 172, 21);
			emp_city.setForeground(myColor);
			emp_city.setFont(new Font("Garamond", Font.BOLD, 20));
		emp_street=new JLabel("Street");
		emp_street.setBounds(0, 111, 172, 21);
			emp_street.setForeground(myColor);
			emp_street.setFont(new Font("Garamond", Font.BOLD, 20));
		emp_email=new JLabel("Email-Id");
		emp_email.setBounds(0, 189, 172, 21);
			emp_email.setForeground(myColor);
			emp_email.setFont(new Font("Garamond", Font.BOLD, 20));
		head=new JLabel("Test Cases");
			head.setForeground(myColor);
			head.setFont(new Font("Garamond", Font.BOLD, 34));
				
		temp_name=new JTextField(10);
		temp_name.setBounds(177, 4, 172, 21);
			temp_name.setBackground(my);
			temp_name.setForeground(myColor);
        
		temp_state=new JTextField(10);
		temp_state.setBounds(177, 163, 172, 21);
			temp_state.setBackground(my);
			temp_state.setForeground(myColor);
		temp_city=new JTextField(10);
		temp_city.setBounds(177, 137, 172, 21);
			temp_city.setBackground(my);
			temp_city.setForeground(myColor);
		temp_street=new JTextField(10);
		temp_street.setBounds(177, 111, 172, 21);
			temp_street.setBackground(my);
			temp_street.setForeground(myColor);
		temp_shift = new JComboBox();
		temp_shift.setBounds(177, 218, 172, 21);
			temp_shift.setBackground(my);
			temp_shift.setForeground(myColor);
			temp_shift.addItem("--Select Work--");
			temp_shift.addItem("Water Bill");
			temp_shift.addItem("Electricity Bill");
			temp_shift.addItem("Pay Chlaan");
        temp_email=new JTextField(10);
        temp_email.setBounds(177, 189, 172, 21);
			temp_email.setBackground(my);
			temp_email.setForeground(myColor);
		
		temp_phone=new JTextField(10);
		temp_phone.setBounds(177, 85, 172, 21);
			temp_phone.setBackground(my);
			temp_phone.setForeground(myColor);
			
    	male = new JRadioButton("Male");
			male.setSelected(true);
		female = new JRadioButton("Female");
		
		ButtonGroup bg = new ButtonGroup();
			bg.add(male);
			bg.add(female);
		JPanel pgender= new JPanel();
		pgender.setBounds(177, 30, 172, 42);
			pgender.setBackground(my);
			pgender.setForeground(my);
			pgender.add(male);
			pgender.add(female);
		
		ptemp=new JPanel();
			ptemp.setBackground(my);
			ptemp.setLayout(null);
        
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
			
			ptemp.add(emp_work);
			ptemp.add(temp_shift);
			
		pmaster=new JPanel(null);
			pmaster.setBackground(my);
        
			pmaster.add(head);
				head.setBounds(262,13,400,59);	
			pmaster.add(ptemp);
				ptemp.setBounds(169,73,350,355);

				Custom = new JButton("Check Custom");
				Custom.setForeground(Color.WHITE);
				Custom.setFont(new Font("Garamond", Font.BOLD, 20));
				Custom.setBackground(new Color(220, 61, 36));
				Custom.setBounds(95, 251, 172, 24);

				ptemp.add(Custom);
				
				tc1=new JButton("Test Case 1");
				tc1.setBounds(0, 289, 172, 24);
				ptemp.add(tc1);
				tc1.setBackground(my);
				tc1.setForeground(myColor);
				tc1.setFont(new Font("Garamond", Font.BOLD, 20));
				tc2=new JButton("Test Case 2");
				tc2.setBounds(177, 289, 172, 24);
				ptemp.add(tc2);
				tc2.setBackground(my);
				tc2.setForeground(myColor);
				tc2.setFont(new Font("Garamond", Font.BOLD, 20));
				
				
				tc3 = new JButton("Test Case 3");
				tc3.setForeground(Color.WHITE);
				tc3.setFont(new Font("Garamond", Font.BOLD, 20));
				tc3.setBackground(new Color(220, 61, 36));
				tc3.setBounds(0, 318, 172, 24);
				ptemp.add(tc3);
				
				tc4 = new JButton("Test Case 4");
				tc4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				tc4.setForeground(Color.WHITE);
				tc4.setFont(new Font("Garamond", Font.BOLD, 20));
				tc4.setBackground(new Color(220, 61, 36));
				tc4.setBounds(177, 319, 172, 24);
				ptemp.add(tc4);
				
				Custom.addActionListener(this);
				tc2.addActionListener(this);
				tc1.addActionListener(this);
				
				tc3.addActionListener(this);
				tc4.addActionListener(this);
			getContentPane().add(pmaster);
		setLocationRelativeTo(null);
		setResizable(false);			
		setVisible(true);			
	}
	public void actionPerformed(ActionEvent ae)
	{
		name=temp_name.getText().trim();
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
		if(ae.getSource()==Custom)
		{
			Employee_Register.temp_name.setText(name);
			Employee_Register.temp_userid.setText("");
			Employee_Register.temp_joining.setText(date);
			Employee_Register.temp_shift.setSelectedItem(shift);
			Employee_Register.temp_password.setText("");
			Employee_Register.temp_phone.setText(phone);
			Employee_Register.temp_state.setText(state);
			Employee_Register.temp_city.setText(city);
			Employee_Register.temp_street.setText(street);
			Employee_Register.temp_email.setText(email);
			Employee_Register.temp_email.setEnabled(true);
			if(male.isSelected())
				Employee_Register.male.setSelected(true);
			else
				Employee_Register.female.setSelected(true);
		}
		if(ae.getSource()==tc1)
		{
			Employee_Register.temp_name.setText("Aayushi");
			Employee_Register.temp_userid.setText("");
			Employee_Register.temp_joining.setText(date);
			Employee_Register.temp_shift.setSelectedItem("Water Bill");
			Employee_Register.temp_password.setText("");
			Employee_Register.temp_phone.setText("7696882550");
			Employee_Register.temp_state.setText("Haryana");
			Employee_Register.temp_city.setText("Panchkula");
			Employee_Register.temp_street.setText("Sector 21");
			Employee_Register.temp_email.setText("aayushichitkara92@gmail.com");
			Employee_Register.temp_email.setEnabled(true);
			Employee_Register.female.setSelected(true);
		}
		if(ae.getSource()==tc2)
		{
			Employee_Register.temp_name.setText("Aayushi123");
			Employee_Register.temp_userid.setText("");
			Employee_Register.temp_joining.setText(date);
			Employee_Register.temp_shift.setSelectedItem("Water Bill");
			Employee_Register.temp_password.setText("");
			Employee_Register.temp_phone.setText("7696882550");
			Employee_Register.temp_state.setText("Haryana");
			Employee_Register.temp_city.setText("Panchkula");
			Employee_Register.temp_street.setText("Sector 21");
			Employee_Register.temp_email.setText("aayushichitkara92@gmail.com");
			Employee_Register.temp_email.setEnabled(true);
			Employee_Register.female.setSelected(true);
		}
		if(ae.getSource()==tc3)
		{
			Employee_Register.temp_name.setText("Aayushi");
			Employee_Register.temp_userid.setText("");
			Employee_Register.temp_joining.setText(date);
			Employee_Register.temp_shift.setSelectedItem("Water Bill");
			Employee_Register.temp_password.setText("");
			Employee_Register.temp_phone.setText("76968825");
			Employee_Register.temp_state.setText("Haryana");
			Employee_Register.temp_city.setText("Panchkula");
			Employee_Register.temp_street.setText("Sector 21");
			Employee_Register.temp_email.setText("aayushichitkara92@gmail.com");
			Employee_Register.temp_email.setEnabled(true);
			Employee_Register.female.setSelected(true);
		}
		if(ae.getSource()==tc4)
		{
			Employee_Register.temp_name.setText("Aayushi");
			Employee_Register.temp_userid.setText("");
			Employee_Register.temp_joining.setText(date);
			Employee_Register.temp_shift.setSelectedItem("Water Bill");
			Employee_Register.temp_password.setText("");
			Employee_Register.temp_phone.setText("7696882550");
			Employee_Register.temp_state.setText("Haryana");
			Employee_Register.temp_city.setText("Panchkula");
			Employee_Register.temp_street.setText("Sector 21");
			Employee_Register.temp_email.setText("aayushichitkara92");
			Employee_Register.temp_email.setEnabled(true);
			Employee_Register.female.setSelected(true);
		}
	}
}