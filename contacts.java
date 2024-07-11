class contacts
{
	//-----------------attributes--------------------
	private String contactid;
	private String name;
	private String phonenumber;
	private String comapny;
	private int salary;
	private String birthday;
	
	
	//----------------constructor--------------------
	contacts(String contactid,String name,String phonenumber,String comapny,int salary,String birthday)
	{
		this.contactid=contactid;
		this.name=name;
		this.phonenumber=phonenumber;
		this.comapny=comapny;
		this.salary=salary;
		this.birthday=birthday;
		
	}
	
	//------------------seters-----------------------
	
	public void setcontactid(String contactid)
	{
		this.contactid=contactid;
	}
	
	public void setname(String name)
	{
		this.name=name;
	}
	
	public void setphonenumber(String phonenumber)
	{
		this.phonenumber=phonenumber;
	}
	
	public void setcomapny(String comapny)
	{
		this.comapny=comapny;
	}
	
	public void setsalary(int salary)
	{
		this.salary=salary;
	}
	
	public void setbirthday(String birthday)
	{
		this.birthday=birthday;
	}
	
	
	//------------------getters--------------
	
	public String getcontactid()
	{
		return contactid;
	}
	
	public String getname()
	{
		return name;
	}
	
	public String getphonenumber()
	{
		return phonenumber;
	}
	
	public String getcomapny()
	{
		return comapny;
	}
	
	public int getsalary()
	{
		return salary;
	}
	
	public String getbirthday()
	{
		return birthday;
	}
	
	
	
	
}
