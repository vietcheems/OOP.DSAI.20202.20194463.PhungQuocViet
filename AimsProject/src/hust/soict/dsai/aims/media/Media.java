package hust.soict.dsai.aims.media;

public abstract class Media {
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	protected String dateAdded; //format: dd/mm/yyyy

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

	public Media(int id, String title, String category, float cost, String dateAdded) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.dateAdded = dateAdded;
	}

	
	

}
