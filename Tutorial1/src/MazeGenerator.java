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
		String[] fileNames = {"bin//map01.txt", "bin//map02.txt", "bin//map03.txt"};
		for (int mazeNum = 0; mazeNum < 3; mazeNum++) {
			char[][] maze = generate();
			while (!floodFill(maze))
				maze = generate();
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
		for (int k = 0; k < 1600; k++)
			maze[ran.nextInt(38) + 1][ran.nextInt(38) + 1] = ' ';
		maze[1][1] = 'U';
		maze[ran.nextInt(38) + 1][ran.nextInt(38) + 1] = 'E';
		for (int l = 0; l < monsterNum; l++)
			maze[ran.nextInt(38) + 1][ran.nextInt(38) + 1] = monsterInitials[l];
		for (int m = 0; m < treasureNum; m++)
			maze[ran.nextInt(38) + 1][ran.nextInt(38) + 1] = treasureInitials[m];
		for (int n = 0; n < weaponNum; n++)
			maze[ran.nextInt(38) + 1][ran.nextInt(38) + 1] = weaponInitials[n];
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
					if (maze[i-1][j] != 'W')
						mark[i-1][j] = true;
					if (maze[i+1][j] != 'W')
						mark[i+1][j] = true;
					if (maze[i][j+1] != 'W')
						mark[i][j+1] = true;
					if (maze[i][j-1] != 'W')
						mark[i][j-1] = true;
				}
				if (c == 'E') {
					exitRow = i;
					exitCol = j;
				}
			}
		}
		if ((mark[1][1] == true) && (mark[exitRow][exitCol] == true))
			path = true;
		
		for (int i = 1; i < 39; i++) {
			for (int j = 1; j < 39; j++) {
				if((mark[i-1][j]) || (mark[i+1][j]) || (mark[i][j+1]) || (mark[i][j-1]))
					path = true;
				else {
					path = false;
					break;
				}
			}
		}

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
