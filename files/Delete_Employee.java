import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.*;
import java.util.regex.*;

class Delete_Employee extends JFrame implements ActionListener
{
	JPanel ptemp,pmaster;
	JLabel username,emp_name,head;
	JTextField id,name;
	JButton delete,reset;
	String temp_name,userid;
	
	Delete_Employee()
	{
		setTitle("Admin Page");
		setSize(680, 500);
        setLocationRelativeTo(null); 
        setResizable(false);
        
		Color my = Color.decode("#DC3D24");
        Color myColor = Color.decode("#FFFFFF");
		
		username=new JLabel("Username");
			username.setForeground(myColor);
			username.setFont(new Font("Garamond", Font.BOLD, 20));
		emp_name=new JLabel("Name");
			emp_name.setForeground(myColor);
			emp_name.setFont(new Font("Garamond", Font.BOLD, 20));
			
		id=new JTextField(10);
			id.setBackground(my);
			id.setForeground(myColor);
		name=new JTextField(10);
			name.setBackground(my);
			name.setForeground(myColor);
			name.setEnabled(false);
		
		delete=new JButton("Delete");
			delete.setBackground(my);
			delete.setForeground(myColor);
			delete.setFont(new Font("Garamond", Font.BOLD, 20));
			
		reset=new JButton("Reset");
			reset.setBackground(my);
			reset.setForeground(myColor);
			reset.setFont(new Font("Garamond", Font.BOLD, 20));
			
		head=new JLabel("Delete Employee");
			head.setForeground(myColor);
			head.setFont(new Font("Garamond", Font.BOLD, 34));
		
		delete.addActionListener(this);
		reset.addActionListener(this);
		
		id.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e){
				int keyCode = e.getKeyCode();
				String test=id.getText().trim();
				if (e.getKeyCode() == 10){
					if(test.equals("")){
						JOptionPane.showMessageDialog(pmaster,"Username is required");
					}
					else{
					try{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql:///suvidha","root","");
						Statement st = con.createStatement();
						String query="select * from employee_register where userid='"+test+"'";
						ResultSet rs=st.executeQuery(query);
						if(rs.next()){
							String name_emp=rs.getString(2);
							name.setText(name_emp);
						}
						else{
							JOptionPane.showMessageDialog(pmaster,"Employee Not FOUND..!!!");
							id.setText("");
						}
					}
					catch(Exception e1){
					System.out.println("Exception : "+e1);
					}
					}
				}
			}
		});	
		ptemp=new JPanel(new GridLayout(3,2,5,5));
			ptemp.setBackground(my);
			ptemp.add(username);
			ptemp.add(id);
			ptemp.add(emp_name);
			ptemp.add(name);
			ptemp.add(delete);
			ptemp.add(reset);
			
		pmaster=new JPanel(null);
			pmaster.setBackground(my);
			pmaster.add(head);
				head.setBounds(180,10,400,100);
			pmaster.add(ptemp);
				ptemp.setBounds(170,100,250,100);
			add(pmaster);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);	
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==reset){
			id.setText("");
			name.setText("");
		}
		if(ae.getSource()==delete){
			temp_name=name.getText().trim();
			userid=id.getText().trim();
			if(userid.equals("")){
				JOptionPane.showMessageDialog(pmaster,"Enter the User-Name of the Employee");
			}
			else if(temp_name.equals("")){
			JOptionPane.showMessageDialog(pmaster,"Please Work Properly");
			}
			else{
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql:///suvidha","root","");
					Statement st = con.createStatement();
					String q="delete from employee_register where userid='"+userid+"' and name='"+temp_name+"'";
					int i=st.executeUpdate(q);
					if(i>0){
						JOptionPane.showMessageDialog(pmaster,"Employee Deleted");
						setVisible(false);
					}
				}
				catch(Exception e){
					System.out.println("Exception : "+e);
				}
			}
		}

	}
}