//7 crc
// CRC, or Cyclic Redundancy Check, is a widely used error detection algorithm in data communication and storage systems. 
// It is a type of hash function that is used to detect errors in data transmission or storage.
import java.io.*;
import java.util.Scanner; 
public class crc {
	public static void main(String[] args)throws IOException {
		Scanner s=new Scanner(System.in);
		int[ ]data;
		int[ ]div; 
		int[ ]divisor; 
		int[ ]rem; 
		int[ ] crc; 
		int data_bits, divisor_bits, tot_length; 
		
		System.out.println("Enter number of data bits : "); 
		data_bits=s.nextInt();
		data=new int[data_bits];
		
		System.out.println("Enter data bits : "); 
		for(int i=0; i<data_bits; i++) 
			data[i]=s.nextInt(); 
		
		System.out.println("Enter number of bits in divisor : "); 
		divisor_bits = s.nextInt();
		divisor =new int[divisor_bits];
		
		System.out.println("Enter divisor bits");
		for(int i=0; i<divisor_bits; i++) 
			divisor[i]=s.nextInt(); 
		
		tot_length=data_bits+divisor_bits-1;
		div=new int[tot_length];
		rem=new int[tot_length]; 
		crc=new int[tot_length]; 

		
		
		
		/*------------------ CRC GENERATION----------------------*/ 
		for(int i=0;i<data.length;i++) 
		{ 
			div[i]=data[i]; 
			rem[i] = div[i];
		}
		
		rem=divide(div, divisor, rem); 
		
		System.out.print("Dividend (after appending 0's) are : "); 
		for(int i=0; i< div.length; i++) 
			System.out.print(div[i]); 
		
		System.out.println(); 
		
		System.out.println(); 
		
		System.out.println("CRC code : "); 
		
		for(int i=0;i<div.length;i++) //append dividend and remainder 
		{ 
			crc[i]=(div[i]^rem[i]); 
			System.out.print(crc[i]);
		} 
		
		
		
		/*-------------------ERROR DETECTION----------*/
		System.out.println(); 
		System.out.println("Enter CRC code of "+tot_length+" bits : "); 
		for(int i=0; i<crc.length; i++) 
		{
			crc[i]=s.nextInt();
			rem[i] = crc[i];
		}
	
		rem=divide(crc, divisor, rem); 
		s.close();
		
		for(int i=0; i< rem.length; i++) 
		{ 
			if(rem[i]!=0) 
			{
				System.out.println("Error"); break; 
			} 
			if(i==rem.length-1)	
				System.out.println("No Error");
			
		} 
	}
		
	
	
	
	
	static int[] divide(int div[],int divisor[], int rem[]) 
		{ 
			int cur=0; 
			while(true) 
			{ 
				for(int i=0;i<divisor.length;i++)
					rem[cur+i]=(rem[cur+i]^divisor[i]); 
				
				while(rem[cur]==0 && cur!=rem.length-1)
					cur++; 
				
				if((rem.length-cur)<divisor.length) 
					break; 
			} 
			return rem; 
		}
}

/* OUTPUT
Enter number of data bits : 
6
Enter data bits : 

1
0
0
1
0
0
Enter number of bits in divisor : 
4
Enter divisor bits
1
1
0
1
Dividend (after appending 0's) are : 100100000

CRC code : 
100100001
Enter CRC code of 9 bits : 
1
0
0
1
0
0
0
0
1
No Error

*/
