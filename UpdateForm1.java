import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class UpdateForm1 extends JFrame
{
	private JLabel LabelSearch;
	private JTextField TxtSearch;
	private JButton SearchButton;
	private JButton cancel;
	private JButton back;
	
	UpdateForm1()
	{
		setSize(500,100);
		setTitle("IFRIEND UPDATE CUSTOMER STEP 1");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel SearchPanel=new JPanel(new GridLayout(1,2));
		LabelSearch=new JLabel("Serch Contact by Name or PhoneNumber");
		SearchPanel.add(LabelSearch);
		
		TxtSearch=new JTextField(8);
		SearchPanel.add(TxtSearch);
		
		add("North",SearchPanel);
		
		JPanel btnPanel=new JPanel();
		cancel=new JButton("CANCEL");
		cancel.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent evt){
	
		TxtSearch.setText("");
			
		}});	
		
		btnPanel.add(cancel);
		
		back=new JButton("BACK TO HOME");
		back.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent evt){
		
		UpdateForm1.this.dispose();
		new MainForm().setVisible(true);
			
		}});	
		btnPanel.add(back);
		
		SearchButton=new JButton("SEARCH");
		SearchButton.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent evt){
			
			String napn=TxtSearch.getText();
			int ui=-1;
	if(napn.charAt(0)=='0')
	{
	ui=CustomerDBConnection.getInstance().getContactList().searchindex(napn);
	
	}
	
	else
	{
	ui=CustomerDBConnection.getInstance().getContactList().searchindexname(napn);
	
	}
	
	if(ui==-1)
			{
				new Notificate("Your Contact Cannot Find!").setVisible(true);
			}
	else
	{
	new UpdateForm2(CustomerDBConnection.getInstance().getContactList().getid(ui),CustomerDBConnection.getInstance().getContactList().getn(ui),CustomerDBConnection.getInstance().getContactList().getpn(ui),CustomerDBConnection.getInstance().getContactList().getcom(ui),CustomerDBConnection.getInstance().getContactList().gets(ui),CustomerDBConnection.getInstance().getContactList().getbd(ui),ui).setVisible(true);
	UpdateForm1.this.dispose();	
	}	
			}});
			btnPanel.add(SearchButton);
		add("Center",btnPanel);
	}
}

class UpdateForm2 extends JFrame
{
	private JLabel DisId;
	private JLabel DisName;
	private JLabel DisPhonenumber;
	private JLabel DisCompany;
	private JLabel DisSalary;
	private JLabel DisBirthday;
	
	private JLabel Tittle;
	
	private JButton BtnName;
	private JButton BtnPhonenumber;
	private JButton BtnCompany;
	private JButton BtnSalary;
	
	UpdateForm2(String id,String name,String pn,String com,int sal,String bd,int ui)
	{
		
		setSize(500,200);
		setTitle("IFRIEND UPDATE CUSTOMER STEP 2");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel DisPanel=new JPanel(new GridLayout(6,1));
		DisId=new JLabel("Contact ID :"+id);
		DisPanel.add(DisId);
		
		DisName=new JLabel("Contact NAME :"+name);
		DisPanel.add(DisName);
		
		DisPhonenumber=new JLabel("PHONE NUMBER :"+pn);
		DisPanel.add(DisPhonenumber);
		
		DisCompany=new JLabel("COMPANY :"+com);
		DisPanel.add(DisCompany);
		
		DisSalary=new JLabel("SALARY :"+sal);
		DisPanel.add(DisSalary);
		
		DisBirthday=new JLabel("BIRTH DAY :"+bd);
		DisPanel.add(DisBirthday);
		
		add("North",DisPanel);
		
		Tittle=new JLabel("What Do you want to Update?");
		add("Center",Tittle);
		
		JPanel BtnPanel=new JPanel(new FlowLayout());
		BtnName=new JButton("NAME");
		BtnName.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent evt){
			
			new UpdateForm3("Input New Name",1,ui).setVisible(true);	
			UpdateForm2.this.dispose();
			}});
		BtnPanel.add(BtnName);
		
		BtnPhonenumber=new JButton("PHONENUMBER");
		BtnPhonenumber.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent evt){
			
			new UpdateForm3("Input New Phonenumber",2,ui).setVisible(true);	
			UpdateForm2.this.dispose();
			}});
		BtnPanel.add(BtnPhonenumber);
		
		BtnCompany=new JButton("COMPANY");
		BtnCompany.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent evt){
			
			new UpdateForm3("Input New Company Name",3,ui).setVisible(true);	
			UpdateForm2.this.dispose();
			}});
		BtnPanel.add(BtnCompany);
		
		BtnSalary=new JButton("SALARY");
		BtnSalary.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent evt){
			
			new UpdateForm3("Input New Salary",4,ui).setVisible(true);	
			UpdateForm2.this.dispose();
			}});
		BtnPanel.add(BtnSalary);
		
		add("South",BtnPanel);
		
	}
	
}

class UpdateForm3 extends JFrame
{
	private JLabel LabelInput;
	private JTextField TxtInput;
	private JButton UpdateButton;
	
	
	
	UpdateForm3(String Labelname,int findtype,int ui)
	{
		
		setSize(500,100);
		setTitle("IFRIEND UPDATE CUSTOMER STEP 3");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel UpdatePanel=new JPanel(new GridLayout(1,2));
		LabelInput=new JLabel(Labelname);
		UpdatePanel.add(LabelInput);
		
		TxtInput=new JTextField(8);
		UpdatePanel.add(TxtInput);
		
		add("North",UpdatePanel);
		
		UpdateButton=new JButton("UPDATE");
		UpdateButton.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent evt){
			
			if(findtype==1)
			CustomerDBConnection.getInstance().getContactList().updatename(ui,TxtInput.getText());
			
			else if(findtype==2)
			{
				if(TxtInput.getText().length()!=10 | TxtInput.getText().charAt(0)!='0')
			{
				new Notificate("Invalid Phonenumber!").setVisible(true);
			}
			else
			{
			CustomerDBConnection.getInstance().getContactList().updatepn(ui,TxtInput.getText());
			}
			}
			else if(findtype==3)
			CustomerDBConnection.getInstance().getContactList().updatecom(ui,TxtInput.getText());
			
			else
			{
				if(Integer.parseInt(TxtInput.getText())<0)
			{
				new Notificate("Invalid Salary!").setVisible(true);
			}
				else
				{
			CustomerDBConnection.getInstance().getContactList().updatesal(ui,Integer.parseInt(TxtInput.getText()));
				}
			}	
			UpdateForm3.this.dispose();
			new MainForm().setVisible(true);
			}});
		
		add("Center",UpdateButton);
	}
}

