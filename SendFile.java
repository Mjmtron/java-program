// program can run only on unix terminal
// sending file over tcp/ip network
// server
import java.net.*;
import java.io.*;
public class ContentsServer
{
public static void main(String args[]) throws Exception
{
  ServerSocket sersock = new ServerSocket(4000);
  System.out.println("Server Ready for Connection");
  Socket sock = sersock.accept();
  System.out.println("Connection is successfull");
  InputStream istream = sock.getInputStream();
  BufferedReader fileRead = new BufferedReader(new InputStreamReader (istream));
  String fname = fileRead.readLine();
  System.out.println("Requested File:"+fname);
  BufferedReader ContentRead = new BufferedReader(new FileReader(fname));
  OutputStream ostream = sock.getOutputStream();
  PrintWriter pwrite = new PrintWriter(ostream,true);
  String str;
  while((str = ContentRead.readLine())!= null)
  {
    pwrite.println(str);
  }
  System.out.println("\nFile has been transfered!");
  sock.close();
  sersock.close();
  pwrite.close();
  fileRead.close();
  ContentRead.close();
}
}

/*OUTPUT
mj@LAPTOP-2121KKHD:~$ java p9cs.java
Server Ready for Connection
Connection is successfull
REQUESTES FILE: file.txt

file has been transfered!
*/

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// client
import java.net.*;
import java.io.*;
public class ContentsClient
{
public static void main(String args[]) throws Exception
{
Socket sock = new Socket("127.0.0.1",4000);
System.out.println("Enter the file Name");
BufferedReader KeyRead = new BufferedReader(new InputStreamReader(System.in));
String fname = KeyRead.readLine();
OutputStream ostream = sock.getOutputStream();
PrintWriter pwrite = new PrintWriter(ostream, true);
System.out.print("Filie Content \n");
pwrite.println(fname);
InputStream istream = sock.getInputStream();
BufferedReader socketRead = new BufferedReader(new InputStreamReader(istream));
String str;
System.out.println('"');
System.out.println("\n");
while((str = socketRead.readLine())!=null)
{
    System.out.println(str);
}
System.out.println("\n");
System.out.println('"');
pwrite.close();
socketRead.close();
KeyRead.close();
}
}

/*OUTPUT
mj@LAPTOP-2121KKHD:~$ java p9cc.java
Enter the file Name
file.txt
File Content
"


hello


"
*/
