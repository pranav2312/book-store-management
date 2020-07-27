import java.io.*;
import java.util.*;
import java.lang.*;
abstract class booktemp
{
	String bname;
	int quantity;
	int price;
	
}
class buyer extends booktemp
{	public int totalvalue=0;
			
	Scanner scan=new Scanner(System.in);
	void print() throws IOException
	{	int ch;
		BufferedReader f1=new BufferedReader(new FileReader("./book.txt"));
		while((ch=f1.read())!=-1)
		{	
			System.out.println("Book Name:-"+f1.readLine());
			System.out.println("Price = "+Integer.parseInt(f1.readLine())+" rupees\n");
			f1.readLine();
		}
		f1.close();
	}
	boolean findbook()throws IOException
	{	int ch,q=-1,l,flag=0;
				//int totalvalue=0;
				
					
				System.out.println("Enter Book name");
				String s=scan.nextLine();
			
				BufferedReader f2=new BufferedReader(new FileReader("./book.txt"));
				BufferedWriter f3=new BufferedWriter(new FileWriter("./book1.txt"));
				BufferedWriter f4=new BufferedWriter(new FileWriter("./bill.txt",true));
				while((ch=f2.read())!=-1)
				{	
					bname=f2.readLine();
					String s2=bname;
					price=Integer.parseInt(f2.readLine());
					quantity=Integer.parseInt(f2.readLine());
				//System.out.println( s + bname + "x");
					if(s.equals(s2))
					{	flag=1;
						//System.out.println( s + bname );
						lab:
						System.out.println("How many Quantity you want to buy");
						while(q<=0)
						{
						q=scan.nextInt();
						if(q<0)
							System.out.println("Enter valid quantity");
						}if(q>quantity)
						{
							System.out.println("Sorry,No more quantities avaliable");
							return true;
						
						}
						
						
					
						
					else
						{	f3.write("-");
							f3.write(bname+"\n");
							f3.write(String.valueOf(price)+"\n");
							f3.write((String.valueOf(quantity-q))+"\n");
							f4.write("-");
							f4.write(bname+"\n");
							f4.write("\t\t\t"+String.valueOf(price)+"\t");
							f4.write((String.valueOf(q))+"\t\t\t");
							f4.write((String.valueOf(price*q))+"\n");
							totalvalue+=price*q;
						}
					}
						else
						{	
							f3.write("-");
							f3.write(bname+"\n");
							f3.write(String.valueOf(price)+"\n");
							f3.write(String.valueOf(quantity)+"\n");
						}
				
				}
				if(flag==0)
				System.out.println("Book is Not Found");
				try{
					System.out.println("Loading .......");
				Thread.sleep(3000);
				}
				catch(InterruptedException ee)
				{
					ee.getMessage();
				}
				f2.close();
				f3.close();
				f4.close();
				if(flag ==1)
				{	System.out.println("___________________________________________________________________________________________________________");
					
					cfile();
					try{
						System.out.println("Loading .......");
				Thread.sleep(3000);
				}
				catch(InterruptedException ee)
				{
					ee.getMessage();
				}
				}
				return true;
						
				
	}
			void cfile() throws IOException
			{
				BufferedReader f2=new BufferedReader(new FileReader("./book1.txt"));
				FileWriter f3=new FileWriter("./book.txt");
				String  b;
				//System.out.println("asaadf");
				//int c;
				try {
					int c;
				while((c=f2.read())!=-1)
				{
					b=f2.readLine();
					
					f3.write("-"+b+"\n");
					b=f2.readLine();
					
				f3.write(String.valueOf(b)+"\n");
							b=f2.readLine();
							f3.write(String.valueOf(b)+"\n");
						
				}
				
				f3.close();
				f2.close();
			
				}
				catch (NumberFormatException e)
				{
				e.getMessage();
				}
				
			}
					
}


// class excution extends buyer
 class excution extends buyer
{	public static int getInt(Scanner scan){
			while(true){
				try{
					return scan.nextInt();
				}

				catch(InputMismatchException e){
					scan.next();
					System.out.println("The input is not an integer ,Please try again.");
				}
			}
		}
	Scanner scan=new Scanner(System.in);
		
	void choice()throws IOException
	{
		System.out.println("Want to Buy Or Sell?");
		int a=0;
		try
		{
			System.out.println("For Buying enter 1 and For Selling enter 0");
			a=getInt(scan);
			
			if(a!=0 && a!=1)
			throw new NullPointerException("");
			
		}	
			
		catch(NullPointerException e)
		{
			//System.out.println( e.getMessage());
			System.out.println(" invalid input");
			this.choice();
		}
		catch (InputMismatchException ex)
			{	
				ex.getMessage();
				System.out.println("Enter valid input");
				
				this.choice();
			}
		inputvalue(a);
		
	}
	void inputvalue(int a)throws IOException //throws InterruptedException
	{	int c;
		
		boolean re;
		if(a==1)
			
		{
				//buyer b=new buyer();
				try{
				print();
			}
				catch(IOException e)
			{
				System.out.println( e.getMessage());
			
			}
			
			System.out.println("\nWant to buy or not?");
			System.out.println("1 for buy and 0 For Proceed to cart");
			c=getInt(scan);
			if (c==1)
			{
				
				re=findbook();
				
					if(re==true)
					{
						inputvalue(1);
					}
			}
			else if(c==0)
			{	if(totalvalue==0)
				{
				System.out.println("Thank you For visiting");
				}
				else
				{
					BufferedWriter f11=new BufferedWriter(new FileWriter("./bill.txt",true));
					f11.write("\n\nTotal Bill Amount is\t"+totalvalue+" rupees\n");
					System.out.println("Thank You for Visiting..");
					f11.close();
					
					BufferedReader f5=new BufferedReader (new FileReader("./bill.txt"));
					
					int x;
					while((x=f5.read())!=-1)
					{
						System.out.print((char)x);
					}
					f5.close();
				}	
			}
			else
			{
				//Thread.sleep(10000);
				System.out.println("Enter valid input");
				try{
				Thread.sleep(1000);
				}
				catch(InterruptedException ee)
				{
					ee.getMessage();
				}
				inputvalue(1);
			}
			
			
		}
		else
		{	
			seller();
		}
	}
	void printsell() throws IOException
	{	int ch;
		BufferedReader f1=new BufferedReader(new FileReader("./book.txt"));
		while((ch=f1.read())!=-1)
		{	
			System.out.println("Book Name:-"+f1.readLine());
			System.out.println("Price= "+Integer.parseInt(f1.readLine()));
			System.out.println("Quantity:-"+Integer.parseInt(f1.readLine())+"\n");
		}
		f1.close();
	}
	{
		
	}
	void seller() throws IOException
	{
		printsell();
			System.out.println(" \nAdd a new book or to Increase quantity of existing one");
			System.out.println("1 for add book and 0 for existed one and -1 for exit ");
			int m=getInt(scan);
			try
			{
			if(m!=0 && m!=1 && m!=-1)
			throw new NullPointerException("");
			else if(m==1)
			{	int flage=0;
				System.out.println("Enter Book name");
				bname=scan.nextLine();
				bname=scan.nextLine();
				int k;
				BufferedReader f2=new BufferedReader(new FileReader("./book.txt"));
				
				while((k=f2.read())!=-1)
				{
					String s=f2.readLine();
					f2.readLine();
					f2.readLine();
					//System.out.println(bname+"x"+" "+s+"x");
					if(bname.equals(s))
					{
						System.out.println("This Book is Existed and not new book");
										try{
				Thread.sleep(3000);
				}
				catch(InterruptedException ee)
				{
					ee.getMessage();
				}
						seller();
					}
				}
				f2.close();
				while(flage==0)
				{
				System.out.println("Enter Price ");
				price=getInt(scan);
				System.out.println("Enter Quantity");
				quantity=getInt(scan);
				//BufferedWriter f8=new BufferedWriter(new FileWriter("./book.txt",true));
				//System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
				if(price<=0||quantity<=0)
				{
					flage=0;
					System.out.println("Enter valid credentials");
				
				}
				else{
					flage=1;
				}
				}
				BufferedWriter f8=new BufferedWriter(new FileWriter("./book.txt",true));
				
				System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
			
					
				try{
				Thread.sleep(3000);
				}
				catch(InterruptedException ee)
				{
					ee.getMessage();
				}
				f8.write("\n-"+bname);
				f8.write("\n"+String.valueOf(price));
				f8.write("\n"+String.valueOf(quantity));
				f8.close();
				seller();
			}
			else if(m==0)
			{	int flag=0;
				int q,ch;
			
				System.out.println("Enter A Book name");
				String s3=scan.nextLine();
				s3=scan.nextLine();
				BufferedReader f9=new BufferedReader(new FileReader("./book.txt"));
				BufferedWriter f10=new BufferedWriter(new FileWriter("./book1.txt"));
				while((ch=f9.read())!=-1)
				{	
					bname=f9.readLine();
					price=Integer.parseInt(f9.readLine());
					quantity=Integer.parseInt(f9.readLine());
					if(s3.equals(bname))
					{	flag=1;	
						q=-1;
						System.out.println("How many Quantity you want to Add");
						while(q<=0)
						{
						q=getInt(scan);
						if(q<=0)
							System.out.println("invlid quantity");
						}
						f10.write("-");
						f10.write(bname+"\n");
						f10.write(String.valueOf(price)+"\n");
						f10.write((String.valueOf(quantity+q))+"\n");
					}else
					{	f10.write("-");
						f10.write(bname+"\n");
						f10.write(String.valueOf(price)+"\n");
						f10.write(String.valueOf(quantity)+"\n");
					}
				
				}
				f9.close();
				f10.close();
				if(flag ==1)
				{	System.out.println("------------------------------------------------------------------------------------------------------------------------ ");
					cfile();
					seller();
					
				}
				else{
					System.out.println("book not found");
					try{
				Thread.sleep(3000);
				}
				catch(InterruptedException ee)
				{
					ee.getMessage();
				}
					seller();
				}
						
				
			}
			else if(m==-1)
				System.out.println("Stock is updated With new books");
			try{
				Thread.sleep(3000);
				}
				catch(InterruptedException ee)
				{
					ee.getMessage();
				}
			printsell();
			}	
			catch(NullPointerException e)
			{
			System.out.println(" invalid input");
			try{
				Thread.sleep(1000);
				}
				catch(InterruptedException ee)
				{
					ee.getMessage();
				}
			seller();
			}
			
	}
	/*void sfile() throws IOException
			{
				BufferedReader f2=new BufferedReader(new FileReader("./book1.txt"));
				FileWriter f3=new FileWriter("./book.txt");
				String  b;
				System.out.println("asaadf");
				//int c;
				try {
					int c;
				while((c=f2.read())!=-1)
				{
					b=f2.readLine();
					
					f3.write("-"+b+"\n");
					b=f2.readLine();
					
				f3.write(String.valueOf(b)+"\n");
							b=f2.readLine();
							f3.write(String.valueOf(b)+"\n");
						
				}
				
				f3.close();
				f2.close();
			
				}
				catch (NumberFormatException e)
				{
				e.getMessage();
				}
				
			}
			
	*/
			
			
				
				
			
		
}
class demo
	{
		public static int getInt(Scanner scan){
			while(true){
				try{
					return scan.nextInt();
				}

				catch(InputMismatchException e){
					scan.next();
					System.out.println("The input is not an integer ,Please try again.");
				}
			}
		}
		public static void main(String args[]) throws IOException
		{			
			BufferedReader f6=new BufferedReader(new FileReader("./billtemp.txt"));
			BufferedWriter f7=new BufferedWriter(new FileWriter("./bill.txt"));
			int y;
					while((y=f6.read())!=-1)
					{
						f7.write((char)y);
					}
					f6.close();
					f7.close(); 
			excution ex=new excution();
			try{ex.choice();
			}
			catch(IOException e)
			{}
			
		}
	}
FileWrite f1=new FileWrite("./bill.txt");
Runtime run =Runtime.getRuntime();

	Process process=run.exec("./notepad.exe ./bill.txt");

	
		
			
		
		