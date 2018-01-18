import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.*;
import java.util.regex.*;

class Edit_info extends JFrame implements ActionListener{
	JLabel head,lgender,joining,emp_join,emp_name,username,work,name,emp_street,emp_city,emp_state,emp_num,emp_email,gender,phone_number,street,city,state,email;
	JButton update,reset;
	JTextField uname;
	String u_name,type;
	JComboBox emp_work;
	JPanel ptemp,pmaster;
	
	Edit_info(){
		setTitle("Admin Page");
		setSize(680, 500);
        setLocationRelativeTo(null); 
        setResizable(false);
        
		Color my = Color.decode("#DC3D24");
        Color myColor = Color.decode("#FFFFFF");

		head=new JLabel("Update Employee Work");
			head.setForeground(myColor);
			head.setFont(new Font("Garamond", Font.BOLD, 34));
		username=new JLabel("Employee");
			username.setForeground(myColor);
			username.setFont(new Font("Garamond", Font.BOLD, 20));	
		uname=new JTextField(10);
			uname.setBackground(my);
			uname.setForeground(myColor);
		name=new JLabel("Employee name");
			name.setForeground(myColor);
			name.setFont(new Font("Garamond", Font.BOLD, 20));	
		emp_name=new JLabel("");
			emp_name.setForeground(myColor);
			emp_name.setFont(new Font("Garamond", Font.BOLD, 20));	
		update=new JButton("Update Info");
		reset=new JButton("Reset");
		
		gender=new JLabel("Gender");
			gender.setForeground(myColor);
			gender.setFont(new Font("Garamond", Font.BOLD, 20));	
		lgender=new JLabel("");
			lgender.setForeground(myColor);
			lgender.setFont(new Font("Garamond", Font.BOLD, 20));	
		phone_number=new JLabel("Phone Number");
			phone_number.setForeground(myColor);
			phone_number.setFont(new Font("Garamond", Font.BOLD, 20));	
		emp_num=new JLabel("");
			emp_num.setForeground(myColor);
			emp_num.setFont(new Font("Garamond", Font.BOLD, 20));	
		street=new JLabel("Street");
			street.setForeground(myColor);
			street.setFont(new Font("Garamond", Font.BOLD, 20));	
		emp_street=new JLabel("");
			emp_street.setForeground(myColor);
			emp_street.setFont(new Font("Garamond", Font.BOLD, 20));	
		city=new JLabel("City");
			city.setForeground(myColor);
			city.setFont(new Font("Garamond", Font.BOLD, 20));	
		emp_city=new JLabel("");
			emp_city.setForeground(myColor);
			emp_city.setFont(new Font("Garamond", Font.BOLD, 20));	
		state=new JLabel("State");
			state.setForeground(myColor);
			state.setFont(new Font("Garamond", Font.BOLD, 20));	
		emp_state=new JLabel("");
			emp_state.setForeground(myColor);
			emp_state.setFont(new Font("Garamond", Font.BOLD, 20));	
		email=new JLabel("Email-id");
			email.setForeground(myColor);
			email.setFont(new Font("Garamond", Font.BOLD, 20));	
		emp_email=new JLabel("");
			emp_email.setForeground(myColor);
			emp_email.setFont(new Font("Garamond", Font.BOLD, 20));	
		joining=new JLabel("Date Of Joinig");
			joining.setForeground(myColor);
			joining.setFont(new Font("Garamond", Font.BOLD, 20));	
		emp_join=new JLabel("");
			emp_join.setForeground(myColor);
			emp_join.setFont(new Font("Garamond", Font.BOLD, 20));	
		work=new JLabel("Work Type");
			work.setForeground(myColor);
			work.setFont(new Font("Garamond", Font.BOLD, 20));	
		emp_work=new JComboBox();
			emp_work.setBackground(my);
			emp_work.setForeground(myColor);
			emp_work.setFont(new Font("Garamond", Font.BOLD, 20));	
			emp_work.addItem("--Select Work--");
			emp_work.addItem("Water Bill");
			emp_work.addItem("Electricity Bill");
			emp_work.addItem("Pay Chlaan");
		uname.addKeyListener(new KeyAdapter() 
		{
			public void keyPressed(KeyEvent e) 
			{
				int keyCode = e.getKeyCode();
				String test=uname.getText().trim();
				if (e.getKeyCode() == 10) 
				{
					if(test.equals("")){
						JOptionPane.showMessageDialog(pmaster,"Useraname is Required");	
					}
					else{
						try{
							Class.forName("com.mysql.jdbc.Driver");
							Connection con = DriverManager.getConnection("jdbc:mysql:///suvidha","root","");
							Statement st = con.createStatement();
							String q="select * from employee_register where userid='"+test+"'";
							ResultSet rs=st.executeQuery(q);
							if(rs.next()){
								emp_name.setText(rs.getString(2));
								emp_work.setSelectedItem(rs.getString(7));
								emp_street.setText(rs.getString(11));
								emp_city.setText(rs.getString(10));
								emp_state.setText(rs.getString(9));
								emp_num.setText(rs.getString(8));
								emp_email.setText(rs.getString(12));
								emp_join.setText(rs.getString(6));
								lgender.setText(rs.getString(5));
							}
							else{
								JOptionPane.showMessageDialog(pmaster,"Employee-Id is incorrect");
							}
						}
						catch(Exception e1){
							System.out.println("Exception : "+e1);
						}
					}
				}
				
			}
		});
		reset.addActionListener(this);
		update.addActionListener(this);
		
		update.setBackground(my);
		update.setForeground(myColor);
		update.setFont(new Font("Garamond", Font.BOLD, 20));

		reset.setBackground(my);
		reset.setForeground(myColor);
		reset.setFont(new Font("Garamond", Font.BOLD, 20));

		ptemp=new JPanel(new GridLayout(12,2,5,5));
			ptemp.setBackground(my);
			
			ptemp.add(username);
			ptemp.add(uname);
			ptemp.add(name);
			ptemp.add(emp_name);
			ptemp.add(gender);
			ptemp.add(lgender);
			ptemp.add(phone_number);
			ptemp.add(emp_num);
			ptemp.add(street);
			ptemp.add(emp_street);
			ptemp.add(city);
			ptemp.add(emp_city);
			ptemp.add(state);
			ptemp.add(emp_state);
			ptemp.add(email);
			ptemp.add(emp_email);
			ptemp.add(joining);
			ptemp.add(emp_join);
			ptemp.add(work);
			ptemp.add(emp_work);
			ptemp.add(update);
			ptemp.add(reset);
		pmaster=new JPanel(null);
			pmaster.setBackground(my);
			pmaster.add(head);
				head.setBounds(180,10,400,100);
				
			pmaster.add(ptemp);
				ptemp.setBounds(170,100,350,350);
		add(pmaster);
		setLocationRelativeTo(null);
		setResizable(false);

		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==reset)
		{
			uname.setText("");
			emp_name.setText("");
			emp_street.setText("");
			emp_city.setText("");
			emp_state.setText("");
			emp_num.setText("");
			emp_email.setText("");
			emp_join.setText("");
			lgender.setText("");
			emp_work.setSelectedItem("--Select Work--");
		}
		
		if(ae.getSource()==update){
			u_name=uname.getText().trim();
			type=(String)emp_work.getSelectedItem();
			String valid=emp_name.getText().trim();

			if(u_name.equals("")){
				JOptionPane.showMessageDialog(pmaster,"Enter Username of the Employee");
			}
			else if(type.equals("--Select Work--")){
				JOptionPane.showMessageDialog(pmaster,"Select Particular Work for the Employee");			
			}
			else if(valid.equals("")){
				JOptionPane.showMessageDialog(pmaster,"Please press enter to check the username is valid or not");
				uname.setFocusable(true);
			}else
			{
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql:///suvidha","root","");
					Statement st = con.createStatement();
					String q="update employee_register set shift='"+type+"' where userid='"+u_name+"'";
					int i = st.executeUpdate(q);
					if(i>0){
						JOptionPane.showMessageDialog(pmaster,"Updated Successfully");
						
						setVisible(false);
					}
					else{
							JOptionPane.showMessageDialog(pmaster,"Useranme is not f");
					}
				}
				catch(Exception a){
					System.out.println("Exception : "+a);
				}
			}
		}
	}
}