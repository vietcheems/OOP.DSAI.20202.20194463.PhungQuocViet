import java.util.ArrayList;
import java.util.List;
import hust.soict.dsai.aims.media.*;

public class toStringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Media> mediaList = new ArrayList<Media>();
		
		List<String> authors = new ArrayList<String>();
		authors.add("Dr.Nguyen Thieu Huy");
		Book b = new Book(1, "Lecture on Algebra", "Textbook", 10.0f, "1/1/2021", authors);
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", 19.95f, "1/1/2021", "Roger Allers", 87);
		
		mediaList.add(dvd1);
		mediaList.add(b);
		
		for (Media m : mediaList)
			System.out.println(m.toString());
	}
}
