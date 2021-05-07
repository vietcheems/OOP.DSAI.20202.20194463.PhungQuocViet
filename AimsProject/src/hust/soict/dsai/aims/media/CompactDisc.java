package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	public CompactDisc(String title, String category, float cost, String dateAdded, int length, String director,
			String artist, ArrayList<Track> tracks) {
		super(title, category, cost, dateAdded, length, director);
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
	public void play() {
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("CD length: " + this.getLength());
		for (Track track : tracks) {
			track.play();
		}
	}
	public String toStringl() {
		String str = String.valueOf(id) + ". CD - " + title + " - " + category + " - " + director + " - " + String.valueOf(length) + " - " + String.valueOf(cost) + "$";
		return str;
	}
}
