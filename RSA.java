// The RSA algorithm consists of two algorithms: Key Generation and Encryption/Decryption. 
// In Key Generation, two large prime numbers are generated and used to generate a public key and a private key.
// The public key is used to encrypt the message, while the private key is used to decrypt it.
import java.util.*;

public class rsa {
	
	static int gcd(int m,int n) 
	{ 
		while(n!=0) 
		{ 
			 int r=m%n; 
			 m=n; 
			 n=r; 
		} 
		return m; 
	} 
	
	public static void main(String args[]) 
	{ 
		int p=0,q=0,n=0,e=0,d=0,phi=0; 
		int nummes[]=new int[100]; 
		int encrypted[]=new int[100]; 
		int decrypted[]=new int[100]; 
		int i=0,j=0,nofelem=0; 
		
		Scanner s =new Scanner(System.in); 
		String message ; 
		System.out.println("Enter the Message tobe encrypted:"); 
		message= s.nextLine(); 
		System.out.println("Enter value of p and q\n"); 
		p=s.nextInt(); 
		q=s.nextInt();
		s.close();
		n=p*q; 
		phi=(p-1)*(q-1); 
		for(i=2;i<phi;i++) 
			if(gcd(i,phi)==1) 
				break; 
		
		e=i; 
		for(i=2;i<phi;i++) 
			if((e*i-1)%phi==0) 
				break; 
		d=i; 
		for(i=0;i<message.length();i++) 
		{ 
			char c = message.charAt(i); 
			int a =(int)c; 
			nummes[i]=a-96; 
		} 
		nofelem=message.length(); 
		for(i=0;i<nofelem;i++) 
		{ 
			encrypted[i]=1; 
			for(j=0;j<e;j++) 
				encrypted[i] =(encrypted[i]*nummes[i])%n; 
		} 
		
		System.out.println("\nEncrypted message\n"); 
		for(i=0;i<nofelem;i++) 
		{ 
			System.out.print(encrypted[i]); 
			System.out.print((char)(encrypted[i]+96)); 
		} 
		for(i=0;i<nofelem;i++) 
		{ 
			decrypted[i]=1; 
			for(j=0;j<d;j++)  
				decrypted[i]=(decrypted[i]*encrypted[i])%n; 
		} 
		
		System.out.println("\n\nDecrypted message\n "); 
		for(i=0;i<nofelem;i++) 
			System.out.print((char)(decrypted[i]+96)); 
		return; 
	}
}
/*OUTPUT
Enter the Message tobe encrypted:
yo man
Enter value of p and q

11
7

Encrypted message

53?71§-1_62?1a42?

Decrypted message
 
yo man
*/
