package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.Collections;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	public float totalCost() {
		float sum = 0f;
		for (Media itemOrdered : itemsOrdered) {
			sum += itemOrdered.getCost();
		}
	return sum;
	}
	
	public void printList() {
		System.out.println("**********CART**********");
		System.out.println("Ordered Items:");
		for (Media itemOrdered : itemsOrdered) {
			System.out.println(itemOrdered.toString());
		}
		System.out.println("Total cost: " + String.valueOf(totalCost()));
		System.out.println("************************");
	}
	
	public boolean searchByID(int id) {
		for (Media itemOrdered : itemsOrdered) {
			if (itemOrdered.getId() == id) {
				System.out.println(itemOrdered.toString());
				return true;
			}
		}
		System.out.println("Could not find the item with matching id");
		return false;
	}
	
	public boolean searchByTitle(String title) {
		boolean found = false;
		for (Media itemOrdered : itemsOrdered) {
			if (itemOrdered.getTitle().equals(title)) {
				System.out.println(itemOrdered.toString());
				found = true;
			}
		}
		if (found == false) {
			System.out.println("Could not find the item with matching title");
		}
		return found;
	}
	
	public boolean addMedia(Media item) {
		if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full");
			return false;
		}
		else {
			int index = itemsOrdered.indexOf(item);
			if (index == -1) {
				itemsOrdered.add(item);
				System.out.println("Added successfully");
				return true;
			}
			else {
				System.out.println("Item already in the cart");
				return false;
			}
		}
	}
	
	public boolean removeMedia(Media item) {
		int index = itemsOrdered.indexOf(item);
		if (index == -1) {
			System.out.println("Item is not in the cart");
			return false;
		}
		else {
			itemsOrdered.remove(index);
			System.out.println("Item removed successfully");
			return true;
		}
	}
	
	public void sortByTitleCost() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}
	
	public void sortByCostTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}
	
	public Media getMediaByTitle(String title) {
		Media found = null;
		for (Media item : itemsOrdered) {
			if (item.getTitle().equals(title)) {
				found = item;
			}
		}
		return found;
	}
	
	public Media getMediaById(int id) {
		Media found = null;
		for (Media item : itemsOrdered) {
			if (item.getId() == id) {
				found = item;
			}
		}
		return found;
	}
	
	public void emptyCart() {
		this.itemsOrdered.clear();
	}

	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}


}
