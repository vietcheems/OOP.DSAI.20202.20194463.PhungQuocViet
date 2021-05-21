package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.MediaConstructorException;

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
			String director) throws MediaConstructorException {
		super(title, category, cost, dataAdded);
		this.length = length;
		this.director = director;
	}
	
	public String toString() {
		String str = String.valueOf(id) + ". Disc - " + title + " - " + category + " - " + director + " - " + String.valueOf(length) + ": " + String.valueOf(cost) + "$";
		return str;
	}
}
