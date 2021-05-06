package hust.soict.dsai.aims.media;

public class Track implements Playable{
	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	public void play() {
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}
	public boolean equals(Object obj) {
		if (obj instanceof Track) {
			Track new_obj = (Track) obj;
			return (new_obj.title == title && new_obj.length == length); 
		}
		else return false;
	}
}
