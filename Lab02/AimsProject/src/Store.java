import java.util.*;
public class Store {
	public static final int STORAGE = 10000;
	private LinkedList<DigitalVideoDisc> itemsInStore =
			new LinkedList<DigitalVideoDisc>();
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (itemsInStore.size() == STORAGE) {
			System.out.println("The store is full!");
		}
		else {
			itemsInStore.add(disc);
			System.out.println("DVD added successfully");
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if (itemsInStore.contains(disc)) {
			itemsInStore.remove(disc);
			System.out.println("DVD removed successfully");
		}
		else {
			System.out.println("This DVD is not in the store");
		}
//		for (int i = 0; i < qtyInStore + 1; i ++) {
//			if (itemsInStore[i] == disc) {
//				itemsInStore[i] = null;
//				System.out.println("DVD removed successfully");
//				qtyInStore -= 1;
//				break;
//			}
//			if (i == qtyInStore) {
//				System.out.println("This DVD is not in the store");
//			}
//		}
	}
	
	public void printStore() {
		for (int i = 0; i < itemsInStore.size(); i++) { 
            System.out.println(itemsInStore.get(i).getDetail()); 
        } 
	}
}
