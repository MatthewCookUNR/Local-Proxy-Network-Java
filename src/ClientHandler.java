import java.io.*;
import java.net.*;

//Purpose of class is create a thread that will handle all
//of the clients requests
public class ClientHandler implements Runnable
{
	private Socket socket = null;
    private DataInputStream  in = null; 

	public ClientHandler(Socket clientSocket) {
		try {
		//Gets socket for client
		socket = clientSocket;
		
        //Server gets input from the client
        in = new DataInputStream(socket.getInputStream());
		}
		catch(Exception e) {
			
		}

	}
	
	public void run() {
		
        //Packet is received and split into pieces based on delimiter
		try {
	        String line = "";
	        line = (String) in.readUTF();
	        String [] packet = line.split("~");
	        
	        
	        System.out.println("Packet Type: " + packet[0]);
	        System.out.println("Data: " + packet[1]);
		}
		catch(Exception e) {
			
		}
	}
}