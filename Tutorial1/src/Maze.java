import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Maze {
	
	private static char[][] map = new char[40][40];
	public static Object[][] realMaze = new Object[40][40];
	public static int row, col, playerRow, playerCol;
	
	public Maze(String fileName) {
		try {
			FileReader fin = new FileReader("bin//" + fileName);
			Scanner scan = new Scanner(fin);
			int rowCount = 0;
			while (scan.hasNext()) {
				String str = scan.nextLine();
				col = str.length();
				int length = str.length() - 1;
				for (int i = 0; i <= length; i++) {
					map[rowCount][i] = str.charAt(i);
				}
				rowCount++;
			}
			row = rowCount;
			scan.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: " + e.getMessage());
		}
	}
	
	public void realMaze() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j] == 'W')
					realMaze[i][j] = new Wall();
				else if (map[i][j] == 'G')
					realMaze[i][j] = new Monster(100,4,2,0);
				else if (map[i][j] == 'U') {
					realMaze[i][j] = new Player(100,5,2,0);
					playerRow = i;
					playerCol = j;
				}
				else
					realMaze[i][j] = new Empty();
			}
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
	
	public void printRealMaze() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(realMaze[i][j]);
			}
			System.out.println();
		}
	}
	
	public void printVisible() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (realMaze[i][j].getClass().getName().equals("Empty")) {
					if (((Empty)realMaze[i][j]).isVisible())
						System.out.print(realMaze[i][j]);
				}
				else if (realMaze[i][j].getClass().getName().equals("Wall")) {
					if (((Wall)realMaze[i][j]).isVisible())
						System.out.print(realMaze[i][j]);
					else
						System.out.print(" ");
				}
				else if (realMaze[i][j].getClass().getName().equals("Monster")) {
					if (((Monster)realMaze[i][j]).isVisible())
						System.out.print(realMaze[i][j]);
					else
						System.out.print(" ");
				}
				else if (realMaze[i][j].getClass().getName().equals("Player")) {
					if (((Player)realMaze[i][j]).isVisible())
						System.out.print(realMaze[i][j]);
					else
						System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Maze maz = new Maze("map01.txt");
		//System.out.println(maz);
		maz.realMaze();
		maz.printRealMaze();
		maz.printVisible();
	}

}
