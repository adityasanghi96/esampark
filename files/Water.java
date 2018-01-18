import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;  
import java.util.Date; 
class Water extends JFrame implements ActionListener,ItemListener
{
	JPanel pmenu,pmaster;
	JLabel meterno,unitc,bill,billclear,method,head,cardno,appr,bank;
	JTextField t_meterno,t_unitc,t_bill,t_billclear,tcardno,tappr,tbank;
	JComboBox t_method;
	JButton submit,reset;
	String meter,bal1,taken,unit1,billt1,billc1;
	int unit,billt,billc,bal;
	
	Water(String t)
	{
		taken=t;
		setTitle("Water Bill");
		setSize(680, 500);
        setLocationRelativeTo(null); 
        setResizable(false);
        
		Color my = Color.decode("#DC3D24");
        Color myColor = Color.decode("#FFFFFF");
		head=new JLabel("Water Bill");
			head.setForeground(myColor);
			head.setFont(new Font("Garamond", Font.BOLD, 34));	
		
		meterno=new JLabel("Meter Number");
			meterno.setForeground(myColor);
			meterno.setFont(new Font("Garamond", Font.BOLD, 20));	
		unitc=new JLabel("Unit Consumed");
			unitc.setForeground(myColor);
			unitc.setFont(new Font("Garamond", Font.BOLD, 20));	
		bill=new JLabel("Ammount Payable");
			bill.setForeground(myColor);
			bill.setFont(new Font("Garamond", Font.BOLD, 20));	
		billclear=new JLabel("Amount to be paid");
			billclear.setForeground(myColor);
			billclear.setFont(new Font("Garamond", Font.BOLD, 20));	
		method=new JLabel("Payment Type");
			method.setForeground(myColor);
			method.setFont(new Font("Garamond", Font.BOLD, 20));	
		submit=new JButton("Pay Bill");
		reset=new JButton("Reset");
		submit.setBackground(my);
		submit.setForeground(myColor);
		submit.setFont(new Font("Garamond", Font.BOLD, 20));

		reset.setBackground(my);
		reset.setForeground(myColor);
		reset.setFont(new Font("Garamond", Font.BOLD, 20));
		
		bank=new JLabel("Bank Name");
			bank.setForeground(myColor);
			bank.setFont(new Font("Garamond", Font.BOLD, 20));	
		cardno=new JLabel("Card Number");
			cardno.setForeground(myColor);
			cardno.setFont(new Font("Garamond", Font.BOLD, 20));	
		appr=new JLabel("Approval Code");
			appr.setForeground(myColor);
			appr.setFont(new Font("Garamond", Font.BOLD, 20));	
		
		tcardno=new JTextField(10);
			tcardno.setBackground(my);
			tcardno.setForeground(myColor);
		tappr=new JTextField(10);
			tappr.setBackground(my);
			tappr.setForeground(myColor);
		tbank=new JTextField(10);
			tbank.setBackground(my);
			tbank.setForeground(myColor);
		t_meterno=new JTextField(10);
			t_meterno.setBackground(my);
			t_meterno.setForeground(myColor);
		t_unitc=new JTextField(10);
			t_unitc.setBackground(my);
			t_unitc.setForeground(myColor);
			t_unitc.setEnabled(false);
		t_bill=new JTextField(10);
			t_bill.setBackground(my);
			t_bill.setForeground(myColor);
			t_bill.setEnabled(false);
		t_billclear=new JTextField(10);
			t_billclear.setBackground(my);
			t_billclear.setForeground(myColor);
		t_method=new JComboBox();
			t_method.setBackground(my);
			t_method.setForeground(myColor);
			t_method.addItem("==Select Payment Type==");
			t_method.addItem("Cash");
			t_method.addItem("Credit/Debit Card");
			t_method.setEnabled(false);
			
			bank.setVisible(false);
			cardno.setVisible(false);
			appr.setVisible(false);
			tcardno.setVisible(false);
			tappr.setVisible(false);
			tbank.setVisible(false);
		t_method.addItemListener(this);
		
			t_meterno.addKeyListener(new KeyAdapter() 
			{
				public void keyPressed(KeyEvent e) 
				{
					int keyCode = e.getKeyCode();
					meter=t_meterno.getText().trim();
					
					if(e.getKeyCode() == 10) 
					{
						if(meter.equals(""))
						{
							JOptionPane.showMessageDialog(pmaster,"Enter the Meter Number");
						}
						else
						{
							t_meterno.setEnabled(false);
							try{
								Class.forName("com.mysql.jdbc.Driver");
								Connection con = DriverManager.getConnection("jdbc:mysql:///suvidha","root","");
								Statement st = con.createStatement();
								String x = "Select * from water_bill where meter_no='"+meter+"' ";
								ResultSet rd=st.executeQuery(x);
								if(rd.next()){
									unit1=rd.getString(3);
									unit=Integer.parseInt(unit1);
									billt1=rd.getString(4);
									billt=Integer.parseInt(billt1);							
									t_unitc.setText(unit1);
										t_bill.setText(billt1);
									t_method.setEnabled(true);
								}else{
									JOptionPane.showMessageDialog(pmaster,"Meter Number is not Registered");
									t_meterno.setEnabled(true);
								}
							}
							catch(Exception e1)
							{
								System.out.println("Exception in enter: " +e1);
							}
						}
					}
				}
			});	
			pmenu=new JPanel(new GridLayout(9,2,5,5));
			
			pmenu.add(meterno);
			pmenu.add(t_meterno);
			
			pmenu.add(unitc);
			pmenu.add(t_unitc);
						
			pmenu.add(bill);
			pmenu.add(t_bill);
			
			pmenu.add(billclear);
			pmenu.add(t_billclear);
			
			pmenu.add(method);
			pmenu.add(t_method);
			
			pmenu.add(bank);
			pmenu.add(tbank);
			
			pmenu.add(cardno);
			pmenu.add(tcardno);
			
			pmenu.add(appr);
			pmenu.add(tappr);
							
			pmenu.add(submit);
			pmenu.add(reset);
		pmaster=new JPanel(null);
			pmaster.setBackground(my);
			pmenu.setBackground(my);
			pmaster.add(head);
				head.setBounds(180,10,400,100);
			
			pmaster.add(pmenu);
				pmenu.setBounds(170,100,350,250);
		add(pmaster);
		
		reset.addActionListener(this);
		submit.addActionListener(this);
		setLocationRelativeTo(null);
		setResizable(false);		
		setVisible(true);
		
	}
	public void itemStateChanged(ItemEvent event) {
       if (event.getStateChange() == ItemEvent.SELECTED) {
        int i=t_method.getSelectedIndex();
		tbank.setText("");
		tappr.setText("");
		tcardno.setText("");
			
		if(i==2){
			bank.setVisible(true);
			cardno.setVisible(true);
			appr.setVisible(true);
			tcardno.setVisible(true);
			tappr.setVisible(true);
			tbank.setVisible(true);
			
		}else{
			
			bank.setVisible(false);
			cardno.setVisible(false);
			appr.setVisible(false);
			tcardno.setVisible(false);
			tappr.setVisible(false);
			tbank.setVisible(false);
		}
	   }
    }  
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==reset)
		{
			bank.setVisible(false);
			cardno.setVisible(false);
			appr.setVisible(false);
			tcardno.setVisible(false);
			tappr.setVisible(false);
			tbank.setVisible(false);
			tbank.setText("");
			tappr.setText("");
			tcardno.setText("");
			
			t_meterno.setText("");
				t_meterno.setEnabled(true);
			t_unitc.setText("");
			
			t_bill.setText("");
			t_billclear.setText("");
				t_billclear.setEnabled(true);
			t_method.setEnabled(false);
			t_method.setSelectedItem("==Select Payment Type==");
			t_billclear.setEnabled(false);
		}
		if(ae.getSource()==submit)
		{
			Date date = new Date();  
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		String strDate= formatter.format(date);
			String meter1=t_meterno.getText().trim();
			String billc2=t_billclear.getText().trim();
			String billc3=t_bill.getText().trim();
			String typ=(String)t_method.getSelectedItem();
			String sappr=tappr.getText().trim();
			String sbank=tbank.getText().trim();
			String snum=tcardno.getText().trim();
			
			if(meter1.equals("")){
				JOptionPane.showMessageDialog(pmaster,"Enter Meter Number");
			}else if(billc2.equals("")){
				JOptionPane.showMessageDialog(pmaster,"Enter Amount to be Paid");
			}else if(typ.equals("==Select Payment Type==")){
				JOptionPane.showMessageDialog(pmaster,"Select Payment Type");
			}
			
			else
			{
				int ei=t_method.getSelectedIndex();
				if(ei==2 && (sappr.equals("") || snum.equals("") || sbank.equals(""))){
					JOptionPane.showMessageDialog(null,"Enter Credit Card Amount");
				}else{
					try{
						int remain=0;
						int g=Integer.parseInt(billc2);
						int t=Integer.parseInt(billc3);
						if(t<0){
							System.out.println(g+"+"+t);
							remain=t-g;
						}else{
							System.out.println(g+"-"+t);
							remain=t-g;
						}
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql:///suvidha","root","");
						Statement st = con.createStatement();			
						String u="Update water_bill set bill='"+remain+"' where meter_no='"+meter1+"' ";
						int i=st.executeUpdate(u);
						if(i>0)
						{
							String q="insert into watersum(meter,amount,date,type,num,app,bank) values('"+meter1+"','"+t_billclear.getText()+"','"+strDate+"','"+typ+"','"+snum+"','"+sappr+"','"+sbank+"')";
							int a=st.executeUpdate(q);
							if(a>0){
								JOptionPane.showMessageDialog(pmaster,"Bill Paid");
							}else{
								JOptionPane.showMessageDialog(pmaster,"Work Properly");
							}
							setVisible(false);
						}
						else{
							JOptionPane.showMessageDialog(pmaster,"Work Properly");
						}
					}
					catch(Exception e){
						System.out.println("Exception in Updation: " +e);
					}
				}
			}
		}
	}
}