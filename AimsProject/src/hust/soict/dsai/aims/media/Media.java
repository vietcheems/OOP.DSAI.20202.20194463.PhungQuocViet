package hust.soict.dsai.aims.media;

import java.util.Comparator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hust.soict.dsai.aims.exception.MediaConstructorException;
import hust.soict.dsai.aims.media.comparator.MediaComparatorByCostTitle;
import hust.soict.dsai.aims.media.comparator.MediaComparatorByTitleCost;

public abstract class Media {
	private static int idGiver = 0;
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	protected String dateAdded; //format: dd/mm/yyyy
	public static final Comparator<Media> COMPARE_BY_TITLE_COST =
			new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE =
			new MediaComparatorByCostTitle();
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	public String getDataAdded() {
		return dateAdded;
	}

	public Media(String title, String category, float cost, String dateAdded) throws MediaConstructorException {
		if (cost <= 0) throw new MediaConstructorException("Cost can be non-positive");
		this.id = ++idGiver;
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.dateAdded = dateAdded;
	}
	
	public abstract String toString();
	
	public boolean equals(Object obj){
		if (obj == null) {
			throw new NullPointerException("Media is null");
		}
		
		try {	
			Media new_obj = (Media) obj;
			return new_obj.title == title;
		}
		catch (ClassCastException e){
			e.printStackTrace();
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, "Cannot cast to media", "Error", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		catch (NullPointerException e) {
			e.printStackTrace();
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, "Argument is null", "Error", JOptionPane.WARNING_MESSAGE);
			return false;
		}
	}

}
