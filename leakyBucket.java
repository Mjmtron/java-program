//  Leaky bucket
// The algorithm works by using a metaphor of a "leaky bucket" where incoming data is added to the bucket and data is drained from the bucket at a regulated rate. 
// If the incoming data rate is higher than the regulated drain rate, the data builds up in the bucket, and the algorithm discards excess data to prevent overflow
import java.util.Scanner;
public class LeakyBucket { 
	
	static int min(int x,int y) 
	{ 
		if(x<y) 
			return x; 
		else 
			return y; 
	} 
	
	public static void main(String[] args) 
	 { 
		int drop=0,time,bucketSize,count=0,i,process; 
		
		try (Scanner scanner = new Scanner( System.in )) 
		{
			System.out.println("Enter The Bucket Size\n"); 
			bucketSize= scanner.nextInt(); 
			System.out.println("Enter no. of packet sent per sec:\n"); 
			process= scanner.nextInt(); 
			System.out.println("Enter The No. Of Seconds You Want To Stimulate\n"); 
			time=scanner.nextInt();
			int packetSize[] =new int[time];
			for(i=0;i<time;i++) 
			{ 
				System.out.print("Enter The Size Of The Packet Entering At "+ (i+1)+"sec"); 
				packetSize[i] = scanner.nextInt(); 
			}  
			
			scanner.close(); 
			
			System.out.println("\n time  | Packet Recieved | Packet Sent | Packet Left | Packet Dropped|\n"); 
			System.out.println("------------------------------------------------------------------------\n"); 
			for(i=0;i<time;i++) 
			{   
				count+=packetSize[i]; 
				if(count>bucketSize)  
				{ 
					drop=count-bucketSize; 
					count=bucketSize; 
				} 
				System.out.print(i+1); //no. of sec print
				System.out.print("\t\t"+packetSize[i]); //size of packet
				System.out.print("\t\t"+min(count,process)); 
				count-=min(count,process); 
				System.out.print("\t\t"+count); //buckSize/packSize
				System.out.print("\t\t"+drop);//count-buckSize
				drop=0; 
				System.out.println(); 
			}
		} 
		for(;count!=0;i++) 
		{ 
			if(count>bucketSize) 
			{ 
				drop=count-bucketSize; 
				count=bucketSize; 
			} 
			System.out.print(i+1); 
			System.out.print("\t\t0"); 
			System.out.print("\t\t"+min(count,process)); 
			count-=min(count,process); 
			System.out.print("\t\t"+count); 
			System.out.print("\t\t"+drop);  
			System.out.println(); 
		}
		
	}
}

/*OUTPUT
Enter The Bucket Size

3
Enter no. of packet sent per sec:

1
Enter The No. Of Seconds You Want To Stimulate

3
Enter The Size Of The Packet Entering At 1sec3
Enter The Size Of The Packet Entering At 2sec3
Enter The Size Of The Packet Entering At 3sec3

 time  | Packet Recieved | Packet Sent | Packet Left | Packet Dropped|

------------------------------------------------------------------------

1		3		1		2		0
2		3		1		2		2
3		3		1		2		2
4		0		1		1		0
5		0		1		0		0


*/
