
public class DigitalVideoDisc {
	private String title;
	private String catogory;
	private String director;
	private int length;
	private float cost;
	public String getTitle() {
		return title;
	}
	public String getCatogory() {
		return catogory;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	public DigitalVideoDisc(String title, String catogory, String director, int length, float cost) {
		super();
		this.title = title;
		this.catogory = catogory;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String catogory, String director, float cost) {
		super();
		this.title = title;
		this.catogory = catogory;
		this.director = director;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String catogory, float cost) {
		super();
		this.title = title;
		this.catogory = catogory;
		this.cost = cost;
	}
}
