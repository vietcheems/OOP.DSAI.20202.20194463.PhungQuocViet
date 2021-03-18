import java.util.Scanner;
public class InputFromKeyboard {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Type whatever i don't care");
		String whatever = sc.nextLine();
		sc.close();
		System.out.println("Damn bro you typed " + whatever);
	}
}
