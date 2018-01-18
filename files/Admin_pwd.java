import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

class Admin_pwd extends JFrame implements ActionListener{

	JPanel ptemp,pmaster;
	JButton change,reset;
	JPasswordField old_pwd,new_pwd,confirm_pwd;
	JLabel head,old,newp,confirm;	
	String check_old,check_new,check_con;
	
	Admin_pwd(){
		setTitle("Admin Page");
		setSize(680, 500);
        setLocationRelativeTo(null); 
        setResizable(false);
        
		Color my = Color.decode("#DC3D24");
        Color myColor = Color.decode("#FFFFFF");

		head=new JLabel("Update Password");
			head.setForeground(myColor);
			head.setFont(new Font("Garamond", Font.BOLD, 34));	
		
		old=new JLabel("Old Password");
			old.setForeground(myColor);
			old.setFont(new Font("Garamond", Font.BOLD, 20));	
		newp=new JLabel("New Password");
			newp.setForeground(myColor);
			newp.setFont(new Font("Garamond", Font.BOLD, 20));	
		confirm=new JLabel("Confirm Password");
			confirm.setForeground(myColor);
			confirm.setFont(new Font("Garamond", Font.BOLD, 20));	
		
		old_pwd=new JPasswordField(10);
			old_pwd.setBackground(my);
			old_pwd.setForeground(myColor);
		new_pwd=new JPasswordField(10);
			new_pwd.setBackground(my);
			new_pwd.setForeground(myColor);
		confirm_pwd=new JPasswordField(10);
			confirm_pwd.setBackground(my);
			confirm_pwd.setForeground(myColor);
		change=new JButton("Change Password");
		reset=new JButton("Reset");
		
		change.setBackground(my);
		change.setForeground(myColor);
		change.setFont(new Font("Garamond", Font.BOLD, 20));

		reset.setBackground(my);
		reset.setForeground(myColor);
		reset.setFont(new Font("Garamond", Font.BOLD, 20));

		change.addActionListener(this);
		reset.addActionListener(this);
		
		ptemp=new JPanel(new GridLayout(4,2,5,5));
			ptemp.setBackground(my);
			ptemp.add(old);
			ptemp.add(old_pwd);
			ptemp.add(newp);
			ptemp.add(new_pwd);
			ptemp.add(confirm);
			ptemp.add(confirm_pwd);
			ptemp.add(change);
			ptemp.add(reset);
		pmaster=new JPanel(null);
			pmaster.setBackground(my);
			pmaster.add(head);
				head.setBounds(180,10,400,100);
			
			pmaster.add(ptemp);
				ptemp.setBounds(170,100,350,150);
			add(pmaster);
		setLocationRelativeTo(null);
		setResizable(false);			
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==reset){
			old_pwd.setText("");
			new_pwd.setText("");
			confirm_pwd.setText("");
		}
		if(ae.getSource()==change){
			check_old=old_pwd.getText().trim();
			check_new=new_pwd.getText().trim();
			check_con=confirm_pwd.getText().trim();
			if(check_old.equals("")){
				JOptionPane.showMessageDialog(pmaster,"Field is required");
			}
			else if(check_new.equals("")){
				JOptionPane.showMessageDialog(pmaster,"Field is required");
			}
			else if(check_con.equals("")){
				JOptionPane.showMessageDialog(pmaster,"Field is required");
			}
			else{
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql:///suvidha","root","");
					Statement st = con.createStatement();
					String x ="Select * from admin where username='admin' and password='"+check_old+"'";
					ResultSet rd=st.executeQuery(x);
					if(rd.next()){
						if(check_new.equals(check_con)){
							String query2 = "update admin set password='"+check_new+"' where username='admin'";
							int i = st.executeUpdate(query2);
							if (i > 0) {
								JOptionPane.showMessageDialog(pmaster,"Password Updated");
							
							}
						}
						else{
								JOptionPane.showMessageDialog(pmaster,"Password didnot match");
								new_pwd.setText("");
								confirm_pwd.setText("");
						}						 
					}
					else{
						JOptionPane.showMessageDialog(pmaster,"Old Password didnot match");
						new_pwd.setText("");
						confirm_pwd.setText("");
						old_pwd.setText("");
					}
				}
				catch(Exception e){
					System.out.println("Exception : "+e);
				}
			}
		}
	}
}