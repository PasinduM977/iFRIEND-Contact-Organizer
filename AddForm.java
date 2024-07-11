import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AddForm extends JFrame
{
	private JLabel Id;
	private JLabel Name;
	private JLabel Phoneumber;
	private JLabel Company;
	private JLabel Salary;
	private JLabel Birthday;
	
	private JButton Add;
	private JButton cancel;
	private JButton back;
	
	
	private JTextField TxtName;
	private JTextField TxtPhonenumber;
	private JTextField TxtCompany;
	private JTextField TxtSalary;
	private JTextField TxtBirthday;
	
	 
	public AddForm()
	{
		setSize(400,200);
		setTitle("IFRIEND ADD CUSTOMER");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Id=new JLabel(CustomerDBConnection.getInstance().getContactList().getContactId());
		add("North",Id);
		
		JPanel AddPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		cancel=new JButton("CANCEL");
		cancel.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent evt){
		TxtName.setText("");
		TxtPhonenumber.setText("");
		TxtCompany.setText("");
		TxtSalary.setText("");
		TxtBirthday.setText("");
		
			
		}});	
		
		AddPanel.add(cancel);
		
		back=new JButton("BACK TO HOME");
		back.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent evt){
		
		AddForm.this.dispose();
		new MainForm().setVisible(true);
			
		}});	
		AddPanel.add(back);
		
		Add=new JButton("ADD");
		Add.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent evt){
			String name=TxtName.getText();
			String pn=TxtPhonenumber.getText();
			String company=TxtCompany.getText();
			int sal=Integer.parseInt(TxtSalary.getText());
			String bd=TxtBirthday.getText();
			
			if(pn.length()!=10 | pn.charAt(0)!='0')
			{
				new Notificate("Invalid Phonenumber!").setVisible(true);
				return;
			}
			
			if(sal<0)
			{
				new Notificate("Invalid Salary!").setVisible(true);
				return;
			}
			
			int bday=(bd.charAt(0)-'0')*1000+(bd.charAt(1)-'0')*100+(bd.charAt(2)-'0')*10+(bd.charAt(3)-'0')*1;
			if(bday>2024)
			{
				new Notificate("Invalid Birthday!").setVisible(true);
				return;
			}
			
			
			contacts c1=new contacts(CustomerDBConnection.getInstance().getContactList().getContactId(),name,pn,company,sal,bd);
			CustomerDBConnection.getInstance().getContactList().add(c1);
			AddForm.this.dispose();
			new MainForm().setVisible(true);
			new Notificate("Contact Added Sucessfully...").setVisible(true);
			
			
			}});
		AddPanel.add(Add);
		add("South",AddPanel);
		
		JPanel LabelPanel=new JPanel(new GridLayout(5,1));
		Name=new JLabel("Name");
		LabelPanel.add(Name);
		
		Phoneumber=new JLabel("Phonenumber");
		LabelPanel.add(Phoneumber);
		
		Company=new JLabel("Company");
		LabelPanel.add(Company);
		
		Salary=new JLabel("Salary");
		LabelPanel.add(Salary);
		
		Birthday=new JLabel("Birthday");
		LabelPanel.add(Birthday);
		
		add("West",LabelPanel);
		
		JPanel ButtonPanel=new JPanel(new GridLayout(5,1));
		TxtName=new JTextField(8);
		ButtonPanel.add(TxtName);
		
		TxtPhonenumber=new JTextField(8);
		ButtonPanel.add(TxtPhonenumber);
		
		TxtCompany=new JTextField(8);
		ButtonPanel.add(TxtCompany);
		
		TxtSalary=new JTextField(8);
		ButtonPanel.add(TxtSalary);
		
		TxtBirthday=new JTextField(8);
		ButtonPanel.add(TxtBirthday);
		
		add("Center",ButtonPanel);
		
		
	}
	
	
	
	
}
