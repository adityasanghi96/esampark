import java.util.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

class Admin_Main extends JFrame implements ActionListener,MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2669355366717914446L;
	JMenuBar mbar;
	JMenu menuoperations,menuprofile,menulogout;
	JMenuItem itemedit,itemregister,itemdelete,itemlist,itemchangepwd;	
	JPanel emptyPanel,masterPanel;
	private JTable table;
	private JLabel lblWelcome;
	private JTextPane txtpnEsamparkIsInitiated;
	private JTextPane txtpnAndGiveThe;
	
	Admin_Main()
	{
		setTitle("Admin Page");
		setSize(1360,700);
		setLocationRelativeTo(null); 
        setResizable(false);
        
		Color my = Color.decode("#DC3D24");
        Color myColor = Color.decode("#FFFFFF");
		
		JPanel masterPanel=new JPanel();
		FlowLayout flowLayout = (FlowLayout) masterPanel.getLayout();
		flowLayout.setVgap(25);
			masterPanel.setBackground(my);
		
		menuoperations=new JMenu("Operations");
		menuprofile=new JMenu("Profile");
		menulogout=new JMenu("Logout");
			menulogout.addMouseListener (this);
		itemedit=new JMenuItem("Edit Employee");
			itemedit.addActionListener(this);
		itemregister=new JMenuItem("Register Employee");
				itemregister.addActionListener(this);
		itemdelete=new JMenuItem("Delete Employee");
			itemdelete.addActionListener(this);
		itemlist=new JMenuItem("List of Employees");
			itemlist.addActionListener(this);
		itemchangepwd=new JMenuItem("Change Password");
			itemchangepwd.addActionListener(this);
		
		menuoperations.add(itemedit);
		menuoperations.add(itemregister);
		menuoperations.add(itemdelete);
		menuoperations.add(itemlist);
		
		
		menuprofile.add(itemchangepwd);
		mbar=new JMenuBar();
		mbar.add(menuoperations);
		mbar.add(menuprofile);
		mbar.add(menulogout);
	
		setJMenuBar(mbar);
		getContentPane().add(masterPanel);
		
		lblWelcome = new JLabel("Welcome Admin");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 95));
		lblWelcome.setBounds(480,92,350,97);
		masterPanel.add(lblWelcome);
		
		txtpnEsamparkIsInitiated = new JTextPane();
		txtpnEsamparkIsInitiated.setForeground(Color.WHITE);
		txtpnEsamparkIsInitiated.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtpnEsamparkIsInitiated.setBackground(new Color(220, 61, 36));
		txtpnEsamparkIsInitiated.setText("E-Sampark is initiated to bring together the services of all the departments under a single umbrella ");
		masterPanel.add(txtpnEsamparkIsInitiated);
		
		txtpnAndGiveThe = new JTextPane();
		txtpnAndGiveThe.setForeground(Color.WHITE);
		txtpnAndGiveThe.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtpnAndGiveThe.setBackground(new Color(220, 61, 36));
		txtpnAndGiveThe.setText("and give the citizens a \u2018multi-service\u2019, \u2018single-window\u2019 experience.");
		masterPanel.add(txtpnAndGiveThe);
		
		table = new JTable();
		masterPanel.add(table);
		
		setVisible(true);
		
		}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==itemchangepwd)
		{
			Admin_pwd ob=new Admin_pwd();
		}
		if(ae.getSource()==itemregister)
		{
			Employee_Register ob1=new Employee_Register();
		}
		if(ae.getSource()==itemlist)
		{
			Employee_list ob2=new Employee_list();
		}
		if(ae.getSource()==itemedit)
		{
			Edit_info in=new Edit_info();
		}
		if(ae.getSource()==itemdelete)
		{
			Delete_Employee dl=new Delete_Employee();
		}
	}
	public void mouseExited(MouseEvent me){}
	public void mouseEntered(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseClicked(MouseEvent me)
	{
		if(me.getSource() == menulogout)
		{
			Login o=new Login();
			setVisible(false);
		}
	}
	
}