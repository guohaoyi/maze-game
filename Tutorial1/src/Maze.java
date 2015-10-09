import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Maze {
	
	public Object[][] maze = new Object[40][40];
	public int row, col, playerRow, playerCol, exitRow, exitCol, monsterNum, treasureNum, weaponNum;
	public Monster[] monsters = new Monster[26];
	public char[] monsterInitials = new char[26];
	public Treasure[] treasures = new Treasure[26];
	public char[] treasureInitials = new char[26];
	public Weapon[] weapons = new Weapon[26];
	public char[] weaponInitials = new char[26];
	
	public Maze(String fileName) {
		readMonster();
		readTreasure();
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
					else if (str.charAt(i) == 'U') {
						readPlayer(rowCount, i);
						playerRow = rowCount;
						playerCol = i;
					}
					else if (str.charAt(i) == 'E') {
						exitRow = rowCount;
						exitCol = i;
						maze[rowCount][i] = new Empty();
					}
					else {
						for (int j = 0; j < monsterNum; j++) {
							char cm = monsterInitials[j];
							if (str.charAt(i) == cm) {
								Monster m = monsters[j];
								maze[rowCount][i] = m;
							}
						}
						for (int k = 0; k < treasureNum; k++) {
							char ct = treasureInitials[k];
							if (str.charAt(i) == ct) {
								Treasure t = treasures[k];
								maze[rowCount][i] = t;
							}
						}
						for (int l = 0; l < weaponNum; l++) {
							char cw = weaponInitials[l];
							if (str.charAt(i) == cw) {
									Weapon w = weapons[l];
								maze[rowCount][i] = w;
							}
						}
						if (maze[rowCount][i] == null)
							maze[rowCount][i] = new Empty();
					}
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
	
	public void readPlayer(int row, int col) {
		try {
			FileReader fin = new FileReader("bin//player.txt");
			Scanner scan = new Scanner(fin);
			int health = scan.nextInt();
			int attack = scan.nextInt();
			int defense = scan.nextInt();
			int damage = scan.nextInt();
			maze[row][col] = new Player(health, attack, defense, damage);
			scan.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: " + e.getMessage());
		}
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
				int health = scan.nextInt();
				int attack = scan.nextInt();
				int defense = scan.nextInt();
				int damage = scan.nextInt();
				int potion = scan.nextInt();
				int gold = scan.nextInt();
				monsters[index] = new Monster(name, health, attack, defense, damage, potion, gold);
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
				int value = scan.nextInt();
				int healthRestoration = scan.nextInt();
				int attackBonus = scan.nextInt();
				int damageBonus = scan.nextInt();
				int probability = scan.nextInt();
				if (type.equals("Weapon")) {
					weapons[weaponIndex] = new Weapon(type, name, value, healthRestoration, attackBonus, damageBonus, probability);
					char initial = name.charAt(0);
					weaponInitials[weaponIndex] = initial;
					weaponIndex++;
				}
				else {
					treasures[treasureIndex] = new Treasure(type, name, value, healthRestoration, attackBonus, damageBonus, probability);
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
	
	public void printMaze() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(maze[i][j]);
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
				else if (maze[i][j].getClass().getName().equals("Treasure")) {
					if (((Treasure)maze[i][j]).isVisible())
						System.out.print(maze[i][j]);
					else
						System.out.print(" ");
				}
				else if (maze[i][j].getClass().getName().equals("Weapon")) {
					if (((Weapon)maze[i][j]).isVisible())
						System.out.print(maze[i][j]);
					else
						System.out.print(" ");
				}
			}
			System.out.print("  |  ");
			for (int k = 0; k < col; k++)
				System.out.print(maze[i][k]);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Maze maz = new Maze("map01.txt");
		maz.printSideBySide();

	}

}
