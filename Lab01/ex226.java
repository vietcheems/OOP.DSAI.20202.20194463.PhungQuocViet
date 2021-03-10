import java.util.Scanner;
public class ex226 {
	public static void main(String[] args) {
		System.out.println("Select which type of equation you want to perform");
		System.out.println("1 for linear equation with one variable");
		System.out.println("2 for second degree equation with one variable");
		System.out.println("3 for system of linear equations with one variable");
		System.out.print("Enter your desired type here: ");
		Scanner sc = new Scanner(System.in);
		int type = sc.nextInt();
		if (type == 1) {
			System.out.println("Solver for ax + b = 0");
			System.out.print("Enter a: ");
			double a = sc.nextDouble();
			System.out.print("Enter b: ");
			double b = sc.nextDouble();
			if (a == 0) {
				if (b == 0) {
					System.out.println("Infitely many solution");
				}
				else {
					System.out.println("No solution");
				}
			}
			else {
				System.out.println("x = " + (- b / a));
			}
		}
		else if (type == 2) {
			System.out.println("Solver for ax^2 + bx + c = 0");
			System.out.print("Enter a: ");
			double a = sc.nextDouble();
			System.out.print("Enter b: ");
			double b = sc.nextDouble();
			System.out.print("Enter c: ");
			double c = sc.nextDouble();
			if (a == 0) {
				if (b == 0) {
					if (c == 0) {
						System.out.println("Infitely many solutions");
					}
					else {
						System.out.println("No solution");
					}
				}
				else {
					System.out.println("x = " + (- c / b));
				}
			}
			else {
				double delta = Math.pow(b, 2) - 4 * a * c;
				if (delta < 0) {
					System.out.println("No real solution");
				}
				else if (delta == 0) {
					System.out.println("x = " + -b / 2 / a);
				}
				else {
					System.out.println("x1 = " + ((-b + Math.sqrt(delta)) / 2 / a));
					System.out.println("x2 = " + ((-b - Math.sqrt(delta)) / 2 / a));
				}
			}

			

		}
		else if (type == 3) {
			System.out.println("Solver for a1x + b1y = c1 and a2x + b2y = c2");
			System.out.print("Enter a1: ");
			double a1 = sc.nextDouble();
			System.out.print("Enter b1: ");
			double b1 = sc.nextDouble();
			System.out.print("Enter c1: ");
			double c1 = sc.nextDouble();
			System.out.print("Enter a2: ");
			double a2 = sc.nextDouble();
			System.out.print("Enter b2: ");
			double b2 = sc.nextDouble();
			System.out.print("Enter c2: ");
			double c2 = sc.nextDouble();
			double D = a1 * b2 - a2 * b1;
			double Dx = c1 * b2 - c2 * b1;
			double Dy = a1 * c2 - a2 * c1;
			if (D == 0) {
				if ((Dx == 0) && (Dy == 0)) {
					System.out.println("Infinitely many solutions");
				}
				else {
					System.out.println("No solution");
				}
			}
			else {
				System.out.println("x = " + Dx / D);
				System.out.println("y = " + Dy / D);
			}
		}
		else {
			System.out.println("Invalid type");
		}
		sc.close();
	}

}
