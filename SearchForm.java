import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class SearchForm extends JFrame
{
	private JLabel LabelSearch;
	private JTextField TxtSearch;
	private JButton SearchButton;
	private JButton cancel;
	private JButton back;
	
	SearchForm()
	{
		setSize(500,100);
		setTitle("IFRIEND SEARCH CUSTOMER STEP 1");
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
		
		SearchForm.this.dispose();
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
	new SearchForm2(CustomerDBConnection.getInstance().getContactList().getid(ui),CustomerDBConnection.getInstance().getContactList().getn(ui),CustomerDBConnection.getInstance().getContactList().getpn(ui),CustomerDBConnection.getInstance().getContactList().getcom(ui),CustomerDBConnection.getInstance().getContactList().gets(ui),CustomerDBConnection.getInstance().getContactList().getbd(ui),ui).setVisible(true);
	SearchForm.this.dispose();
	}		
			}});
		btnPanel.add(SearchButton);
		add("Center",btnPanel);
	}
}

class SearchForm2 extends JFrame
{
	private JLabel DisId;
	private JLabel DisName;
	private JLabel DisPhonenumber;
	private JLabel DisCompany;
	private JLabel DisSalary;
	private JLabel DisBirthday;
	
	private JLabel Tittle;
	private JButton back;
	
	
	
	
	SearchForm2(String id,String name,String pn,String com,int sal,String bd,int ui)
	{
		
		setSize(500,200);
		setTitle("IFRIEND DELETE CUSTOMER STEP 2");
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
		
		Tittle=new JLabel("Search Successful");
		add("Center",Tittle);
		
		JPanel btnpanel=new JPanel();
		back=new JButton("Back TO HOME");
		back.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent evt){
		
		SearchForm2.this.dispose();
		new MainForm().setVisible(true);
			
		}});
		btnpanel.add(back);
		add("South",btnpanel);
		
		
	}
	
}
