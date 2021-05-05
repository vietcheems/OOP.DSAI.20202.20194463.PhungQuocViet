package hust.soict.dsai.aims.store;
import java.util.*;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
public class Store {
	public static final int STORAGE = 10000;
	private ArrayList<Media> itemsInStore =
			new ArrayList<Media>();
	public boolean addMedia(Media item) {
		if (itemsInStore.size() == STORAGE) {
			System.out.println("The store is full!");
			return false;
		}
		else {
			itemsInStore.add(item);
			System.out.println("Item added successfully");
			return true;
		}
	}
	
	public boolean removeMedia(Media item) {
		if (itemsInStore.contains(item)) {
			itemsInStore.remove(item);
			System.out.println("Item removed successfully");
			return true;
		}
		else {
			System.out.println("Item is not in the store");
			return false;
		}
	}
	
	public void printStore() {
		for (int i = 0; i < itemsInStore.size(); i++) { 
            System.out.println(itemsInStore.get(i).getDetail()); 
        } 
	}
}
