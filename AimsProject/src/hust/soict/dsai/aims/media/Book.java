package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();

	public List<String> getAuthors() {
		return authors;
	}
	
	public boolean addAuthor(String authorName) {
		int index = authors.indexOf(authorName);
		if (index == -1) {
			authors.add(authorName);
			System.out.println("Author added successfully");
			return true;
		}
		else {
			System.out.println(authorName + " is already an author of " + title);
			return false;
		}
	}
	public boolean removeAuthor(String authorName) {
		int index = authors.indexOf(authorName);
		if (index == -1) {
			System.out.println(authorName + " is not an author of " + title);
			return false;
		}
		else {
			authors.remove(index);
			System.out.println("Author removed successfully");
			return true;
		}
	}
	public Book(int id, String title, String category, float cost, String dataAdded, List<String> authors) {
		super(id, title, category, cost, dataAdded);
		this.authors = authors;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String authorsList = String.join(", ", authors);
		String str = String.valueOf(id) + ". Book - " + title + " - " + category + " - " + authorsList + " - " + String.valueOf(cost) + "$";
		return str;
	}
}
