package hust.soict.dsai.aims.media;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hust.soict.dsai.aims.exception.DigitalVideoDiscPlayException;
import hust.soict.dsai.aims.exception.EmptyInputException;
import hust.soict.dsai.aims.exception.NonPositiveCostException;
import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Media implements Playable {
	private String director;
	private int length;
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public DigitalVideoDisc(String title, String category, float cost, String dateAdded, String director,
			int length) throws NonPositiveCostException, EmptyInputException {
		super(title, category, cost, dateAdded);
		if (director.isBlank()) throw new EmptyInputException("Director cannot be empty");
		this.director = director;
		this.length = length;
	}
	public String toString() {
		String str = String.valueOf(id) + ". DVD - " + title + " - " + category + " - " + director + " - " + String.valueOf(length) + " - " + String.valueOf(cost) + "$";
		return str;
	}
	public void play() throws DigitalVideoDiscPlayException {
		if (this.getLength() > 0) {
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, "Playing DVD: " + this.getTitle() + "\n" + "DVD length: " + this.getLength(), "Playing DVD", JOptionPane.INFORMATION_MESSAGE);
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		}
		else {
			throw new DigitalVideoDiscPlayException("ERROR: DVD length is non-positive");
		}
	}
}
