package hust.soict.dsai.aims;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Aims {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart anOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Star Wars",
				"Animation", 19.95f, "1/1/2021", "Roger Allers", 87);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", 24.95f, "1/1/2021", "George Lucas", 87);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f, "1/1/2021/", "Someone", 100);

		List<String> authors = new ArrayList<String>();
		authors.add("Dr.Nguyen Thieu Huy");
		Book b = new Book(1, "Lecture on Algebra", "Textbook", 10.0f, "1/1/2021", authors);
		
		DigitalVideoDisc[] dvdList = {dvd1, dvd2, dvd3};
		for (DigitalVideoDisc dvd : dvdList) {
			anOrder.addMedia(dvd);
		}

		
		System.out.println("Total Cost is: ");
		System.out.println(anOrder.totalCost());
		
		anOrder.removeMedia(dvd2);
		System.out.println("Total Cost after removing: ");
		System.out.println(anOrder.totalCost());
	}
}
