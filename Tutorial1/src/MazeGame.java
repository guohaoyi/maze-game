import java.util.Scanner;

public class MazeGame {
	
	static boolean game = false;
	int exitRow, exitCol;
	static Maze map;
	Player p = (Player)Maze.realMaze[Maze.playerCol][Maze.playerCol];
	
	public static void getMove() {
		System.out.println("Input the direction you want to move.");
		Scanner sc = new Scanner(System.in);
		char ch = sc.nextLine().charAt(0);
		//move(ch);
	}
	/*
	public void move(char ch) {
		if (ch == 'n')
			null;
		else if (ch == 's')
			null;
		else if (ch == 'e')
			null;
		else if (ch == 'w')
			null;
		else
			System.out.println("Invalid input");
	}
*/
	public void checkGame() {
		if (map.realMaze[exitRow][exitCol].equals(p))
			game = true;
	}
	
	public String getType(int row, int col) {
		String type = map.realMaze[row][col].getClass().getName();
		return type;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		map = new Maze("map01.txt");
		map.realMaze();
		System.out.println(map);
		System.out.println("You wake up in a cold, damp, dark area. You're lying on the ground in a pool of blood\nand vomit. It appears to be your own. Wow! What a wild night last night was. You\nremember so little, but your head pounds and you wish you were home in bed (or even\nin Dave's CSC 300 class - anywhere but here). Oh well. You stagger to your feet and\nbump up against a slimy wall. Ewwwwww! Well, time to get out of here. You notice\nyour pockets are empty. Even your trusty dagger is gone. This so sucks. Well, you're\nnot getting home by standing here... Get moving!");
		String cla = map.realMaze[1][1].getClass().getName();
		System.out.println(cla);
		System.out.println(cla.equals("Empty"));
		System.out.println((Empty)map.realMaze[1][2]);
		while (!game)
		{
			getMove();
			break;
		}
	}

}
