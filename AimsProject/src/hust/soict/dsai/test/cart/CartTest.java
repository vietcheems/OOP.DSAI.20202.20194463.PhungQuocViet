package hust.soict.dsai.test.cart;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", 19.99f, "1/1/2021", "Roger Allers", 87);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", 24.95f, "1/1/2021", "George Lucas", 87);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f, "1/1/2021/", "Someone", 100);

		List<String> authors = new ArrayList<String>();
		authors.add("Dr.Nguyen Thieu Huy");
		Book b = new Book(1, "Lecture on Algebra", "Textbook", 10.0f, "1/1/2021", authors);
		
		cart.addMedia(dvd1);
		cart.addMedia(dvd2);
		cart.addMedia(dvd3);
		cart.addMedia(b);
//		cart.removeMedia(dvd3);
//		cart.removeMedia(b);
		
		cart.sortByCostTitle();
		cart.printList();
		cart.sortByTitleCost();
		cart.printList();
		cart.searchByID(2);
		cart.searchByID(1000);
		cart.searchByTitle("Aladin");
		cart.searchByTitle("Lecture on Algebra");
		System.out.println(cart.totalCost());
	}
}
