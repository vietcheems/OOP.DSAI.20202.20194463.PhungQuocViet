package hust.soict.dsai.aims.media;

public abstract class Media {
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	protected String dataAdded;
	
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
		return dataAdded;
	}

	public Media(int id, String title, String category, float cost, String dataAdded) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.dataAdded = dataAdded;
	}

	

}
