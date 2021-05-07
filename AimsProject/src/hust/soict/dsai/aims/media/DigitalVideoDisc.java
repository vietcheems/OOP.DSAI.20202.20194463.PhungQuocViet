package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Media implements Playable{
	private static int nbDigitalVideoDiscs = 0;
	private String director;
	private int length;
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public DigitalVideoDisc(String title, String category, float cost, String dateAdded, String director,
			int length) {
		super(++nbDigitalVideoDiscs, title, category, cost, dateAdded);
		this.director = director;
		this.length = length;
	}
	public String toString() {
		String str = String.valueOf(id) + ". DVD - " + title + " - " + category + " - " + director + " - " + String.valueOf(length) + " - " + String.valueOf(cost) + "$";
		return str;
	}
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}
