
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] =
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full");
		}
		else {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered += 1;
			System.out.println("The disc has been added");
		}
	}
	
//	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
//		if (MAX_NUMBERS_ORDERED - qtyOrdered < dvdList.length) {
//			System.out.println("Not enough space to add all the dvds in the list");
//		}
//		else {
//			for (int i = 0; i < dvdList.length; i ++) {
//				addDigitalVideoDisc(dvdList[i]);
//			}
//		}
//	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
		if (MAX_NUMBERS_ORDERED - qtyOrdered < dvdList.length) {
			System.out.println("Not enough space to add all the dvds in the list");
		}
		else {
			for (int i = 0; i < dvdList.length; i ++) {
				addDigitalVideoDisc(dvdList[i]);
				System.out.println("The discs has been added");
			}
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
		if (qtyOrdered + 1 == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full");
		}
		else {
			addDigitalVideoDisc(disc1);
			addDigitalVideoDisc(disc2);
			System.out.println("The discs has been added");
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < qtyOrdered; i ++) {
			if (itemsOrdered[i].equals(disc)) {
				itemsOrdered[i] = itemsOrdered[qtyOrdered - 1];
				itemsOrdered[qtyOrdered - 1] = null;
				qtyOrdered -= 1;
				System.out.println("The disc has been deleted");
				break;
			}
			if (i == qtyOrdered) {
				System.out.println("Could not find the disc");
			}
		}
	}
	
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
