import javax.swing.*;
import java.sql.*;
import java.awt.*;

class Employee_list extends JFrame{

	int count=1;
	JPanel ptemp,pmaster;
	JLabel head,sr,userid,name,f;
		
	Employee_list(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:///suvidha","root","");
			Statement st = con.createStatement();
			String query="select * from employee_register";
			ResultSet rs=st.executeQuery(query);
			while(rs.next()){
			count++;
			}
		}
		catch(Exception e1){
			System.out.println("Exception : "+e1);
		}
		setTitle("Admin Page");
		setSize(680, 500);
        setLocationRelativeTo(null); 
        setResizable(false);
        Color my = Color.decode("#DC3D24");
        Color myColor = Color.decode("#FFFFFF");
		
		head=new JLabel("Employee List");
			head.setForeground(myColor);
			head.setFont(new Font("Garamond", Font.BOLD, 34));	
		
		sr=new JLabel("SNo.");
			sr.setForeground(myColor);
			sr.setFont(new Font("Garamond", Font.BOLD, 20));	
		
		userid=new JLabel("Username");
			userid.setForeground(myColor);
			userid.setFont(new Font("Garamond", Font.BOLD, 20));	
		name=new JLabel("Employee Name");
			name.setForeground(myColor);
			name.setFont(new Font("Garamond", Font.BOLD, 20));	
		
		ptemp=new JPanel(new GridLayout(count,3,5,3));		
			ptemp.add(sr);
			ptemp.add(userid);
			ptemp.add(name);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:///suvidha","root","");
			Statement st = con.createStatement();
			String query="select * from employee_register";
			ResultSet rs=st.executeQuery(query);
			int iu=1;
				while(rs.next()){
					String o = String.valueOf(iu);
					ptemp.add(new JLabel(o));
					ptemp.add(new JLabel(rs.getString(3)));
					ptemp.add(new JLabel(rs.getString(2)));
					iu++;
				}
		}
		catch(Exception e1){
			System.out.println("Exception : "+e1);
		}
	
		pmaster = new JPanel(null);
			ptemp.setBackground(my);
			pmaster.setBackground(my);
			pmaster.add(head);
				head.setBounds(180,10,400,100);
			
			pmaster.add(ptemp);
				ptemp.setBounds(170,100,350,200);
			
		add(pmaster);
		setLocationRelativeTo(null);
		setResizable(false);

		setVisible(true);
	}
}