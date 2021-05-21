package hust.soict.dsai.aims.screen.updatestore;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.screen.cart.CartScreen;
import hust.soict.dsai.aims.screen.cart.CartScreenController;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddBookToStoreScreen extends JFrame {
	private Cart cart;
	private Store store;
	public AddBookToStoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;	
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Add Book");
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass()
							.getResource("/hust/soict/dsai/aims/screen/updatestore/addBook.fxml"));
					AddBookToStoreScreenController controller = 
							new AddBookToStoreScreenController(store, cart);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
}
//	public static void main(String[] args) {
//		Store store = new Store();
//		Cart cart = new Cart();
//		new AddBook(cart, store);
//
//	}
}
