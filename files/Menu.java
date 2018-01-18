import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class Menu extends JFrame implements ActionListener, MouseListener
{
	JPanel pmenu,pmaster;
	JLabel head;
	String pass,check,given;
	JMenu menu,logout,profile;
	JMenuItem chlaan,water,change,electric,edit;
	JMenuBar mbar;
	JLabel name,e_name,gender,e_gender,id,e_id,join,e_join,work,e_work,state,e_state,city,e_city,street,e_street,tel,e_tel,email,e_email;
	Menu(String t)
	{ 	
		given=t;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Employee Page");
		setSize(1360,700);
		setLocationRelativeTo(null); 
        setResizable(false);
        
		Color my = Color.decode("#DC3D24");
        Color myColor = Color.decode("#FFFFFF");
		
		profile=new JMenu("Profile");
			change=new JMenuItem("Change Password");
			edit = new JMenuItem("Edit Profile");
			profile.add(edit);
			profile.add(change);
		logout = new JMenu("Logout");
		menu = new JMenu("Service");
			chlaan = new JMenuItem("Pay Chlaan");
			water = new JMenuItem("Water Bill");
			electric = new JMenuItem("Electricity Bill");
			menu.add(chlaan);
			menu.add(electric);
			menu.add(water);
		
		mbar = new JMenuBar();
		mbar.add(menu);
		mbar.add(profile);
		mbar.add(logout);
		setJMenuBar(mbar);

		head = new JLabel("Welcome "+given);
			head.setForeground(myColor);
			head.setFont(new Font("Garamond", Font.BOLD, 34));
		name=new JLabel("Name");
			name.setForeground(myColor);
			name.setFont(new Font("Garamond", Font.BOLD, 20));
		gender=new JLabel("Gender");
			gender.setForeground(myColor);
			gender.setFont(new Font("Garamond", Font.BOLD, 20));
		id=new JLabel("User-Id");
			id.setForeground(myColor);
			id.setFont(new Font("Garamond", Font.BOLD, 20));
		join=new JLabel("Joining Date");
			join.setForeground(myColor);
			join.setFont(new Font("Garamond", Font.BOLD, 20));
		work=new JLabel("Work Assigned");
			work.setForeground(myColor);
			work.setFont(new Font("Garamond", Font.BOLD, 20));
		state=new JLabel("State");
			state.setForeground(myColor);
			state.setFont(new Font("Garamond", Font.BOLD, 20));
		city=new JLabel("City");
			city.setForeground(myColor);
			city.setFont(new Font("Garamond", Font.BOLD, 20));
		street=new JLabel("Street");
			street.setForeground(myColor);
			street.setFont(new Font("Garamond", Font.BOLD, 20));
		tel=new JLabel("Phone Number");
			tel.setForeground(myColor);
			tel.setFont(new Font("Garamond", Font.BOLD, 20));
		email=new JLabel("Email-id");
			email.setForeground(myColor);
			email.setFont(new Font("Garamond", Font.BOLD, 20));
			try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:///suvidha","root","");
			Statement st = con.createStatement();
			String query="select * from employee_register where userid='"+t+"'";
			ResultSet rd=st.executeQuery(query);
			if(rd.next()){
				String getName=rd.getString(2);
				String userid=rd.getString(3);
				String em=rd.getString(12);
				String gen=rd.getString(5);
				String tel1=rd.getString(8);
				String ct=rd.getString(10);
				String sr=rd.getString(11);
				String stw=rd.getString(9);
				String jo=rd.getString(6);
				check=rd.getString(7);
				String check1=null;
				if(check.equals("Pay Chlaan")){
					water.setVisible(false);
					electric.setVisible(false);
					check1="Chlaan";
				}
				else if(check.equals("Water Bill")){
					chlaan.setVisible(false);
					electric.setVisible(false);
					check1="Water Bill";
				}
				else if(check.equals("Electricity Bill")){
					water.setVisible(false);
					chlaan.setVisible(false);
					check1="Electricity Bill";
				}
				e_name=new JLabel(getName);
					e_name.setForeground(myColor);
					e_name.setFont(new Font("Garamond", Font.BOLD, 20));
				e_gender=new JLabel(gen);
					e_gender.setForeground(myColor);
					e_gender.setFont(new Font("Garamond", Font.BOLD, 20));
				e_id=new JLabel(userid);
					e_id.setForeground(myColor);
					e_id.setFont(new Font("Garamond", Font.BOLD, 20));
				e_join=new JLabel(jo);
					e_join.setForeground(myColor);
					e_join.setFont(new Font("Garamond", Font.BOLD, 20));
				e_work=new JLabel(check1);
					e_work.setForeground(myColor);
					e_work.setFont(new Font("Garamond", Font.BOLD, 20));	
				e_state=new JLabel(stw);
					e_state.setForeground(myColor);
					e_state.setFont(new Font("Garamond", Font.BOLD, 20));
					
				e_city=new JLabel(ct);
					e_city.setForeground(myColor);
					e_city.setFont(new Font("Garamond", Font.BOLD, 20));
				e_street=new JLabel(sr);
					e_street.setForeground(myColor);
					e_street.setFont(new Font("Garamond", Font.BOLD, 20));
				e_tel=new JLabel(tel1);
					e_tel.setForeground(myColor);
					e_tel.setFont(new Font("Garamond", Font.BOLD, 20));
					
				e_email=new JLabel(em);
					e_email.setForeground(myColor);
					e_email.setFont(new Font("Garamond", Font.BOLD, 20));
			}
		}catch(Exception f){
		System.out.println("Exception in Menu Page Starting :" +f);
		}
		pmenu=new JPanel(new GridLayout(10,2,5,5));
			pmenu.add(id);
			pmenu.add(e_id);
			pmenu.add(name);
			pmenu.add(e_name);
			pmenu.add(gender);
			pmenu.add(e_gender);
			pmenu.add(email);
			pmenu.add(e_email);
			pmenu.add(tel);
			pmenu.add(e_tel);
			pmenu.add(street);
			pmenu.add(e_street);
			pmenu.add(city);
			pmenu.add(e_city);
			pmenu.add(state);
			pmenu.add(e_state);
			pmenu.add(join);
			pmenu.add(e_join);
			pmenu.add(work);
			pmenu.add(e_work);
			
		pmaster = new JPanel(null);
			pmaster.setBackground(my);
			pmaster.add(head);
				head.setBounds(250,5,300,50);
			pmaster.add(pmenu);
				pmenu.setBackground(my);	
				pmenu.setBounds(250,70,400,500);
		add(pmaster);
		water.addActionListener(this);
		change.addActionListener(this);
		chlaan.addActionListener(this);
		electric.addActionListener(this);
		logout.addMouseListener (this);
		edit.addActionListener(this);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			pass=e_name.getText();		
			if(ae.getSource()==water)
			{
				Water obj = new Water(given);
			}
			
			if(ae.getSource()==electric)
			{
				Electricity obj = new Electricity(given);
			}
			if(ae.getSource()==change)
			{
				Change_Pwd obj = new Change_Pwd(given);
			}
			
			if(ae.getSource()==chlaan)
			{
				Chlaan obj = new Chlaan(given);
			}
			if(ae.getSource()==edit){
				Edit_MyProfile obj=new Edit_MyProfile(pass,given);
			}
		}
		catch(Exception e){
			System.out.println("Exception in Menu: " +e);
		}
	
	}
	public void mouseExited(MouseEvent me){}
	public void mouseEntered(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseClicked(MouseEvent me)
	{
		if(me.getSource() == logout)
		{
			Login o=new Login();
			setVisible(false);
		}
	}
}