package hust.soict.dsai.test.store;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store store = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", 19.95f, "1/1/2021", "Roger Allers", 87);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", 24.95f, "1/1/2021", "George Lucas", 87);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f, "1/1/2021/", "Someone", 100);
		
		List<String> authors = new ArrayList<String>();
		authors.add("Dr.Nguyen Thieu Huy");
		Book b = new Book("Lecture on Algebra", "Textbook", 10.0f, "1/1/2021", authors);
		
		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);
		store.addMedia(b);
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(str.equals("Aladin"));
		store.searchByTitle(str);
		store.searchByTitle("Aladin");

		
//		store.printStore();
//		store.removeMedia(dvd2);
//		store.printStore();
//		store.removeMedia(b);
//		store.printStore();
	}

}
