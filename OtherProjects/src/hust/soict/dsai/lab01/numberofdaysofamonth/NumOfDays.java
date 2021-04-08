package hust.soict.dsai.lab01.numberofdaysofamonth;
import java.util.Arrays;
import java.util.Scanner;

public class NumOfDays {
	public static boolean isInteger(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        int d = Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] jan = {"January", "Jan.", "Jan", "1"};
		String[] feb = {"February", "Feb.", "Feb", "2"};
		String[] mar = {"March", "Mar.", "Mar", "3"};
		String[] apr = {"April", "Apr.", "Apr", "4"};
		String[] may = {"May", "5"};
		String[] jun = {"June", "Jun", "6"};
		String[] jul = {"July", "Jul", "7"};
		String[] aug = {"August", "Aug.", "Aug", "8"};
		String[] sep = {"September", "Sept.", "Sep", "9"};
		String[] oct = {"October", "Oct.", "Oct", "10"};
		String[] nov = {"November", "Nov.", "Nov", "11"};
		String[] dec = { "December", "Dec.", "Dec", "12"};
		String year;
		String month;
		while (true) {
			System.out.print("Enter the year: ");
			year = sc.nextLine();
			if (isInteger(year) == false) {
				System.out.println("Invalid year, please enter again");
				continue;
			}
			break;
		}
		
		int num_year = Integer.parseInt(year);
		while (true) {
			System.out.print("Enter the month: ");
			month = sc.nextLine();
			if ((Arrays.asList(jan).contains(month)) ||
					(Arrays.asList(mar).contains(month)) ||
					(Arrays.asList(may).contains(month)) ||
					(Arrays.asList(jul).contains(month)) ||
					(Arrays.asList(aug).contains(month)) ||
					(Arrays.asList(oct).contains(month)) ||
					(Arrays.asList(dec).contains(month))) {			
				System.out.println("Number of days: " + 31);
				break;
			}
			else if ((Arrays.asList(apr).contains(month)) ||
					(Arrays.asList(jun).contains(month)) ||
					(Arrays.asList(sep).contains(month)) ||
					(Arrays.asList(nov).contains(month))) {
				System.out.println("Number of days: " + 30);
				break;
			}
			else if (Arrays.asList(feb).contains(month)) {
				if (num_year % 4 != 0) {
					System.out.println("Number of days: " + 28);
					break;
				}
				else if ((num_year % 400 != 0) && (num_year % 100 == 0)){
					System.out.println("Number of days: " + 28);
					break;
				}
				else {
					System.out.println("Number of days: " + 29);
					break;
				}
			}
			else {
				System.out.println("Invalid month, please enter again");
			}
			sc.close();
		}
	}
}
