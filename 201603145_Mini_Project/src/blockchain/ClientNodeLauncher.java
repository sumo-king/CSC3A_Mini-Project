package blockchain;

import javafx.application.Application;

public class ClientNodeLauncher {

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) { // Launching 3 clients as an example
            Application.launch(ClientNode.class, args);
        }

	}

}
