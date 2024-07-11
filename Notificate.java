import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Notificate extends JFrame
{
	private JLabel note;
	
	Notificate(String msg)
	{
		setSize(300,100);
		setTitle("NOTIFICATION!");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		note=new JLabel(msg);
		add("Center",note);
		
	}
}

class Notificate2 extends JFrame
{
	private JLabel sure;
	private JButton yes;
	private JButton no;
	
	Notificate2(int ui)
	{
		setSize(300,100);
		setTitle("ERROR!");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
	JPanel surepanel=new JPanel();
	sure=new JLabel("Are You Sure Want to Delete?");
	surepanel.add(sure);
	add("North",surepanel);
	
	JPanel btnpanel=new JPanel();
	yes=new JButton("Yes");
	yes.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent evt){
		
			CustomerDBConnection.getInstance().getContactList().deletecontact(ui);	
			Notificate2.this.dispose();
			new MainForm().setVisible(true);
			}});
	btnpanel.add(yes);
	
	no=new JButton("No");
	no.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent evt){
			
			Notificate2.this.dispose();
			new MainForm().setVisible(true);
			}});
	btnpanel.add(no);
	add("South",btnpanel);
		
	}
}
