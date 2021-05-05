package hust.soict.dsai.test.cart;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", 19.95f, "1/1/2021", "Roger Allers", 87);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", 24.95f, "1/1/2021", "George Lucas", 87);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f, "1/1/2021/", "Someone", 100);
		
		cart.addDigitalVideoDisc(dvd1, dvd2, dvd3);
		
		cart.printList();
		cart.searchByID(2);
		cart.searchByID(1000);
		cart.searchByTitle("Aladin");
		cart.searchByTitle("i hate myself");
	}
}
