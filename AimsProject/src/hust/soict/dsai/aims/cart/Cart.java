package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private int qtyOrdered = 0;
	
	public float totalCost() {
		float sum = 0f;
		for (int i = 0; i < qtyOrdered; i ++) {
			sum += itemsOrdered[i].getCost();
		}
	return sum;
	}
	
	public void printList() {
		System.out.println("**********CART**********");
		System.out.println("Ordered Items:");
		for (int i = 0; i < qtyOrdered; i ++) {
			System.out.println(itemsOrdered[i].getDetail());
		}
		System.out.println("Total cost: " + String.valueOf(totalCost()));
		System.out.println("************************");
	}
	
	public boolean searchByID(int id) {
		for (int i = 0; i < qtyOrdered; i ++) {
			if (itemsOrdered[i].getId() == id) {
				System.out.println(itemsOrdered[i].getDetail());
				return true;
			}
			if (i == qtyOrdered - 1) {
				System.out.println("Could not find the dvd with matching id");
			}
		}
		return false;
	}
	
	public boolean searchByTitle(String title) {
		boolean found = false;
		for (int i = 0; i < qtyOrdered; i ++) {
			if (itemsOrdered[i].getTitle() == title) {
				System.out.println(itemsOrdered[i].getDetail());
				found = true;
			}
			if ((i == qtyOrdered - 1) && (found == false)) {
				System.out.println("Could not find the dvd with matching title");
			}
		}
		return found;
	}
}
