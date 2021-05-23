package hust.soict.dsai.aims.media;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hust.soict.dsai.aims.exception.EmptyInputException;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.exception.TrackPlayException;

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

	public Track(String title, int length) throws EmptyInputException {
		if (title.isBlank()) throw new EmptyInputException("Track title cannot be empty");
		this.title = title;
		this.length = length;
	}
	public void play() throws TrackPlayException {
		if (this.getLength() > 0) {
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, "Playing Track: " + this.getTitle() + "\n" + "Track length: " + this.getLength(), "Playing Track", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Playing track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
		}
		else {
			throw new TrackPlayException("ERROR: Track length is non-positive");
		}
	}
	public boolean equals(Object obj) {
		if (obj instanceof Track) {
			Track new_obj = (Track) obj;
			return (new_obj.title == title && new_obj.length == length); 
		}
		else return false;
	}
}
