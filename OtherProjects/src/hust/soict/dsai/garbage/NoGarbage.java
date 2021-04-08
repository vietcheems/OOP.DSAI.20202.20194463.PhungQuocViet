package hust.soict.dsai.garbage;

public class NoGarbage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime, endTime;
		StringBuffer str_buffer = new StringBuffer("");
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i ++) {
			str_buffer.append(i);
		}
		endTime = System.currentTimeMillis();
		System.out.println("stringbuffer: " + (endTime - startTime));
	}
}
