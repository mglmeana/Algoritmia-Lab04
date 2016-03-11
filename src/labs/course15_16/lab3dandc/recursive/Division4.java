package labs.course15_16.lab3dandc.recursive;

/* Params: a=4;b=2;k=0
 * The time complexity is O(n) 
 * and the waste of stack is O(log n)
 * Regardless the growth of n => the stack does not overflow 
 */
public class Division4 {
	public static long rec4 (int n)
	{
     long cont = 0;
	 if (n<=0) cont++;
	 else
	  { cont++ ; // O(1)  
	  
	    rec4(n/2);
	    rec4(n/2);
	    rec4(n/2);
	    rec4(n/2);
	    
	  }
	 return cont;   
	}
	
	public static void main (String arg []) 
	{
		 long t1,t2,cont = 0;	 
		 for (int n=1;n<=10000000;n*=2)
		 {
			  t1 = System.currentTimeMillis ();
			   
			  cont = rec4(n);
			      
			  t2 = System.currentTimeMillis ();
			
			  System.out.println ("n="+n+ "**TIME="+(t2-t1)+"**cont="+cont);	
		 }  // for
	} // main
} //c