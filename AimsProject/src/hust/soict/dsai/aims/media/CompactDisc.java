package hust.soict.dsai.aims.media;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hust.soict.dsai.aims.exception.CompactDiscPlayException;
import hust.soict.dsai.aims.exception.EmptyInputException;
import hust.soict.dsai.aims.exception.NonPositiveCostException;
import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc(String title, String category, float cost, String dateAdded, int length, String director,
			String artist, ArrayList<Track> tracks) throws NonPositiveCostException, EmptyInputException {
		super(title, category, cost, dateAdded, length, director);
		if (artist.isBlank()) throw new EmptyInputException("Artist cannot be empty");
		this.artist = artist;
		this.tracks = tracks;
	}
	public String getArtist() {
		return artist;
	}
	public boolean addTrack(Track track) {
		int index = tracks.indexOf(track);
		if (index == -1) {
			tracks.add(track);
			System.out.println(track.getTitle() + " added successfully");
			return true;
		}
		else {
			System.out.println(track.getTitle() + " already in the CD");
			return false;
		}
	}
	public boolean removeTrack(Track track) {
		int index = tracks.indexOf(track);
		if (index == -1) {
			System.out.println(track.getTitle() + " is not in the CD");
			return false;
		}
		else {
			tracks.remove(index);
			System.out.println(track.getTitle() + "removed successfully");
			return true;
		}
	}
	public int getLength() {
		int sum = 0;
		for (Track track : tracks) {
			sum += track.getLength();
		}
		return sum;
	}
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, "Playing CD: " + this.getTitle() + "\n" + "CD length: " + this.getLength(), "Playing CD", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Playing CD: " + this.getTitle());
			System.out.println("CD length: " + this.getLength());
			for (Track track : tracks) {
				try {
					track.play();
				} catch(PlayerException e) {
					throw e;
				}
			}
		} else {
			throw new CompactDiscPlayException("ERROR: CD length is non-positive");
		}
	}
	public String toStringl() {
		String str = String.valueOf(id) + ". CD - " + title + " - " + category + " - " + director + " - " + String.valueOf(length) + " - " + String.valueOf(cost) + "$";
		return str;
	}
}
