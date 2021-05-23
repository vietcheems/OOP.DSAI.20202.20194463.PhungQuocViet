package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.EmptyInputException;
import hust.soict.dsai.aims.exception.NonPositiveCostException;

public class Disc extends Media{
	protected int length;
	protected String director;
	
	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}

	public Disc(String title, String category, float cost, String dataAdded, int length,
			String director) throws NonPositiveCostException, EmptyInputException {
		super(title, category, cost, dataAdded);
		if (director.isBlank()) throw new EmptyInputException("Director cannot be empty");
		this.length = length;
		this.director = director;
	}
	
	public String toString() {
		String str = String.valueOf(id) + ". Disc - " + title + " - " + category + " - " + director + " - " + String.valueOf(length) + ": " + String.valueOf(cost) + "$";
		return str;
	}
}
