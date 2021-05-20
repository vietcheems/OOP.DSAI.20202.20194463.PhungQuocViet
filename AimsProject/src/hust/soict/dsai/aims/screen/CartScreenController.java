package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	
	private Cart cart;
	private FilteredList<Media> filteredData;
	private boolean filterById = true;
	
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
	
	public CartScreenController(Cart cart) {
		super();
		this.cart = cart;
	}
	
	@FXML
	private void initialize() {
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
		cart.removeMedia(media);
	}
	
    @FXML
    void radioBtnFilterIdPressed(ActionEvent event) {
    	filterById = true;
    }

    @FXML
    void radioBtnFilterTitlePressed(ActionEvent event) {
    	filterById = false;
    }
}
