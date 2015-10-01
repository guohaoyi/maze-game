import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Maze {
	
	public Object[][] maze = new Object[40][40];
	public int row, col, playerRow, playerCol;
	
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
					if (str.charAt(i) == 'W')
						maze[rowCount][i] = new Wall();
					else if (str.charAt(i) == 'G')
						maze[rowCount][i] = new Monster(100,4,2,0);
					else if (str.charAt(i) == 'U') {
						maze[rowCount][i] = new Player(100,5,2,0);
						playerRow = rowCount;
						playerCol = i;
					}
					else
						maze[rowCount][i] = new Empty();
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
	
	public void printMaze() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
	}
	
	public void printVisible() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (maze[i][j].getClass().getName().equals("Empty")) {
					if (((Empty)maze[i][j]).isVisible())
						System.out.print(maze[i][j]);
				}
				else if (maze[i][j].getClass().getName().equals("Wall")) {
					if (((Wall)maze[i][j]).isVisible())
						System.out.print(maze[i][j]);
					else
						System.out.print(" ");
				}
				else if (maze[i][j].getClass().getName().equals("Monster")) {
					if (((Monster)maze[i][j]).isVisible())
						System.out.print(maze[i][j]);
					else
						System.out.print(" ");
				}
				else if (maze[i][j].getClass().getName().equals("Player")) {
					if (((Player)maze[i][j]).isVisible())
						System.out.print(maze[i][j]);
					else
						System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public void printSideBySide() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (maze[i][j].getClass().getName().equals("Empty")) {
					if (((Empty)maze[i][j]).isVisible())
						System.out.print(maze[i][j]);
				}
				else if (maze[i][j].getClass().getName().equals("Wall")) {
					if (((Wall)maze[i][j]).isVisible())
						System.out.print(maze[i][j]);
					else
						System.out.print(" ");
				}
				else if (maze[i][j].getClass().getName().equals("Monster")) {
					if (((Monster)maze[i][j]).isVisible())
						System.out.print(maze[i][j]);
					else
						System.out.print(" ");
				}
				else if (maze[i][j].getClass().getName().equals("Player")) {
					if (((Player)maze[i][j]).isVisible())
						System.out.print(maze[i][j]);
					else
						System.out.print(" ");
				}
			}
			System.out.println(" | ");
			for (int k = 0; k < col; k++)
				System.out.println(maze[i][k]);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Maze maz = new Maze("map01.txt");
		maz.printMaze();
		maz.printVisible();

	}

}
