package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book {
	 private int id;
	 private String title;
	 private String category;
	 private float cost;
	 private List<String> authors = new ArrayList<String>();
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}
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
	public Book(int id, String title, String category, float cost, List<String> authors) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.authors = authors;
	}
	
}
