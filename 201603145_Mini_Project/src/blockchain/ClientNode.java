package blockchain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ClientNode extends Application{
	
	private static Socket clientSocket;
	private Map<String, String> patientData;
	private static InetAddress host;
	private static final int PORT = 7000;
	
	Label lblHeading1;
	Label lblFName;
	Label lblLName;
	Label lblPatientID;
	Label lblDOB;
	Label lblSex;
	Label lblContact;
	Label lblAddress;
	Label lblEmergency;
	Label lblHospital;
	Label lblReciever;
	
	TextField tfSex;
	TextField tfDOB;
	TextField tfPatientID;
	TextField tfFName;
	TextField tfLName;
	TextField tfContact;
	TextArea  taAddress;
	TextField tfEContact;
	TextField tfEmergencyName;
	TextField tfEmergencyLast;
	TextField tfHospital;
	TextField tfReciever;
	
	Button btnNext;
	
	Label lblHeading2;
	Label lblReason;
	Label lblVitals;
	Label lblTemperature;
	Label lblPulse;
	Label lblRate;
	Label lblBloodPressure;
	Label lblWeight;
	Label lblHeight;
	Label lblDoctor;
	Label lblEmergancyLast;
	Label lblEmergencyName;
	Label lblEContact;
	
	
	TextArea taReason;
	TextField tfVitals;
	TextField tfTemperature;
	TextField tfPulse;
	TextField tfRate;
	TextField tfBloodPressure;
	TextField tfWeight;
	TextField tfHeight;
	TextField tfDoctor;
	
	Button btnBack;
	Button btnEnter;
	Button btnView;
	
	//private static PatientData data;
	
	public ClientNode() {
		super();
		//pw = new PrintWriter(write, true);
		
		try {
			//write = new FileWriter(myStorage, true);
			host = InetAddress.getLocalHost();
			clientSocket = new Socket(host, PORT);
			System.out.println("Connection successful");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		
		launch(args);
		
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		patientData = new HashMap<>();
		
		GridPane root = new GridPane();
		GridPane grid = new GridPane();
		Scene scene1 = new Scene(root);
		Scene scene2 = new Scene(grid);
		
		root.setVgap(20);
		root.setAlignment(Pos.CENTER);
		
		lblHeading1 = new Label("Personal Information");
		lblPatientID = new Label("Patient ID:");
		lblFName = new Label("First Name:");
		lblLName = new Label("Last Name:");
		lblDOB = new Label("Date of birth:");
		lblSex = new Label("Sex:");
		lblContact = new Label("Contact number(cell):");
		lblAddress = new Label("Address:");
		lblEmergency = new Label("Emergency contact info: ");
		lblDoctor = new Label("Doctor:");
		lblEmergencyName = new Label("First Name:");
		lblEmergancyLast = new Label("Last Name:");
		lblEContact = new Label("Contact Number:");
		lblHospital = new Label("From Hospital:");
		lblReciever = new Label("To Hospital: ");
		
		taAddress = new TextArea();
		tfContact = new TextField();
		tfSex = new TextField();
		tfDOB = new TextField();
		tfFName = new TextField();
		tfLName = new TextField();
		tfPatientID = new TextField();
		tfDoctor = new TextField();
		tfEmergencyLast = new TextField();
		tfEmergencyName = new TextField();
		tfEContact = new TextField();
		tfHospital = new TextField();
		tfReciever = new TextField();
		
		
		lblHeading1.setUnderline(true);
		//lblHeading1.setFont(FontWeight.BOLD);
		
		btnNext = new Button("Next");
		btnView = new Button("View Blockchain");
		
		btnNext.setOnAction(e -> {
			
			primaryStage.setScene(scene2);
			
		});
		
		root.setHgap(10);
		
		root.add(lblHospital, 0, 0);
		root.add(tfHospital, 1, 0);
		root.add(lblReciever, 2, 0);
		root.add(tfReciever, 3, 0);
		root.add(btnView, 4, 0);
		root.add(lblHeading1, 0, 1);
		
		root.add(lblContact, 0, 6);
		root.add(tfContact, 1, 6);
		
		root.add(lblAddress, 0, 7);
		root.add(taAddress, 1, 7, 3, 1);
		
		root.add(lblEmergency, 0, 8);
		root.add(lblEmergencyName, 0, 9);
		root.add(tfEmergencyName, 1, 9);
		root.add(lblEmergancyLast, 2, 9);
		root.add(tfEmergencyLast, 3, 9);
		root.add(lblEContact, 0, 10);
		root.add(tfEContact, 1, 10);
		
		root.add(lblPatientID, 0, 2);
		root.add(tfPatientID, 1, 2);
		
		root.add(lblFName, 0, 3);
		root.add(tfFName, 1, 3);
		root.add(lblLName, 2, 3);
		root.add(tfLName, 3, 3);
		
		root.add(lblSex, 0, 4);
		root.add(tfSex, 1, 4);
		
		root.add(lblDOB, 0, 5);
		root.add(tfDOB, 1, 5);
		
		root.add(btnNext, 1, 11, 1, 2);
		
		//Scene 2
		grid.setVgap(20);
		grid.setHgap(20);
		grid.setAlignment(Pos.CENTER);
		
		
		lblHeading2 = new Label("Current Health Status");
		lblReason = new Label("Reason for hospitalization:");
		lblVitals = new Label("Vital signs:");
		lblTemperature = new Label("Temperature:");
		lblPulse = new Label("Pulse:");
		lblRate = new Label("Respritory Rate:");
		lblBloodPressure = new Label("Blood Pressure:");
		lblWeight = new Label("Weight: ");
		lblHeight = new Label("Height: ");
		
		taReason = new TextArea();
		tfVitals = new TextField();
		tfTemperature = new TextField();
		tfPulse = new TextField();
		tfRate = new TextField();
		tfBloodPressure = new TextField();
		tfWeight = new TextField();
		tfHeight = new TextField();
		
		btnEnter = new Button("Enter");
		btnBack = new Button("Back");
		
		taReason.setPrefWidth(300);
		taReason.setPrefHeight(50);
		taAddress.setPrefWidth(300);
		
		btnEnter.setOnAction(e -> {
			
			patientData.put("Reciever", tfReciever.getText());
			patientData.put("Sender", tfHospital.getText());
			patientData.put("address", taAddress.getText());
			patientData.put("contact", tfContact.getText());
			patientData.put("emergency-name", tfEmergencyName.getText());
			patientData.put("emergency-last", tfEmergencyLast.getText());
			patientData.put("emergency-contact", tfEContact.getText());
			patientData.put("sex",tfSex.getText());
			patientData.put("Date of birth",tfDOB.getText());
			patientData.put("first-name",tfFName.getText());
			patientData.put("last-name", tfLName.getText());
			patientData.put("id", tfPatientID.getText());
			patientData.put("Reason",taReason.getText());
			patientData.put("Vitals", tfVitals.getText());
			patientData.put("Temp", tfTemperature.getText());
			patientData.put("Pulse", tfPulse.getText());
			patientData.put("Rate", tfRate.getText());
			patientData.put("Blood Pressure", tfBloodPressure.getText());
			patientData.put("Weight", tfWeight.getText());
			patientData.put("Height", tfHeight.getText());
			patientData.put("doctor", tfDoctor.getText());
			
			try {
				
				ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
				//Sending data to server => client
				out.writeObject(patientData);
				out.flush();
				System.out.println(patientData +" sent to server and " + tfReciever);
				
				String response = in.toString();
				System.out.println("Response: "+ response.toString());
				
			} 
			catch(UnknownHostException unknown) {
				System.err.println("Unknown Host");
				unknown.printStackTrace();
			}
			catch(IOException ex) {
				System.err.println("Could not connect");
			}
			finally {
				if(clientSocket != null) {
					
					try {
						clientSocket.close();
					} catch (IOException ex) {
						
						ex.printStackTrace();
					}
					
				}
			}
			
		});
		
		btnBack.setOnAction(e -> {
			primaryStage.setScene(scene1);
		});
		
		
		btnView.setOnAction(e->{
			View view = new View();
			try {
				view.start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		
		grid.add(lblHeading2, 0, 1);
		grid.add(btnBack, 1, 1);
		GridPane.setHalignment(btnBack, HPos.RIGHT);
		lblHeading2.setUnderline(true);
		lblEmergency.setUnderline(true);
		
		grid.add(lblReason, 0, 2);
		grid.add(taReason, 1, 2);
		
		grid.add(lblVitals, 0, 3);
		grid.add(tfVitals, 1, 3);
		
		grid.add(lblTemperature, 0, 4);
		grid.add(tfTemperature, 1, 4);
		
		grid.add(lblPulse, 0, 5);
		grid.add(tfPulse, 1, 5);
		
		grid.add(lblRate, 0, 6);
		grid.add(tfRate, 1, 6);
		
		grid.add(lblBloodPressure, 0, 7);
		grid.add(tfBloodPressure, 1, 7);
		
		grid.add(lblWeight, 0, 8);
		grid.add(tfWeight, 1, 8);
		
		grid.add(lblHeight, 0, 9);
		grid.add(tfHeight, 1, 9);
		
		grid.add(lblDoctor, 0, 10);
		grid.add(tfDoctor, 1, 10);
		
		grid.add(btnEnter, 1, 11, 1, 2);
		
		primaryStage.setWidth(750);
		primaryStage.setHeight(700);
		primaryStage.setScene(scene1);
		primaryStage.setTitle("Patient card");
		primaryStage.show();
	}
	
	
	
}
