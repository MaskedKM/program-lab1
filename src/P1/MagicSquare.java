package P1;

import java.io.*;
import java.util.*;

public class MagicSquare {
	boolean isLegalMagicSquare(String fileName) throws Exception {
		File file = new File(fileName);
		FileInputStream f1 = new FileInputStream(file);
		BufferedReader reader = new BufferedReader(new InputStreamReader(f1));
		List<List<String>> list = new ArrayList<>();
		String line = null;

		// 文件打开失败
		if (!file.exists()) {
			return false;
		}

		while ((line = reader.readLine()).length() != 0) {
			list.add(Arrays.asList(line.trim().split("\t")));
		}

		// 关闭文件
		reader.close();

		// 判断矩阵是否符合标准
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).size() != list.get(i + 1).size()) {
				return false;
			}
		}
		if (list.size() != list.get(0).size()) {
			return false;
		}

		// 构造定长数组
		int m = list.size();
		int[][] matrix = new int[m][m];
		int[] sum = new int[2 * m + 2];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				String temp = list.get(i).get(j);
				if (!temp.matches("[0-9]+")) {
					return false;
				}
				matrix[i][j] = Integer.parseInt(temp);
			}
		}

		// 判断是否为幻方
		for (int i = 0; i < m; i++) {
			sum[2 * m] = sum[2 * m] + matrix[i][i];
			sum[2 * m + 1] = sum[2 * m + 1] + matrix[m - i][i];
			for (int j = 0; j < m; j++) {
				sum[i] = sum[i] + matrix[i][j];
				sum[j + m] = sum[j + m] + matrix[i][j];
			}
		}

		for (int i = 0; i < 2 * m + 1; i++) {
			if (sum[i] != sum[i + 1]) {
				return false;
			}
		}

		return true;
	}

	public static boolean generateMagicSquare(int n) throws FileNotFoundException {
		//检测n是否合法
		if(n % 2 == 0 || n <0) {
			System.out.println("false");
			return false;
		}
		
		File f1 = new File("src/P1/txt/6.txt");
		if(!f1.exists()) {
			try {
				f1.createNewFile();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		FileOutputStream of1 = new FileOutputStream(f1);
		
		int magic[][] = new int[n][n];
		int row = 0, col = n / 2, i, j, square = n * n;
		String temp = null;
		for (i = 1; i <= square; i++) {
			magic[row][col] = i;
			if (i % n == 0)
				row++;
			else {
				if (row == 0)
					row = n - 1;
				else
					row--;
				if (col == (n - 1))
					col = 0;
				else
					col++;
			}
		}
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++)
				System.out.print(magic[i][j] + "\t");
			System.out.println();
			temp = String.valueOf(magic[i][j]) + "\t" + "\n";
			byte[] buff = temp.getBytes();
			try {
				of1.write(buff);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		try {
			of1.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return true;
	}
	
	void main(String[] args) {
		try {
			isLegalMagicSquare("src/txt/1.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
