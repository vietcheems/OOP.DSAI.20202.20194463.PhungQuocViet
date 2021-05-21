package hust.soict.dsai.aims.screen.updatestore;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.cart.CartScreen;
import hust.soict.dsai.aims.screen.store.StoreScreen;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class AddDigitalVideoDiscToStoreScreenController {
	private Store store;
	private Cart cart;
	
    @FXML
    private TextField tfCost;

    @FXML
    private Button btnAddToStore;

    @FXML
    private TextField tfTitle;

    @FXML
    private Button btnBackToStore;

    @FXML
    private MenuItem menuItemAddBook;

    @FXML
    private TextField tfCategory;

    @FXML
    private MenuItem menuItemAddCd;

    @FXML
    private MenuItem menuItemViewStore;

    @FXML
    private MenuItem menuItemViewCart;

    @FXML
    private TextField tfDirector;

    @FXML
    private TextField tfLength;
    
    public AddDigitalVideoDiscToStoreScreenController(Store store, Cart cart) {
    	this.store = store;
    	this.cart = cart;
    }

    @FXML
    void btnAddToStorePressed(ActionEvent event) {
    	String title = tfTitle.getText();
    	String category = tfCategory.getText();
    	Float cost = Float.valueOf(tfCost.getText());
    	String dateAdded = String.valueOf(java.time.LocalDateTime.now());
    	String director = tfDirector.getText();
    	Integer length = Integer.valueOf(tfLength.getText());
    	DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost, dateAdded, director, length);
    	this.store.addMedia(dvd);
    	JOptionPane.showMessageDialog(null, "DVD added successfully");
    	
    	tfTitle.setText("");
    	tfCategory.setText("");
    	tfCost.setText("");
    	tfDirector.setText("");
    	tfLength.setText("");
    }
    
    @FXML
    void menuItemAddBookClicked(ActionEvent event) {
    	new AddBookToStoreScreen(this.store, this.cart);
    }
   
    @FXML
    void btnBackToStorePressed(ActionEvent event) {
    	new StoreScreen(this.store, this.cart);
    }

    @FXML
    void menuItemAddCdClicked(ActionEvent event) {
    	new AddCompactDiscToStoreScreen(this.store, this.cart);
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
