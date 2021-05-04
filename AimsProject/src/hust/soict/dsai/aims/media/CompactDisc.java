package hust.soict.dsai.aims.media;

public class CompactDisc extends Media{
	private int length;
	private String director;
	
	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}

	public CompactDisc(int id, String title, String category, float cost, String dataAdded, int length, String director) {
		super(id, title, category, cost, dataAdded);
		this.length = length;
		this.director = director;
		// TODO Auto-generated constructor stub
	}

	

	
}
