

 import java.net.Socket;
import java.net.*;
import java.io.*;
public class TCPClient {

	 public static void main (String [] args ) throws IOException {
		 
		    ServerSocket serverSocket = new ServerSocket(15500);   
		    
		    
		   
		      int i =100;
		        long StartTime = System.currentTimeMillis();
		        while(i>0){
		          Socket socket = serverSocket.accept();
			      System.out.println("Connected! : " + socket);
			      File transferFile = new File ("Test1-small.txt");
			      byte [] bytearray  = new byte [(int)transferFile.length()];
			      FileInputStream fin = new FileInputStream(transferFile);
			      BufferedInputStream bin = new BufferedInputStream(fin);
			      bin.read(bytearray,0,bytearray.length);
			      OutputStream os = socket.getOutputStream();
			      System.out.println(" Files are being sent.");
			      os.write(bytearray,0,bytearray.length);
			      os.flush();
			      i = i-1;
			      socket.close();
			      long EndTime = System.currentTimeMillis();

                 long difference = EndTime - StartTime;
                 double avgtime = difference/100.0;

                
			    System.out.println("Transfer complete:"+difference);
			    System.out.println("Average time for file transfer in milli seconds: " + avgtime);
			    }
		      
			     
		    }
}



