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
import hust.soict.dsai.aims.screen.cart.CartScreen;
import hust.soict.dsai.aims.screen.store.StoreScreen;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddBookToStoreScreenController {
	
	private Store store;
	private Cart cart;
	
    @FXML
    private TextField tfCost;

    @FXML
    private Button btnAddToStore;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfAuthor;
    
    @FXML
    private Button btnBackToStore;
    
    public AddBookToStoreScreenController(Store store, Cart cart) {
		// TODO Auto-generated constructor stub
    	this.store = store;
    	this.cart = cart;
	}
    
    @FXML
    void btnAddToStorePressed(ActionEvent event) {
    	try {
        	String title = tfTitle.getText();
        	String category = tfCategory.getText();
        	Float cost = Float.valueOf(tfCost.getText());
        	String dateAdded = String.valueOf(java.time.LocalDateTime.now());
        	if (tfAuthor.getText().length() == 0) throw new EmptyInputException("Authors cannot be empty");
        	List<String> authors = new ArrayList<String>();
        	for (String author:tfAuthor.getText().split(",")) {
        		if (author.trim().isEmpty()) throw new EmptyInputException("Author cannot be empty");
        		authors.add(author.trim());
        	}
        	Book b = new Book(title, category, cost, dateAdded, authors);
			this.store.addMedia(b);
	    	JOptionPane.showMessageDialog(null, "Book added successfully");
	    	tfTitle.setText("");
	    	tfCategory.setText("");
	    	tfCost.setText("");
	    	tfAuthor.setText("");
		} catch (LimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
		} catch (NonPositiveCostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
		} catch (EmptyInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, e.getMessage(), " Cost Error", JOptionPane.WARNING_MESSAGE);
		}

    }
    
    @FXML
    void btnBackToStorePressed(ActionEvent event) {
    	new StoreScreen(this.store, this.cart);
		JFrame f = (JFrame) SwingUtilities.getWindowAncestor(AddBookToStoreScreen.fxPanel);
		f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
    }
    
    @FXML
    void menuItemAddCdClicked(ActionEvent event) {
    	new AddCompactDiscToStoreScreen(this.store, this.cart);
		JFrame f = (JFrame) SwingUtilities.getWindowAncestor(AddBookToStoreScreen.fxPanel);
		f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
    }

    @FXML
    void menuItemAddDvdClicked(ActionEvent event) {
    	new AddDigitalVideoDiscToStoreScreen(this.store, this.cart);
		JFrame f = (JFrame) SwingUtilities.getWindowAncestor(AddBookToStoreScreen.fxPanel);
		f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
    }

    @FXML
    void menuItemViewStoreClicked(ActionEvent event) {
    	new StoreScreen(this.store, this.cart);
		JFrame f = (JFrame) SwingUtilities.getWindowAncestor(AddBookToStoreScreen.fxPanel);
		f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
    }

    @FXML
    void menuItemViewCartClicked(ActionEvent event) {
    	new CartScreen(this.cart, this.store);
		JFrame f = (JFrame) SwingUtilities.getWindowAncestor(AddBookToStoreScreen.fxPanel);
		f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
    }

}
