import java.util.Arrays;

public class Sort {
	public static void main(String args[]) {
		int[] arr = {1,3,4,56,6,2,5,7,8,8,2};
		boolean done = false;
		int temp;
		while (!(done)) {
			done = true;
			for (int i = 0; i < (arr.length - 1); i ++) {
				if (arr[i] > arr[i + 1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					done = false;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
		
}
