package hust.soict.dsai.aims.media;

import java.util.Comparator;

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

	public Media(String title, String category, float cost, String dateAdded) {
		this.id = ++idGiver;
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.dateAdded = dateAdded;
	}
	
	public abstract String toString();
	
	public boolean equals(Object obj) {
		if (obj instanceof Media) {
			Media new_obj = (Media) obj;
			return new_obj.title == title;
		}
		else {
			return false;
		}
	}
}
