package blockchain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import acsse.csc03a3.Block;
import acsse.csc03a3.Blockchain;
import acsse.csc03a3.Transaction;

public class ClientHandler<T> implements Runnable{

	private Socket clientSocket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private Map<String, String> m;
	private Transaction<PatientData> transaction;
	private PatientData newPatient;
	private Block<PatientData> block;
	private List<Transaction<PatientData>> list = new ArrayList<>();
	private Blockchain<PatientData> chain;
	private File storageFile;
	
	public ClientHandler(Socket clientSocket) {
		this.clientSocket = clientSocket;
		
		try {
            out = new ObjectOutputStream(this.clientSocket.getOutputStream());
            in = new ObjectInputStream(this.clientSocket.getInputStream());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		
		storageFile = new File("blockchain_storage.txt");
		BufferedReader fileIn = null;
		PrintWriter fileOut = null;
		//ObjectInputStream objIn = null;
			try {
				
				FileReader reader = new FileReader(storageFile);
				FileWriter write = new FileWriter(storageFile, true);
				//objIn  = new ObjectInputStream(new FileInputStream(storageFile));
				fileIn = new BufferedReader(reader);
				fileOut = new PrintWriter(write, true);
					
			    m =  (Map<String, String>) in.readObject();
			    System.out.println("Recieved the following transaction: " + m.toString() +
			            		"\nFrom: " + m.get("first-name") + " " + m.get("last-name") +
			            		"\nID: " + m.get("id"));
			            
			    newPatient = new PatientData(m);
			    transaction = new Transaction<>(m.get("Sender"), m.get("Reciever") ,newPatient);
			    String line = "";
			    if((storageFile.length() != 0)) {
				    while(fileIn.readLine() != null) {
				    	line += fileIn.readLine()+"\n";
				    }
				    
				    String arr[] = line.split("\n");
				    for(int i = 0; i < arr.length ; ++i) {
				    	
				    	PatientData d = new PatientData();
				    	
				    	list.add(d.parseString(arr[i]));
				    	
				    }
				    block = new Block<>("", list);
				    
			    }
			    
			    
			    
			    if(storageFile.length() != 0) {
			    	chain = new Blockchain<>();
//			    	List<Transaction<PatientData>> existingTrans = (List<Transaction<PatientData>>) objIn.readObject();
//			    	chain.addBlock(existingTrans);
			    	list.add(transaction);
			    	chain.registerStake(transaction.getSender(), 1);
			    	chain.addBlock(list);
			    	fileOut.println(chain);
			    	
			    } else if(storageFile.exists() && (storageFile.length() == 0)) {
			    	
					 //Create genesis block if file exists
					list.add(transaction);
					chain.registerStake(transaction.getSender(), 1);
				    block = new Block<>("", list);
				    chain.addBlock(block.getTransactions());
				    fileOut.println(block.toString() + "\n\r");
			    }
			    
			    System.out.println(list.toString());
				System.out.println("Size: " + list.size());
					
//		        Send response to client
		        out.writeObject("Transaction received and added to the mempool.");
		        out.flush();
		            
		        } catch (IOException | ClassNotFoundException e) {
		            e.printStackTrace();
		        } finally {
		        	if(fileIn != null | in != null | out != null) {
		        		try {
							out.close();
							in.close();
							fileIn.close();
							fileOut.close();
							//objIn.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        	}
		        	
		        }
		
	}

}
