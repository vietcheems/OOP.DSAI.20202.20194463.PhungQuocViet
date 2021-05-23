package hust.soict.dsai.aims.screen.updatestore;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddCompactDiscToStoreScreen extends JFrame {
	private Cart cart;
	private Store store;
	public static JFXPanel fxPanel;
	public AddCompactDiscToStoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;	
		fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Add CD");
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass()
							.getResource("/hust/soict/dsai/aims/screen/updatestore/addCd.fxml"));
					AddCompactDiscToStoreScreenController controller = 
							new AddCompactDiscToStoreScreenController(store, cart);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
