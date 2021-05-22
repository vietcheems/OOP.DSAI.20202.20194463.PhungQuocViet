package hust.soict.dsai.aims.screen.cart;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.screen.store.StoreScreen;
import hust.soict.dsai.aims.screen.updatestore.AddBookToStoreScreen;
import hust.soict.dsai.aims.screen.updatestore.AddCompactDiscToStoreScreen;
import hust.soict.dsai.aims.screen.updatestore.AddDigitalVideoDiscToStoreScreen;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CartScreenController {
	
	private Store store;
	private Cart cart;
	private FilteredList<Media> filteredData;
	private boolean filterById;
	
	@FXML 
	private Button btnSortCart;
	
	@FXML
	private BorderPane borderPane;
	
	@FXML
	private Label totalCost;
	
	@FXML
	private Button btnPlaceOrder;
	
	@FXML
	private TextField tfFilter;
	
	@FXML
	private RadioButton radioBtnFilterId;
	
	@FXML
	private RadioButton radioBtnFilterTitle;
	
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
	@FXML
	private TableView<Media> tblMedia;
	
	@FXML
	private TableColumn<Media, String> colMediaTitle;
	
	@FXML
	private TableColumn<Media, String> colMediaCategory;
	
	@FXML
	private TableColumn<Media, Float> colMediaCost;
	
	@FXML
	private MenuItem menuItemViewStore;
	
	public CartScreenController(Cart cart, Store store) {
		super();
		this.cart = cart;
		this.store = store;
	}
	
	@FXML
	private void initialize() {
		totalCost.setText(String.valueOf(this.cart.totalCost()) + "$");
		colMediaTitle.setCellValueFactory(
				new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(
				new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(
				new PropertyValueFactory<Media, Float>("cost"));
		tblMedia.setItems(this.cart.getItemsOrdered());
		
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Media>() {
				
				@Override
				public void changed(ObservableValue<? extends Media> observable, Media oldValue,
						Media newValue) {
					if (newValue != null) {
						updateButtonBar(newValue);
					}
				}
			});
		
		tfFilter.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue,
					String newValue) {
				showFilteredMedia(newValue);
			}
		});
	}
	
	void showFilteredMedia(String inputString) {
		filteredData = new FilteredList<>(this.cart.getItemsOrdered());
		filteredData.setPredicate(media -> {
				if (filterById) {
					if (String.valueOf(media.getId()).indexOf(inputString) != -1) {
						return true;
					} else
						return false;
				}
				else {
					String filterString = inputString.toLowerCase();
					if (filterString == null || filterString.isBlank()) {
						return true;
					}
					else if (media.getTitle().toLowerCase().indexOf(filterString) != -1)
						return true;
					else return false;
				}
			});
		tblMedia.setItems(filteredData);
	}
	
	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if (media instanceof Playable) {
			btnPlay.setVisible(true);
		}
		else {
			btnPlay.setVisible(false);
		}
	}
	
	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		if (!this.cart.getItemsOrdered().isEmpty())
			try {
				cart.removeMedia(media);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JFrame f = new JFrame();
				JOptionPane.showMessageDialog(f, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
			}
			totalCost.setText(String.valueOf(cart.totalCost()) + "$");
	}
	
    @FXML
    void radioBtnFilterIdPressed(ActionEvent event) {
    	filterById = true;
    }

    @FXML
    void radioBtnFilterTitlePressed(ActionEvent event) {
    	filterById = false;
    }
    
    @FXML
    void btnPlayPressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
		if (media instanceof DigitalVideoDisc) {
			try {
				((DigitalVideoDisc) media).play();
			} catch (PlayerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (media instanceof CompactDisc) {
			try {
				((CompactDisc) media).play();
			} catch (PlayerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
    }
    
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
    	if (this.cart.getItemsOrdered().isEmpty()) {
    		System.out.println("Cart is empty");
    		JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, "Cart is empty", "Place Order", JOptionPane.INFORMATION_MESSAGE);
    	} else {
	    	this.cart.emptyCart();
	    	JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, "Order placed successfully", "Place Order", JOptionPane.INFORMATION_MESSAGE);
			totalCost.setText(String.valueOf(this.cart.totalCost()) + "$");
    	}
    }
    
    @FXML
    void menuItemViewStoreClicked(ActionEvent event) {
		new StoreScreen(this.store, this.cart);
    }
    

    @FXML
    void menuItemAddBookClicked(ActionEvent event) {
    	new AddBookToStoreScreen(this.store, this.cart);
    }

    @FXML
    void menuItemAddCdClicked(ActionEvent event) {
    	new AddCompactDiscToStoreScreen(this.store, this.cart);
    }

    @FXML
    void menuItemAddDvdClicked(ActionEvent event) {
    	new AddDigitalVideoDiscToStoreScreen(this.store, this.cart);
    }
    
    @FXML
    void btnSortCartPressed(ActionEvent event) {
    	this.cart.sortByTitleCost();
    }
}
