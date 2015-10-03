import java.util.Random;
import java.util.Scanner;

public class MazeGame {
	
	public static boolean game = false;
	public static int exitRow, exitCol, playerRow, playerCol;
	public static Maze map;
	public static Player p;
	public static Monster[] monsters;
	
	public static void getMove() {
		System.out.println("Input the direction you want to move.");
		Scanner sc = new Scanner(System.in);
		char ch = sc.nextLine().charAt(0);
		System.out.println(ch);
		move(ch);
	}
	
	public static boolean checkEmpty(int row, int col) {
		if (map.maze[row][col].getClass().getName().equals("Empty"))
			return true;
		else {
			System.out.println("Invalid move");
			return false;
		}
	}
	
	public static void setVisible() {
		if (playerRow + 1 <= map.row) {
			if (map.maze[playerRow + 1][playerCol].getClass().getName().equals("Wall")) {
				Wall w1 = (Wall)map.maze[playerRow + 1][playerCol];
				w1.setVisible(true);
			}
			else if (map.maze[playerRow + 1][playerCol].getClass().getName().equals("Monster")) {
				Monster m1 = (Monster)map.maze[playerRow + 1][playerCol];
				m1.setVisible(true);
			}
		}
		if (playerRow - 1 >= 0) {
			if (map.maze[playerRow - 1][playerCol].getClass().getName().equals("Wall")) {
				Wall w2 = (Wall)map.maze[playerRow - 1][playerCol];
				w2.setVisible(true);
			}
			else if (map.maze[playerRow - 1][playerCol].getClass().getName().equals("Monster")) {
				Monster m2 = (Monster)map.maze[playerRow - 1][playerCol];
				m2.setVisible(true);
			}
		}
		if (playerCol + 1 <= map.col) {
			if (map.maze[playerRow][playerCol + 1].getClass().getName().equals("Wall")) {
				Wall w3 = (Wall)map.maze[playerRow][playerCol + 1];
				w3.setVisible(true);
			}
			else if (map.maze[playerRow][playerCol + 1].getClass().getName().equals("Monster")) {
				Monster m3 = (Monster)map.maze[playerRow][playerCol + 1];
				m3.setVisible(true);
			}
		}
		if (playerCol - 1 >= 0) {
			if (map.maze[playerRow][playerCol - 1].getClass().getName().equals("Wall")) {
				Wall w4 = (Wall)map.maze[playerRow][playerCol - 1];
				w4.setVisible(true);
			}
			else if (map.maze[playerRow][playerCol - 1].getClass().getName().equals("Monster")) {
				Monster m4 = (Monster)map.maze[playerRow][playerCol - 1];
				m4.setVisible(true);
			}
		}
	}
	
	public static void move(char ch) {
		if (ch == 'n') {
			if(checkEmpty(playerRow - 1, playerCol)) {
				map.maze[playerRow - 1][playerCol] = p;
				map.maze[playerRow][playerCol] = new Empty();
				playerRow--;
				setVisible();
			}
		}
		else if (ch == 's') {
			if(checkEmpty(playerRow + 1, playerCol)) {
				map.maze[playerRow + 1][playerCol] = p;
				map.maze[playerRow][playerCol] = new Empty();
				playerRow++;
				setVisible();
			}
		}
		else if (ch == 'e') {
			if(checkEmpty(playerRow, playerCol + 1)) {
				map.maze[playerRow][playerCol + 1] = p;
				map.maze[playerRow][playerCol] = new Empty();
				playerCol++;
				setVisible();
			}
		}
		else if (ch == 'w') {
			if(checkEmpty(playerRow, playerCol - 1)) {
				map.maze[playerRow][playerCol - 1] = p;
				map.maze[playerRow][playerCol] = new Empty();
				playerCol--;
				setVisible();
			}
		}
		else
			System.out.println("Invalid input");
	}
	
	public static void attack(Monster m) {
		Random playerRandom = new Random();
		Random monsterRandom = new Random();
		int playerAttack = p.getAttack();
		int playerDamage = p.getDamage();
		int playerDefense = p.getDefense();
		int playerHealth = p.getHealth();
		int monsterAttack = m.getAttack();
		int monsterDamage = m.getDamage();
		
	}
		
	public static void checkGame() {
		if (map.maze[exitRow][exitCol].equals(p))
			game = true;
	}
	
	public static void checkMonster() {
		if ((getType(playerRow + 1, playerCol).equals("Monster")) || (getType(playerRow - 1, playerCol).equals("Monster")) || (getType(playerRow, playerCol + 1).equals("Monster")) || (getType(playerRow, playerCol - 1).equals("Monster")))
			System.out.println("bruh!");
	}
	
	public static String getType(int row, int col) {
		String type = map.maze[row][col].getClass().getName();
		return type;
	}
	
	public static void main(String[] args) {
		map = new Maze("map01.txt");
		exitRow = 1;
		exitCol = 0;
		playerRow = map.playerRow;
		playerCol = map.playerCol;
		p = (Player)map.maze[playerRow][playerCol];
		System.out.println("You wake up in a cold, damp, dark area. You're lying on the ground in a pool of blood\nand vomit. It appears to be your own. Wow! What a wild night last night was. You\nremember so little, but your head pounds and you wish you were home in bed (or even\nin Dave's CSC 300 class - anywhere but here). Oh well. You stagger to your feet and\nbump up against a slimy wall. Ewwwwww! Well, time to get out of here. You notice\nyour pockets are empty. Even your trusty dagger is gone. This so sucks. Well, you're\nnot getting home by standing here... Get moving!");
		setVisible();
		map.printSideBySide();
		while (!game) {
			getMove();
			map.printSideBySide();
			checkMonster();
			checkGame();
		}
		System.out.println("Game!");
	}

}
