package hust.soict.dsai.aims.media.comparator;
import java.util.Comparator;
import hust.soict.dsai.aims.media.*;

public class MediaComparatorByTitleCost implements Comparator<Media>{

	@Override
	public int compare(Media o1, Media o2) {
		// TODO Auto-generated method stub
		int result = o1.getTitle().compareToIgnoreCase(o2.getTitle());
		if (result < 0) return -1;
		else if (result > 0 ) return 1;
		else return o1.getCost() < o2.getCost() ? -1 : o1.getCost() == o2.getCost() ? 0 : 1;
	}

}
