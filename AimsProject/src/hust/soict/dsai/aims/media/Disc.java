package hust.soict.dsai.aims.media;

public class Disc extends Media{
	protected int length;
	protected String director;
	
	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}

	public Disc(int id, String title, String category, float cost, String dataAdded, int length,
			String director) {
		super(id, title, category, cost, dataAdded);
		this.length = length;
		this.director = director;
	}
	
	public String getDetail() {
		String str = String.valueOf(id) + ". Disc - " + title + " - " + category + " - " + director + " - " + String.valueOf(length) + ": " + String.valueOf(cost) + "$";
		return str;
	}
}
