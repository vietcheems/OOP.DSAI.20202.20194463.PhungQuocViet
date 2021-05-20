package hust.soict.dsai.aims.screen.cart;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {
	private Cart cart;
	private Store store;
	public CartScreen(Cart cart, Store store) {
		super();
		
		this.store = store;
		this.cart = cart;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Cart");
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass()
							.getResource("/hust/soict/dsai/aims/screen/cart/cart.fxml"));
					CartScreenController controller = 
							new CartScreenController(cart, store);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		ArrayList<Track> tracks = new ArrayList<Track>();
		Track track1 = new Track("Track1", 50);
		Track track2 = new Track("Track2", 50);
		tracks.add(track1);
		tracks.add(track2);
		CompactDisc cd = new CompactDisc("Some CD name idk", "Pop", 50f, "20/01/2001", 100, "Someone chad", "Someone cheems",
				tracks);
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", 19.99f, "1/1/2021", "Roger Allers", 87);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", 24.95f, "1/1/2021", "George Lucas", 87);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f, "1/1/2021/", "Someone", 100);

		List<String> authors = new ArrayList<String>();
		authors.add("Dr.Nguyen Thieu Huy");
		Book b = new Book("Lecture on Algebra", "Textbook", 10.0f, "1/1/2021", authors);
		
		cart.addMedia(dvd1);
		cart.addMedia(dvd2);
		cart.addMedia(dvd3);
		cart.addMedia(b);
		cart.addMedia(cd);
		
		
		Store store = new Store();
		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);
		store.addMedia(b);
		store.addMedia(cd);
		new CartScreen(cart, store);

	}

}
