import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
class ListForm extends JFrame
{
	private JButton ListByname;
	private JButton ListBySalary;
	private JButton ListByBirthday;
	ListForm()
	{
		setSize(500,100);
		setTitle("IFRIEND LIST CUSTOMER STEP 1");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		
		ListByname=new JButton("List By Name");
		ListByname.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent evt){
			contacts[] c1=CustomerDBConnection.getInstance().getContactList().sortbyname();
			new ListForm2("List By Name",c1).setVisible(true);
			ListForm.this.dispose();		
			}});
		add(ListByname);
		
		ListBySalary=new JButton("List By Salary");
		ListBySalary.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent evt){
			contacts[] c2=CustomerDBConnection.getInstance().getContactList().sortbysalary();
			new ListForm2("List By Salary",c2).setVisible(true);
			ListForm.this.dispose();		
			}});
		add(ListBySalary);
		
		ListByBirthday=new JButton("List By Birthday");
		ListByBirthday.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent evt){
			contacts[] c3=CustomerDBConnection.getInstance().getContactList().sortbybirthday();
			new ListForm2("List By Birthday",c3).setVisible(true);
			ListForm.this.dispose();		
			}});
		add(ListByBirthday);
		
	}
}

class ListForm2 extends JFrame
{
	private JTable Table;
	private DefaultTableModel dtm;
	
	private JButton Reload;
	private JButton back;
	private JLabel sortby;
	
	ListForm2(String sortbyop,contacts[] c)
	{
		setSize(500,300);
		setTitle("IFRIEND LIST CUSTOMER STEP 2");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		String[] ColumnNames={"Customer ID","Customer Name","Phonenumber","Company","Salary","Birthday"};
		dtm=new DefaultTableModel(ColumnNames,0);
		
		Table=new JTable(dtm);
		
		JScrollPane tablepane=new JScrollPane(Table);
		add("Center",tablepane);
		
		JPanel AddPanel=new JPanel();
		back=new JButton("BACK TO HOME");
		back.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent evt){
		
		ListForm2.this.dispose();
		new MainForm().setVisible(true);
			
		}});	
		AddPanel.add(back);
		
		Reload=new JButton("Reload");
		Reload.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent evt){
			
			
			for(int x=0;x<CustomerDBConnection.getInstance().getContactList().nextindex;x++)
			{
				Object[] rowData={c[x].getcontactid(),c[x].getname(),c[x].getphonenumber(),c[x].getcomapny(),c[x].getsalary(),c[x].getbirthday()};
				dtm.addRow(rowData);
			}
				
			}});
			AddPanel.add(Reload);
		add("South",AddPanel);
		
		JPanel labelpanel=new JPanel();
		sortby=new JLabel(sortbyop);
		labelpanel.add(sortby);
		add("North",labelpanel);
	}
	
	
}
