package hust.soict.dsai.garbage;

public class GarbageCreator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime, endTime;
		String str = "";
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i ++) {
			str += i;
		}
		endTime = System.currentTimeMillis();
		System.out.println("concatenation: " + (endTime - startTime));
	}

}
