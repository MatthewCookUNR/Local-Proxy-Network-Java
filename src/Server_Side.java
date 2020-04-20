import java.io.*;
import java.net.*;
import java.sql.*;


public class Server_Side 
{
	private Socket socket = null;
	private ServerSocket server = null;
	private DataInputStream in = null;
	
	Server_Side(int port) 
	{
		try {
			//Server waits for connection
			server = new ServerSocket(port);
            System.out.println("Server started");
            
            System.out.println("Waiting for client...");
            
            socket = server.accept();
            System.out.println("Client accepted");
            
            //Server gets input from the client
            in = new DataInputStream(socket.getInputStream());
            
            //Packet is received and split into pieces based on delimiter
            String line = "";
            line = (String) in.readUTF();
            String [] packet = line.split("~");
            
            
            System.out.println("Packet Type: " + packet[0]);
            System.out.println("Data: " + packet[1]);

 
            // close connection 
            socket.close(); 
            in.close(); 

		}
		catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	public static void main (String[] args) 
	{
		Server_Side server = new Server_Side(5000);
	}
}