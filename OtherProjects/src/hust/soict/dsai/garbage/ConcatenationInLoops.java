package hust.soict.dsai.garbage;

public class ConcatenationInLoops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime, endTime;
		String str = "";
		StringBuffer str_buffer = new StringBuffer("");
		StringBuilder str_builder = new StringBuilder("");
		
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 30000; i ++) {
			str += i;
		}
		endTime = System.currentTimeMillis();
		System.out.println("concatenation: " + (endTime - startTime));
		
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 30000; i ++) {
			str_buffer.append(i);
		}
		endTime = System.currentTimeMillis();
		System.out.println("stringbuffer: " + (endTime - startTime));
		
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 30000; i ++) {
			str_builder.append(i);
		}
		endTime = System.currentTimeMillis();
		System.out.println("stringbuilder: " + (endTime - startTime));
	}
}
