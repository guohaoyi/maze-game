import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Maze {
	
	private static char[][] map = new char[40][40];
	private static int row, col;
	
	public Maze(String fileName) {
		try
		{
			FileReader fin = new FileReader("bin//" + fileName);
			Scanner scan = new Scanner(fin);
			int rowCount = 0;
			while (scan.hasNext())
			{
				String str = scan.nextLine();
				col = str.length();
				int length = str.length() - 1;
				for (int i = 0; i <= length; i++)
				{
					map[rowCount][i] = str.charAt(i);
				}
				rowCount++;
			}
			row = rowCount;
			scan.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("FileNotFoundException: " + e.getMessage());
		}
	}
	
	public String toString() {
		String str = "";
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				str = str + map[i][j];
			}
			str = str + "\n";
		}
		str = str.substring(0, str.length() - 1);
		return str;
	}
	
	public void printMaze() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maze maz = new Maze("map01.txt");
		System.out.println(maz);
		//maz.printMaze();

	}

}
