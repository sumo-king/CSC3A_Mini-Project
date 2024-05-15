package blockchain;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
//	Login page
	
	public static void main(String[] args) {
		 launch(args);
	}

//	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		GridPane root = new GridPane();
		
		primaryStage.setScene(initialScene(root, primaryStage));
		primaryStage.show();
		
	}

	public Scene initialScene(GridPane root, Stage stage) {
		
		Scene sc = new Scene(root);
		
		Label lblWelcome = new Label("Welcome!");
		Label lblChoose = new Label("Select your desired action:");
		Button btnView = new Button("View");
		Button btnCreate = new Button("Create Patient File");
		
		
		root.add(lblWelcome, 0, 0);
		root.add(lblChoose, 0, 1);
		root.add(btnCreate, 0, 2);
		root.add(btnView, 1, 2);
		
		root.setVgap(20);
		root.setHgap(20);
		root.setAlignment(Pos.CENTER);
		root.setPrefWidth(500);
		root.setPrefHeight(500);
		
		View view = new View();
		btnView.setOnAction(e->{
			try {
				view.start(stage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		ClientNode client = new ClientNode();
		btnCreate.setOnAction(e->{
			try {
				client.start(stage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		return sc;
	}
}
