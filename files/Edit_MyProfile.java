import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.util.regex.*;

class Edit_MyProfile extends JFrame implements ActionListener{
	JPanel ptemp,pmaster;
	JButton submit,reset;
	String userid,name,phone,state,city,street,email;
	JLabel temp_name,temp_userid,emp_name,emp_userid,emp_phone,emp_gender,emp_email,emp_street,emp_city,emp_state,head;
	JTextField temp_phone,temp_email,temp_street,temp_city,temp_state;

	Edit_MyProfile(String pass,String id){
		name=pass;
		userid=id;
		setTitle("Profile");
		setSize(680, 500);
        setLocationRelativeTo(null); 
        setResizable(false);
        
		Color my = Color.decode("#DC3D24");
        Color myColor = Color.decode("#FFFFFF");

		head=new JLabel("Edit My Profile");
			head.setForeground(myColor);
			head.setFont(new Font("Garamond", Font.BOLD, 34));	
		
		temp_name=new JLabel("Name");
			temp_name.setForeground(myColor);
			temp_name.setFont(new Font("Garamond", Font.BOLD, 20));	
		temp_userid=new JLabel("User-Id");
			temp_userid.setForeground(myColor);
			temp_userid.setFont(new Font("Garamond", Font.BOLD, 20));	
		emp_name=new JLabel(pass);
			emp_name.setForeground(myColor);
			emp_name.setFont(new Font("Garamond", Font.BOLD, 20));	
		emp_userid=new JLabel(id);
			emp_userid.setForeground(myColor);
			emp_userid.setFont(new Font("Garamond", Font.BOLD, 20));	
		emp_phone=new JLabel("Phone");
			emp_phone.setForeground(myColor);
			emp_phone.setFont(new Font("Garamond", Font.BOLD, 20));	
		emp_gender=new JLabel("Gender");
			emp_gender.setForeground(myColor);
			emp_gender.setFont(new Font("Garamond", Font.BOLD, 20));	
		emp_email=new JLabel("Email-Id");
			emp_email.setForeground(myColor);
			emp_email.setFont(new Font("Garamond", Font.BOLD, 20));	
		emp_street=new JLabel("Street");
			emp_street.setForeground(myColor);
			emp_street.setFont(new Font("Garamond", Font.BOLD, 20));	
		emp_city=new JLabel("City");
			emp_city.setForeground(myColor);
			emp_city.setFont(new Font("Garamond", Font.BOLD, 20));	
		emp_state=new JLabel("State");
			emp_state.setForeground(myColor);
			emp_state.setFont(new Font("Garamond", Font.BOLD, 20));	
		
		temp_phone=new JTextField(10);
			temp_phone.setBackground(my);
			temp_phone.setForeground(myColor);
		temp_email=new JTextField(10);
			temp_email.setBackground(my);
			temp_email.setForeground(myColor);
		temp_street=new JTextField(10);
			temp_street.setBackground(my);
			temp_street.setForeground(myColor);
		temp_city=new JTextField(10);
			temp_city.setBackground(my);
			temp_city.setForeground(myColor);
		temp_state=new JTextField(10);
			temp_state.setBackground(my);
			temp_state.setForeground(myColor);
		
		submit=new JButton("Submit");
			submit.addActionListener(this);
		reset=new JButton("Reset");
			reset.addActionListener(this);
		submit.setBackground(my);
		submit.setForeground(myColor);
		submit.setFont(new Font("Garamond", Font.BOLD, 20));

		reset.setBackground(my);
		reset.setForeground(myColor);
		reset.setFont(new Font("Garamond", Font.BOLD, 20));

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///suvidha","root","");
			Statement st=con.createStatement();
			String q="Select * from employee_register where name='"+name+"' and userid='"+userid+"'";
			ResultSet rd=st.executeQuery(q);
			if(rd.next()){
				phone=rd.getString(8);
				state=rd.getString(9);
				city=rd.getString(10);
				street=rd.getString(11);
				email=rd.getString(12);
			}
		}catch(Exception e){
			System.out.println("Exception in Edit Profile Training :"+e);
		}
		temp_phone.setText(phone);
		temp_email.setText(state);
		temp_street.setText(street);
		temp_city.setText(city);
		temp_state.setText(state);
		
		ptemp=new JPanel(new GridLayout(8,2,5,5));
			ptemp.add(temp_name);
			ptemp.add(emp_name);
			
			ptemp.add(temp_userid);
			ptemp.add(emp_userid);
			
			ptemp.add(emp_phone);
			ptemp.add(temp_phone);
			
			ptemp.add(emp_email);
			ptemp.add(temp_email);
			
			ptemp.add(emp_street);
			ptemp.add(temp_street);
			
			ptemp.add(emp_city);
			ptemp.add(temp_city);
			
			ptemp.add(emp_state);
			ptemp.add(temp_state);
			
			ptemp.add(submit);
			ptemp.add(reset);
		pmaster=new JPanel(null);
			pmaster.setBackground(my);
			ptemp.setBackground(my);
			pmaster.add(head);
				head.setBounds(180,10,400,100);
			
			pmaster.add(ptemp);
				ptemp.setBounds(170,100,350,250);
		add(pmaster);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);			

	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==submit){
			String ph=temp_phone.getText().trim();
			String stat=temp_state.getText().trim();
			String str=temp_street.getText().trim();
			String ct=temp_city.getText().trim();
			String ema=temp_email.getText().trim();
			if(ph.equals("")){
				JOptionPane.showMessageDialog(pmaster,"Phone Number is required");
			}
			else if(stat.equals("")){
				JOptionPane.showMessageDialog(pmaster,"State Name is required");
			}
			else if(str.equals("")){
				JOptionPane.showMessageDialog(pmaster,"Street Name is required");
			}
			else if(ct.equals("")){
				JOptionPane.showMessageDialog(pmaster,"City Name is required");
			}
			else if(ema.equals("")){
				JOptionPane.showMessageDialog(pmaster,"Email-Id is required");
			}
			else{
				try{
					
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("1");
					Connection con=DriverManager.getConnection("jdbc:mysql:///suvidha","root","");
					System.out.println("2");
					Statement st=con.createStatement();
					System.out.println("3");
					String f="Update employee_register set phone='"+ph+"', state='"+stat+"', street='"+str+"', city='"+ct+"', email='"+ema+"' where userid='"+userid+"' and name='"+name+"'";
					System.out.println(f);
					int m=st.executeUpdate(f);
					System.out.println("5");
					if(m>0){
						System.out.println("6");
						JOptionPane.showMessageDialog(pmaster,"Data Updated");
						setVisible(false);
					}
				}catch(Exception e1){
					System.out.println("Exception in Edit Profile :"+e1);
				}
			}	
		}
		if(ae.getSource()==reset){
			temp_phone.setText(phone);
			temp_email.setText(state);
			temp_street.setText(street);
			temp_city.setText(city);
			temp_state.setText(state);
		}
	}
}