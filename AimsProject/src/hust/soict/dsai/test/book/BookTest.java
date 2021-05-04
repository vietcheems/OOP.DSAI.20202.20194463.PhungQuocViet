package hust.soict.dsai.test.book;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Book;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> authors = new ArrayList<String>();
		authors.add("Dr.Nguyen Thieu Huy");
		Book book = new Book(1, "Lecture on Algebra", "Textbook", 10.0f, authors);
	}

}
//List<String> authors = new ArrayList<String>() {{add("Dr.Nguyen Thieu Huy")}}