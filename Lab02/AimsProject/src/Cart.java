
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
			}
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
}
