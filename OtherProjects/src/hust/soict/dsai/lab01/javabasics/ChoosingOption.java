package hust.soict.dsai.lab01.javabasics;
import javax.swing.JOptionPane;
public class ChoosingOption {
	public static void main(String[] args) {
		int option = JOptionPane.showConfirmDialog(null,
				"Do you want an A+ for this course?",
				":)",
				JOptionPane.YES_NO_OPTION);
		JOptionPane.showMessageDialog(null,
				(option==JOptionPane.YES_OPTION?"Of course you do":"Liar"));
		System.exit(0);
	}
}
