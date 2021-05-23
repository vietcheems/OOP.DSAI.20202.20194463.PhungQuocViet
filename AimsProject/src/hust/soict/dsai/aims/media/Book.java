package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.exception.EmptyInputException;
import hust.soict.dsai.aims.exception.NonPositiveCostException;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();

	public List<String> getAuthors() {
		return authors;
	}
	
	public boolean addAuthor(String authorName) throws Exception {
		int index = authors.indexOf(authorName);
		if (index == -1) {
			authors.add(authorName);
			System.out.println("Author added successfully");
			return true;
		}
		else {
			System.out.println(authorName + " is already an author of " + title);
			throw new Exception(authorName + " is already an author of " + title);
			
		}
	}
	
	public boolean removeAuthor(String authorName) throws Exception {
		int index = authors.indexOf(authorName);
		if (index == -1) {
			System.out.println(authorName + " is not an author of " + title);
			throw new Exception(authorName + " is not an author of " + title);
		}
		else {
			authors.remove(index);
			System.out.println("Author removed successfully");
			return true;
		}
	}
	
	public Book(String title, String category, float cost, String dateAdded, List<String> authors) throws NonPositiveCostException, EmptyInputException {
		super(title, category, cost, dateAdded);
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
