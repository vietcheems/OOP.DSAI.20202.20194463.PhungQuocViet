package hust.soict.dsai.aims.screen.updatestore;

import java.util.ArrayList;

import javax.naming.LimitExceededException;
import javax.swing.JOptionPane;

import hust.soict.dsai.aims.screen.updatestore.AddBookToStoreScreen;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.MediaConstructorException;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.screen.cart.CartScreen;
import hust.soict.dsai.aims.screen.store.StoreScreen;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class AddCompactDiscToStoreScreenController {
	private Store store;
	private Cart cart;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
    @FXML
    private Button btnAddToStore;

    @FXML
    private MenuItem menuItemAddDvd;

    @FXML
    private TextField tfTrackLength;

    @FXML
    private MenuItem menuItemAddCd;

    @FXML
    private TextField tfTrackTitle;

    @FXML
    private MenuItem menuItemViewStore;

    @FXML
    private MenuItem menuItemViewCart;

    @FXML
    private TextField tfDirector;

    @FXML
    private TextField tfCost;

    @FXML
    private TextField tfArtist;

    @FXML
    private TextField tfTitle;

    @FXML
    private Button btnBackToStore;

    @FXML
    private Button btnAddTrack;

    @FXML
    private TextField tfCategory;

    @FXML
    private MenuItem menuItemAddBook;
    
    public AddCompactDiscToStoreScreenController(Store store, Cart cart) {
		// TODO Auto-generated constructor stub
    	this.cart = cart;
    	this.store = store;
	}

    @FXML
    void btnAddTrackPressed(ActionEvent event) {
    	Track track = new Track(tfTrackTitle.getText(), Integer.valueOf(tfTrackLength.getText()));
    	tracks.add(track);
    	JOptionPane.showMessageDialog(null, "Track added successfully to CD. Input the information again to add another track");
    	tfTrackTitle.setText("");
    	tfTrackLength.setText("");
    }

    @FXML
    void btnAddToStorePressed(ActionEvent event) {
    	String title = tfTitle.getText();
    	String category = tfCategory.getText();
    	Float cost = Float.valueOf(tfCost.getText());
    	String dateAdded = String.valueOf(java.time.LocalDateTime.now());
    	String director = tfDirector.getText();
    	String artist = tfArtist.getText();
    	Integer cdLength = 0;
    	for (Track track:tracks) {
    		cdLength += track.getLength();
    	}
    	JOptionPane.showMessageDialog(null, "CD added successfully");
    	CompactDisc cd;
		try {
			cd = new CompactDisc(title, category, cost, dateAdded, cdLength, director, artist, tracks);
	    	this.store.addMedia(cd);
	    	this.tracks = new ArrayList<Track>();
	    	tfTitle.setText("");
	    	tfCategory.setText("");
	    	tfCost.setText("");
	    	tfDirector.setText("");
	    	tfArtist.setText("");
		} catch (MediaConstructorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void btnBackToStorePressed(ActionEvent event) {
    	new StoreScreen(this.store, this.cart);
    }

    @FXML
    void menuItemAddBookClicked(ActionEvent event) {
    	new AddBookToStoreScreen(this.store, this.cart);
    }

    @FXML
    void menuItemAddDvdClicked(ActionEvent event) {
    	new AddDigitalVideoDiscToStoreScreen(this.store, this.cart);
    }

    @FXML
    void menuItemViewStoreClicked(ActionEvent event) {
    	new StoreScreen(this.store, this.cart);
    }

    @FXML
    void menuItemViewCartClicked(ActionEvent event) {
    	new CartScreen(this.cart, this.store);
    }
}
