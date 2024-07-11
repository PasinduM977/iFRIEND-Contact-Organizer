class CustomerDBConnection
{
	private static CustomerDBConnection customerdbconnection;
	private ContactList clist;
	private CustomerDBConnection()
	{
		clist=new ContactList(100,50);
	}
	
	public  static CustomerDBConnection getInstance()
	{
		if (customerdbconnection==null)
		{
		customerdbconnection=new CustomerDBConnection();
		}
		return customerdbconnection;
	}
	
	public ContactList getContactList()
	{
		return clist;
	}
}
