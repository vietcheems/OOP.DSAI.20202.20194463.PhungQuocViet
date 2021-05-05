package hust.soict.dsai.aims.cart;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
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
			System.out.println(itemOrdered.getDetail());
		}
		System.out.println("Total cost: " + String.valueOf(totalCost()));
		System.out.println("************************");
	}
	
	public boolean searchByID(int id) {
		for (Media itemOrdered : itemsOrdered) {
			if (itemOrdered.getId() == id) {
				System.out.println(itemOrdered.getDetail());
				return true;
			}
		}
		System.out.println("Could not find the item with matching id");
		return false;
	}
	
	public boolean searchByTitle(String title) {
		boolean found = false;
		for (Media itemOrdered : itemsOrdered) {
			if (itemOrdered.getTitle() == title) {
				System.out.println(itemOrdered.getDetail());
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
	
}
