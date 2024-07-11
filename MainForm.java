import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class MainForm extends JFrame
{
	
	private JButton addButton;
	private JButton updateButton;
	private JButton deleteButton;
	private JButton searchButton;
	private JButton listButton;
	private JButton exitButton;
	private AddForm addform;
	
	public MainForm()
	{
		setSize(400,200);
		setTitle("IFRIEND Contact Organizer");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		
		addButton=new JButton();
		addButton.setText("ADD");
		addButton.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent evt){
			/*if(addform==null)
			{
			addform=new AddForm();
			addform.setVisible(true);
		    }*/
		    
		    new AddForm().setVisible(true);
		     MainForm.this.dispose();
			}});
		
		add(addButton);
		
		updateButton=new JButton();
		updateButton.setText("UPDATE");
		updateButton.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent evt){
			/*if(addform==null)
			{
			addform=new AddForm();
			addform.setVisible(true);
		    }*/
		    
		    new UpdateForm1().setVisible(true);
		     MainForm.this.dispose();
			}});
		add(updateButton);
		
		deleteButton=new JButton();
		deleteButton.setText("DELETE");
		deleteButton.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent evt){
			/*if(addform==null)
			{
			addform=new AddForm();
			addform.setVisible(true);
		    }*/
		    
		    new DeleteForm().setVisible(true);
		     MainForm.this.dispose();
			}});
		add(deleteButton);
		
		searchButton=new JButton();
		searchButton.setText("SEARCH");
		searchButton.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent evt){
			/*if(addform==null)
			{
			addform=new AddForm();
			addform.setVisible(true);
		    }*/
		    
		    new SearchForm().setVisible(true);
		    MainForm.this.dispose();
		    
			}});
		add(searchButton);
		
		listButton=new JButton();
		listButton.setText("VIEW");
		listButton.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent evt){
			/*if(addform==null)
			{
			addform=new AddForm();
			addform.setVisible(true);
		    }*/
		    
		    new ListForm().setVisible(true);
		     MainForm.this.dispose();
		    
			}});
		add(listButton);
		
		exitButton=new JButton();
		exitButton.setText("EXIT");
		exitButton.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent evt){
			/*if(addform==null)
			{
			addform=new AddForm();
			addform.setVisible(true);
		    }*/
		    
		    MainForm.this.dispose();
		    
			}});
		add(exitButton);
		
		
	}	
	
	public static void main(String args[])
	{
		new MainForm().setVisible(true);
		
	}
}
