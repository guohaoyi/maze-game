import java.util.Scanner;

public class MazeGame {
	
	public static boolean game = false;
	public static int exitRow, exitCol, playerRow, playerCol;
	public static Maze map;
	public static Player p;
	
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
		if (map.maze[playerRow + 1][playerCol].getClass().getName().equals("Wall")) {
			Wall w1 = (Wall)map.maze[playerRow + 1][playerCol];
			w1.setVisible(true);
		}
		else if (map.maze[playerRow + 1][playerCol].getClass().getName().equals("Monster")) {
			Monster m1 = (Monster)map.maze[playerRow + 1][playerCol];
			m1.setVisible(true);
		}
		if (map.maze[playerRow - 1][playerCol].getClass().getName().equals("Wall")) {
			Wall w2 = (Wall)map.maze[playerRow - 1][playerCol];
			w2.setVisible(true);
		}
		else if (map.maze[playerRow - 1][playerCol].getClass().getName().equals("Monster")) {
			Monster m2 = (Monster)map.maze[playerRow - 1][playerCol];
			m2.setVisible(true);
		}
		if (map.maze[playerRow][playerCol + 1].getClass().getName().equals("Wall")) {
			Wall w3 = (Wall)map.maze[playerRow][playerCol + 1];
			w3.setVisible(true);
		}
		else if (map.maze[playerRow][playerCol + 1].getClass().getName().equals("Monster")) {
			Monster m3 = (Monster)map.maze[playerRow][playerCol + 1];
			m3.setVisible(true);
		}
		if (map.maze[playerRow][playerCol - 1].getClass().getName().equals("Wall")) {
			Wall w4 = (Wall)map.maze[playerRow][playerCol - 1];
			w4.setVisible(true);
		}
		else if (map.maze[playerRow][playerCol - 1].getClass().getName().equals("Monster")) {
			Monster m4 = (Monster)map.maze[playerRow][playerCol - 1];
			m4.setVisible(true);
		}
	}
	
	public static void move(char ch) {
		if (ch == 'n') {
			if(checkEmpty(playerRow - 1, playerCol)) {
				map.maze[playerRow - 1][playerCol] = p;
				map.maze[playerRow][playerCol] = new Empty();
				playerRow--;
				if (playerRow >= 1)
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
				if (playerCol >= 1)
					setVisible();
			}
		}
		else
			System.out.println("Invalid input");
	}
		
	public static void checkGame() {
		if (map.maze[exitRow][exitCol].equals(p))
			game = true;
	}
	
	public String getType(int row, int col) {
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
		map.printMaze();
		setVisible();
		map.printVisible();
		while (!game) {
			getMove();
			map.printVisible();
			checkGame();
		}
		System.out.println("Game!");
	}

}
