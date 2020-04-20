import java.io.*;
import java.net.*;

public class Client_Side 
{
	private Socket socket = null;
    private DataInputStream  input = null; 
    private DataOutputStream out = null; 
    
	Client_Side(String address, int port) 
	{
		try {
			socket = new Socket(address, port);
            System.out.println("Connected to socket"); 
            out = new DataOutputStream(socket.getOutputStream()); 
		}
		catch (Exception e) {
			System.out.println("Error: " + e);
		}
		
		//Register your device
		registerDevice("Main PC");
		
        // close the connection 
        try
        { 
            socket.close(); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        }
        System.out.println("Terminating program, all done");
	}
	
	//Function sends a message to the server to register a device
	public void registerDevice(String deviceId) 
	{
		// Attempts to send over packet
        try {
        	String message = "0~" + deviceId;
        	out.writeUTF(message);
        }
        catch(Exception e) {
			System.out.println("Error: " + e);	
        }
	}
	
	public static void main (String[] args) 
	{
		Client_Side client = new Client_Side("Enter Your IP HERE", 12345);
	}
}