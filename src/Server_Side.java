import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.ArrayList;

//The purpose of this class is to open a socket on a given port that
//will be used to communicate with clients
public class Server_Side 
{
	private Socket socket = null;
	private ServerSocket server = null;
	private DataInputStream in = null;
	private ArrayList<ClientHandler> clients = new ArrayList<>();
	private int threadNum = 0;
	
	Server_Side(int port) 
	{
		try {
			//Server waits for connection
			server = new ServerSocket(port);
            System.out.println("Server started");
            
            boolean OPEN = true;
            System.out.println("Waiting for client...");
            
            
            //Server stays open indefinitely and creates a new thread
            //for the client to handle their requests
            while(OPEN) {
	            socket = server.accept();
	            System.out.println("Client accepted: Thread " + threadNum);
	            clients.add(new ClientHandler(socket));
	            clients.get(threadNum).run();
	            threadNum++;
            }
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