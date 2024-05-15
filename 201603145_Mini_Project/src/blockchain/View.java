package blockchain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

class View extends Application{
	
	Label lblTransactions;
	TextArea taTransactionWindow;
	Button btnBack;
	Button btnReload;

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		File viewFile = new File("blockchain_storage.txt");
		FileReader reader;
		BufferedReader in;
		GridPane root = new GridPane();
		Scene sc = new Scene(root);
		
		btnBack = new Button("Back");
		btnReload = new Button("Reload");
		taTransactionWindow = new TextArea();
		lblTransactions = new Label("Blockchain:");
		taTransactionWindow.setPrefWidth(700);
		taTransactionWindow.setPrefHeight(600);

		root.add(lblTransactions, 0, 0);
		root.add(taTransactionWindow, 1, 1);
		root.add(btnBack, 1, 2);
		root.add(btnReload, 0, 3);
		
		//ClientNode cl = new ClientNode();
		
		
		if(viewFile.exists()) {
			reader = new FileReader(viewFile);
			in = new BufferedReader(reader);
			
			String line = "";
			while(in.readLine() != null) {
				line += in.readLine()+"\n";
			}
			
			
			String arr[] = line.split("\n");
			System.out.println("Arr size: "+arr.length);
			for(int i = 0; i < arr.length; ++i) {
				System.out.println(arr[i]);
				taTransactionWindow.appendText(arr[i] + "\n");
			}
			
		}
		
		btnReload.setOnAction(e->{
			File view= new File("blockchain_storage.txt");
			FileReader reader1;
			BufferedReader in1;
			try {
				reader1 = new FileReader(view);
				in1 = new BufferedReader(reader1);
				String line = "";
				while(in1.readLine() != null) {
					line += in1.readLine()+"\n";
				}
				taTransactionWindow.clear();
				String arr[] = line.split("\n");
				System.out.println("Arr size: "+arr.length);
				for(int i = 0; i < arr.length; ++i) {
					System.out.println(arr[i]);
					taTransactionWindow.appendText(arr[i] + "\n");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			
			
			
		});
		
		root.setVgap(20);
		root.setAlignment(Pos.CENTER);
		root.setPrefWidth(900);
		root.setPrefHeight(800);

		primaryStage.setScene(sc);
		primaryStage.show();
	
	}

}