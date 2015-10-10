import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MazeGenerator {
	
	public int monsterNum, treasureNum, weaponNum;
	public char[] monsterInitials = new char[26];
	public char[] treasureInitials = new char[26];
	public char[] weaponInitials = new char[26];
	
	public MazeGenerator() throws IOException {
		readMonster();
		readTreasure();
		//char[][] maze = generate();
		//floodFill(maze);
		String[] fileNames = {"bin//map01.txt", "bin//map02.txt", "bin//map03.txt"};
		for (int mazeNum = 0; mazeNum < 3; mazeNum++) {
			char[][] maze = generate();
			while (floodFill(maze) != true)
				maze = generate();
			for (int i = 0; i < 40; i++) {
				for (int j = 0; j < 40; j++) {
					System.out.print(maze[i][j]);
				}
				System.out.println();
			}
			FileWriter fout = new FileWriter(fileNames[mazeNum]);
			char[] cbuf = new char[40];
			for (int i = 0; i < 40; i++) {
				for (int j = 0; j < 40; j++) {
					cbuf[j] = maze[i][j];
				}
				fout.write(cbuf);
				fout.write("\n");
			}
			fout.close();
		}
	}
	
	public char[][] generate() {
		char[][] maze = new char[40][40];
		for (int i = 0; i < 40; i++) {
			for (int j = 0; j < 40; j++) {
				maze[i][j] = 'W';
			}
		}
		Random ran = new Random();
		for (int o = 0; o < 1400; o++)
			maze[ran.nextInt(38) + 1][ran.nextInt(38) + 1] = ' ';
		maze[1][1] = 'U';
		maze[ran.nextInt(38) + 1][ran.nextInt(38) + 1] = 'E';
		for (int m = 0; m < monsterNum; m++)
			maze[ran.nextInt(38) + 1][ran.nextInt(38) + 1] = monsterInitials[m];
		for (int n = 0; n < treasureNum; n++)
			maze[ran.nextInt(38) + 1][ran.nextInt(38) + 1] = treasureInitials[n];
		for (int o = 0; o < weaponNum; o++)
			maze[ran.nextInt(38) + 1][ran.nextInt(38) + 1] = weaponInitials[o];
		return maze;
	}
	
	public boolean floodFill(char[][] maze) {
		boolean path = false;
		boolean[][] mark = new boolean[40][40];
		int exitRow = 0;
		int exitCol = 0;
		for (int i = 1; i < 39; i++) {
			for (int j = 1; j < 39; j++) {
				char c = maze[i][j];
				if (c != 'W') {
					mark[i][j] = true;
					int times = 4;
					if (maze[i+1][j] != 'W') {
						mark[i+1][j] = true;
						times--;
					}
					if (maze[i-1][j] != 'W') {
						mark[i+1][j] = true;
						times--;
					}
					if (maze[i][j+1] != 'W') {
						mark[i+1][j] = true;
						times--;
					}
					if (maze[i][j-1] != 'W') {
						mark[i][j-1] = true;
						times--;
					}
					if (times == 4) {
						break;
					}
				}
				if (c == 'E') {
					exitRow = i;
					exitCol = j;
				}
			}
		}
		if ((mark[1][1] == true) && (mark[exitRow][exitCol] == true))
			path = true;
		//System.out.println(path);
		return path;
	}
	
	public void readMonster() {
		try {
			FileReader fin = new FileReader("bin//monsters.txt");
			Scanner scan = new Scanner(fin);
			int index = 0;
			while (scan.hasNext()) {
				String name = scan.nextLine();
				char initial = name.charAt(0);
				monsterInitials[index] = initial;
				scan.nextInt();
				scan.nextInt();
				scan.nextInt();
				scan.nextInt();
				scan.nextInt();
				scan.nextInt();
				index++;
				monsterNum = index;
				scan.nextLine();
			}
			scan.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: " + e.getMessage());
		}
	}
	
	public void readTreasure() {
		try {
			FileReader fin = new FileReader("bin//treasures.txt");
			Scanner scan = new Scanner(fin);
			int treasureIndex = 0;
			int weaponIndex = 0;
			while (scan.hasNext()) {
				String type = scan.nextLine();
				String name = scan.nextLine();
				scan.nextInt();
				scan.nextInt();
				scan.nextInt();
				scan.nextInt();
				scan.nextInt();
				if (type.equals("Weapon")) {
					char initial = name.charAt(0);
					weaponInitials[weaponIndex] = initial;
					weaponIndex++;
				}
				else {
					char initial = name.charAt(0);
					treasureInitials[treasureIndex] = initial;
					treasureIndex++;
				}
				scan.nextLine();
			}
			treasureNum = treasureIndex;
			weaponNum = weaponIndex;
			scan.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: " + e.getMessage());
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new MazeGenerator();

	}

}
