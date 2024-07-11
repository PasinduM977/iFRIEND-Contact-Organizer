class ContactList
{
	private contacts[] contactarray;
	int nextindex;
	int id;
	private int size;
	private int loadfactor;
	
	ContactList(int size,int loadfactor)
	{
		contactarray=new contacts[size];
		nextindex=0;
		id=0;
		this.size=size;
		this.loadfactor=loadfactor;
	}
	public String getContactId()
	{
		String conid;
			
    if(id>=0 & id<10)
    conid="C000"+(id+1);
    
    else if(id>=10 & id<100)
    conid="C00"+(id+1);
    
    else if(id>=100 & id<1000)
    conid="C0"+(id+1);
    
    else
    conid="C"+(id+1);
    
    return conid;
	}
	
	private boolean isfull()
	{
		return(nextindex==size);
	}
	
	private void extendarray()
	{
		contacts[] temp=new contacts[size+loadfactor];
		for(int x=0;x<nextindex;x++)
		{
			temp[x]=contactarray[x];	
		}
		contactarray=temp;
	}
//----------------------add contact------------------------------	
	public void add(contacts con)
	{
		if(isfull())
		{
			extendarray();
		}
		contactarray[nextindex]=con;
		nextindex++;
		id++;
	}
	//----------------------search contact------------------------------
	public int searchindex(String napn)
	{
		int index=-1;
	for(int x=0;x<nextindex;x++)
	{
		if(contactarray[x].getphonenumber().equals(napn))
		{
			index=x;
			break;
		}
		
	}
	return index;	
	}
	
	public int searchindexname(String napn)
	{
		int index=-1;
	for(int x=0;x<nextindex;x++)
	{
		if(contactarray[x].getname().equals(napn))
		{
			index=x;
			break;
		}
		
	}
	return index;	
	}
	
	//-----------------------update contacts---------------------------
	public void updatename(int ui,String newname)
	{
		contactarray[ui].setname(newname);
	}
	
	public void updatepn(int ui,String newpn)
	{
		contactarray[ui].setphonenumber(newpn);
	}
	
	public void updatecom(int ui,String newcom)
	{
		contactarray[ui].setcomapny(newcom);
	}
	
	public void updatesal(int ui,int newsal)
	{
		contactarray[ui].setsalary(newsal);
	}
	
	//----------------------------get details------------------------
	
	public String getid(int ui)
	{
		return contactarray[ui].getcontactid();
	}
	
	public String getn(int ui)
	{
		return contactarray[ui].getname();
	}
	
	public String getpn(int ui)
	{
		return contactarray[ui].getphonenumber();
	}
	
	public String getcom(int ui)
	{
		return contactarray[ui].getcomapny();
	}
	
	public int gets(int ui)
	{
		return contactarray[ui].getsalary();
	}
	
	public String getbd(int ui)
	{
		return contactarray[ui].getbirthday();
	}
	
	//-----------------------delete-----------------
	
	public void deletecontact(int ui)
	{
		contacts[] temp=new contacts[nextindex-1];
		
		for(int x=0,y=0;x<nextindex;x++)
		{
			if(x==ui)
			{continue;}
			temp[y++]=contactarray[x];
		}
		contactarray=temp;
		nextindex--;
	}
	
	//------------sort by name------------------------
	
	public contacts[] sortbyname()
	{
		String[] tempnames=new String[nextindex];
	
	for(int x=0;x<nextindex;x++)
	{
	tempnames[x]=contactarray[x].getname();	
	}
	
	//sorting to assending order
	for(int x=0;x<nextindex-1;x++)
	{
	for(int y=0;y<nextindex-1;y++)
		{
	if(tempnames[y].charAt(0)>tempnames[y+1].charAt(0))
			{
				String t=tempnames[y];
				tempnames[y]=tempnames[y+1];
				tempnames[y+1]=t;
			}	
		}	
	}
	
	//create a array of indexes of sorted array
	int[] indexnames=new int[nextindex];
	for(int x=0;x<nextindex;x++)
	{
			for(int y=0;y<nextindex;y++)
			{
					if(tempnames[x]==contactarray[y].getname())
					{
							indexnames[x]=y;
					}
			}
	}
	
	//print all arrays to the order of index array
	contacts[] listbyname=new contacts[nextindex];
	for(int x=0;x<nextindex;x++)
	{
		listbyname[x]=contactarray[indexnames[x]];
	}
	return listbyname;
	}
	
	//-------------------------sort bt salary---------------------------
	
	public contacts[] sortbysalary()
	{
		int[] tempsalary=new int[nextindex];
	
	for(int x=0;x<nextindex;x++)
	{
	tempsalary[x]=contactarray[x].getsalary();	
	}
	//sorting to assending order
	for(int x=0;x<nextindex-1;x++)
	{
	for(int y=0;y<nextindex-1;y++)
		{
	if(tempsalary[y]>tempsalary[y+1])
			{
				int t=tempsalary[y];
				tempsalary[y]=tempsalary[y+1];
				tempsalary[y+1]=t;
			}	
		}	
	}
	
	//create a array of indexes of sorted array
	int[] indexsalary=new int[nextindex];
	for(int x=0;x<nextindex;x++)
	{
			for(int y=0;y<nextindex;y++)
			{
					if(tempsalary[x]==contactarray[y].getsalary())
					{
							indexsalary[x]=y;
					}
			}
	}
	
	//print all arrays to the order of index array
	contacts[] listbysal=new contacts[nextindex];
	for(int x=0;x<nextindex;x++)
	{
		listbysal[x]=contactarray[indexsalary[x]];
	}
	return listbysal;
	}
	
	//-----------------------sort by birthday------------------
	
	public contacts[] sortbybirthday()
	{
		String[] tempbd=new String[nextindex];
	
	for(int x=0;x<nextindex;x++)
	{
	tempbd[x]=contactarray[x].getbirthday();	
	}
	//sorting to assending order
	for(int x=0;x<nextindex-1;x++)
	{
	for(int y=0;y<nextindex-1;y++)
		{
	if(bdcondition(tempbd[y],tempbd[y+1]))
			{
				String t=tempbd[y];
				tempbd[y]=tempbd[y+1];
				tempbd[y+1]=t;
			}	
		}	
	}
	
	//create a array of indexes of sorted array
	int[] indexbd=new int[nextindex];
	for(int x=0;x<nextindex;x++)
	{
			for(int y=0;y<nextindex;y++)
			{
					if(tempbd[x]==contactarray[y].getbirthday())
					{
							indexbd[x]=y;
					}
			}
	}
	
	//print all arrays to the order of index array
	contacts[] listbybd=new contacts[nextindex];
	for(int x=0;x<nextindex;x++)
	{
		listbybd[x]=contactarray[indexbd[x]];
	}
	return listbybd;
	}
	
	
	public  boolean bdcondition(String a,String b )
	{
			int ayr=(a.charAt(0)-'0')*1000+(a.charAt(1)-'0')*100+(a.charAt(2)-'0')*10+(a.charAt(3)-'0');
			int byr=(b.charAt(0)-'0')*1000+(b.charAt(1)-'0')*100+(b.charAt(2)-'0')*10+(b.charAt(3)-'0');
			int amon=(a.charAt(5)-'0')*10+(a.charAt(6)-'0');
			int bmon=(b.charAt(5)-'0')*10+(b.charAt(6)-'0');
			int aday=(a.charAt(8)-'0')*10+(a.charAt(9)-'0');
			int bday=(b.charAt(8)-'0')*10+(b.charAt(9)-'0');
			if(ayr>byr)
			return true;
			
			else if(ayr==byr & amon>bmon)
			return true;
			
			else if(ayr==byr & amon==bmon & aday>bday)
			return true;
			
			else
			return false;
	
	}
	
}
