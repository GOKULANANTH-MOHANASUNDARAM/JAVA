package day1;

public class Program17 {
	final static int rollnumber = 29;
	static String myName = "Hari";
	static void main(String[] args) {
		 Program17a accessA = new Program17a();
		 Program17b accessB = new Program17b();
		 @SuppressWarnings("unused")
		Program17c accessC = new Program17c(rollnumber);    //The constructor Program17c() is undefined
		                  
		 accessA.accessNumber();
		 accessB.accessName();
	   }
}

class Program17a extends Program17{
	
	public void accessNumber()
	{
         //rollnumber = 32;       //cannot assign a value to final variable number ,number = 32;
		 
	       System.out.println(rollnumber);
	}
	
}

class Program17b extends Program17{
	
	public void accessName()
	{
	       System.out.println(myName);
	}
	
}


class Program17c extends Program17{
	
	      //The constructor Program17c() is undefined
   
	Program17c(int rollNumber){
		System.out.println(rollnumber);
	}
}