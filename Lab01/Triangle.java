import java.util.Scanner;
public class Triangle {
	public static void main(String args[]) {
		System.out.print("Enter the height of the triangle: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < (n - 1 - i); j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < (1 + 2 * i); k++) {
				System.out.print("*");
			}
		System.out.println();
		}
	}
}
