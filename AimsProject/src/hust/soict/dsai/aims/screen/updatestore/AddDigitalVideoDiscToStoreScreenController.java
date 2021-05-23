package hust.soict.dsai.aims.screen.updatestore;

import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.naming.LimitExceededException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.EmptyInputException;
import hust.soict.dsai.aims.exception.NonPositiveCostException;
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
		try {
        	String title = tfTitle.getText();
        	String category = tfCategory.getText();
        	if (tfCost.getText().isBlank()) throw new NumberFormatException("Cost cannot be empty");
        	Float cost = Float.valueOf(tfCost.getText());
        	String dateAdded = String.valueOf(java.time.LocalDateTime.now());
        	String director = tfDirector.getText();
        	if (tfLength.getText().isBlank()) throw new NumberFormatException("Length cannot be empty");
        	Integer length = Integer.valueOf(tfLength.getText());
	    	DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost, dateAdded, director, length);
	    	this.store.addMedia(dvd);
	    	JOptionPane.showMessageDialog(null, "DVD added successfully");
	    	tfTitle.setText("");
	    	tfCategory.setText("");
	    	tfCost.setText("");
	    	tfDirector.setText("");
	    	tfLength.setText("");
		} catch (NonPositiveCostException | EmptyInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
		} catch (LimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
		}

    }
    
    @FXML
    void menuItemAddBookClicked(ActionEvent event) {
    	new AddBookToStoreScreen(this.store, this.cart);
		JFrame f = (JFrame) SwingUtilities.getWindowAncestor(AddDigitalVideoDiscToStoreScreen.fxPanel);
		f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
    }
   
    @FXML
    void btnBackToStorePressed(ActionEvent event) {
    	new StoreScreen(this.store, this.cart);
		JFrame f = (JFrame) SwingUtilities.getWindowAncestor(AddDigitalVideoDiscToStoreScreen.fxPanel);
		f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
    }

    @FXML
    void menuItemAddCdClicked(ActionEvent event) {
    	new AddCompactDiscToStoreScreen(this.store, this.cart);
		JFrame f = (JFrame) SwingUtilities.getWindowAncestor(AddDigitalVideoDiscToStoreScreen.fxPanel);
		f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
    }

    @FXML
    void menuItemViewStoreClicked(ActionEvent event) {
    	new StoreScreen(this.store, this.cart);
		JFrame f = (JFrame) SwingUtilities.getWindowAncestor(AddDigitalVideoDiscToStoreScreen.fxPanel);
		f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
    }

    @FXML
    void menuItemViewCartClicked(ActionEvent event) {
    	new CartScreen(this.cart, this.store);
		JFrame f = (JFrame) SwingUtilities.getWindowAncestor(AddDigitalVideoDiscToStoreScreen.fxPanel);
		f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
    }

}
