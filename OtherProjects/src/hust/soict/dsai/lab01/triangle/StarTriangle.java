package hust.soict.dsai.lab01.triangle;
import java.util.Scanner;

public class StarTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
