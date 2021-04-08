package hust.soict.dsai.lab01.ex225and226;
import java.util.Scanner;
public class ex225 {
	public static void main(String[] args) {
		System.out.print("First number: ");
		Scanner sc = new Scanner(System.in);
		double num1 = sc.nextDouble();
		System.out.print("Second number: ");
		double num2 = sc.nextDouble();
		sc.close();
				
		String sum = String.valueOf(num1 + num2);
		System.out.println("Sum: " + sum);
		
		String difference = String.valueOf(Math.abs(num1 - num2));
		System.out.println("Difference: " + difference);
		
		if (num2 == 0) {
			System.out.println("Can't divide two numbers");
		}
		else {
			String quotient = String.valueOf(num1 / num2);
			System.out.println("Quotient: " + quotient);
		}
		
		String product = String.valueOf(num1 * num2);
		System.out.println("Product: " + product);
	}
}
