package blockchain;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	
	private static ServerSocket serverSocket;
	private static final int PORT = 7000;
	private static ArrayList<ClientHandler<PatientData>> clients = new ArrayList<>();
	static private ExecutorService pool = Executors.newFixedThreadPool(4);

	public static void main(String[] args) {
		
		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("Listening on port "+ PORT + "...");
			do
			{
				run();
			}
			while (true); 
		}
		catch(IOException e) {
		       System.out.println("Unable to attach to port " + PORT);
		       System.exit(1);
		}
	}

	private static void run() {
		Scanner scn = null;
		try {
			boolean flag = true;
			scn = new Scanner(System.in);
			do {
				Socket client = serverSocket.accept();
                System.out.println("Client connected: " + client.getInetAddress().getHostAddress());
                ClientHandler<PatientData> clientThread = new ClientHandler<>(client);
                clients.add(clientThread);
                pool.execute(clientThread);
    			
            }while (flag);
		}
		catch(IOException e) {
			e.printStackTrace();
		}	
		finally {
			if(scn != null)
				scn.close();
		}
	}

}
