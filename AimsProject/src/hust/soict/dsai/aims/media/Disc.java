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
	
}
