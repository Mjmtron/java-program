// SEND message from server to client
//Server
import java.io.*;
import java.net.*;
import java.util.*;
public class Server1 
{
public static void main(String[] args)
{
Scanner sc = new Scanner(System.in);
try
{
ServerSocket ss=new ServerSocket(6666);
Socket s=ss.accept(); //establishes connection 
DataOutputStream dout=new DataOutputStream(s.getOutputStream());
System.out.println("Type the Message to be Sent to Client ");
dout.writeUTF(sc.nextLine());
dout.flush();
dout.close();
ss.close();
}
catch(Exception e)
{
System.out.println(e);
}
}
}

/*OUTPUT
mj@LAPTOP-2121KKHD:~$ java p10cs.java
Type the Message to be Sent to Client
hello
*/
////////////////////////////////////////////////////////////////////////////////////
//Client
import java.io.*;
import java.net.*;
public class Client 
{
public static void main(String[] args) 
{
try
{
Socket s=new Socket("localhost",6666);
DataInputStream dis=new DataInputStream(s.getInputStream());
String str=(String)dis.readUTF();
System.out.println("message= "+str);
s.close();
}
catch(Exception e)
{
System.out.println(e);
}
}
}

/*OUTPUT
mj@LAPTOP-2121KKHD:~$ java p10cc.java
message= hello
*/
