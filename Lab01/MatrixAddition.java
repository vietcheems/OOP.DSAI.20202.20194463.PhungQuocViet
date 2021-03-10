
public class MatrixAddition {
	public static void main(String args[]) {
		double m1[][] = {
				{1,2,3},
				{4,5,6},
				{7,8,9},
				{10,11,12}
				};
		double m2[][] = {
				{1,2,3},
				{4,5,6},
				{7,8,9},
				{10,11,12}
				};
		int row_num = m1.length;
		int col_num = m1[0].length;
		double[][] sum = new double[row_num][col_num];
		for (int row = 0;row < row_num; row ++) {
			for (int col = 0; col < col_num; col ++) {
				sum[row][col] = m1[row][col] + m2[row][col];
			}
		}
		for (int row = 0;row < row_num; row ++) {
			for (int col = 0; col < col_num; col ++) {
				System.out.print(sum[row][col] + "  ");
			}
			System.out.println();
		}
	}
}
