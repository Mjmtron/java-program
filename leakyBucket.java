//  Leaky bucket
// The algorithm works by using a metaphor of a "leaky bucket" where incoming data is added to the bucket and data is drained from the bucket at a regulated rate. 
// If the incoming data rate is higher than the regulated drain rate, the data builds up in the bucket, and the algorithm discards excess data to prevent overflow
import java.util.Scanner;

public class LeakyBucket { 	
	static int min(int x,int y)// returns min value 
	{ 
		if(x<y) 
			return x; 
		else 
			return y; 
	} 
	
	public static void main(String[] args) 
	 { 
		int drop=0,mini,nsec,cap,count=0,i,process; 
		
		try (Scanner scanner = new Scanner( System.in )) 
		{
			System.out.println("Enter The Bucket Size\n"); 
			cap= scanner.nextInt(); 
			System.out.println("Enter The Operation Rate\n"); 
			process= scanner.nextInt(); 
			System.out.println("Enter The No. Of Seconds You Want To Stimulate\n"); 
			nsec=scanner.nextInt();
			int inp[] =new int[nsec];
			for(i=0;i<nsec;i++) 
			{ 
				System.out.print("Enter The Size Of The Packet Entering At "+ i+1+"sec"); 
				inp[i] = scanner.nextInt(); 
			}  
			
			scanner.close(); 
			
			System.out.println("\nSecond | Packet Recieved | Packet Sent | Packet Left | Packet Dropped|\n"); 
			for(i=0;i<nsec;i++) 
			{  
				count+=inp[i]; 
				if(count>cap)  
				{ 
					drop=count-cap; 
					count=cap; 
				} 
				System.out.print(i+1); 
				System.out.print("\t\t"+inp[i]); 
				mini=min(count,process); //calling min funtion
				System.out.print("\t\t"+mini); 
				count=count-mini; 
				System.out.print("\t\t"+count); 
				System.out.print("\t\t"+drop);
				drop=0; 
				System.out.println(); 
			}
		} 
		for(;count!=0;i++) 
		{ 
			if(count>cap) 
			{ 
				drop=count-cap; 
				count=cap; 
			} 
			System.out.print(i+1); 
			System.out.print("\t\t0"); 
			mini=min(count,process); 
			System.out.print("\t\t"+mini); 
			count=count-mini; 
			System.out.print("\t\t"+count); 
			System.out.print("\t\t"+drop); 
			System.out.println(); 
		} 
		
	}
}
