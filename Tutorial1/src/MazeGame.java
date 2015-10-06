import java.util.Random;
import java.util.Scanner;

public class MazeGame {
	
	public static boolean game = false;
	public static int exitRow, exitCol, playerRow, playerCol;
	public static Maze map;
	public static Player p;
	public static Monster[] monsters;
	private static Scanner scan;
	
	public static void getMove() {
		System.out.println("Input the direction you want to move.");
		scan = new Scanner(System.in);
		char ch = scan.nextLine().charAt(0);
		move(ch);
	}
	
	public static boolean checkEmpty(int row, int col) {
		if (map.maze[row][col].getClass().getName().equals("Wall")) {
			System.out.println("Sorry – you can’t walk through walls.");
			return false;
		}
		else
			return true;
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
			else if (map.maze[playerRow + 1][playerCol].getClass().getName().equals("Treasure")) {
				Treasure t1 = (Treasure)map.maze[playerRow + 1][playerCol];
				t1.setVisible(true);
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
			else if (map.maze[playerRow - 1][playerCol].getClass().getName().equals("Treasure")) {
				Treasure t2 = (Treasure)map.maze[playerRow - 1][playerCol];
				t2.setVisible(true);
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
			else if (map.maze[playerRow][playerCol + 1].getClass().getName().equals("Treasure")) {
				Treasure t3 = (Treasure)map.maze[playerRow][playerCol + 1];
				t3.setVisible(true);
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
			else if (map.maze[playerRow][playerCol - 1].getClass().getName().equals("Treasure")) {
				Treasure t4 = (Treasure)map.maze[playerRow][playerCol - 1];
				t4.setVisible(true);
			}
		}
	}
	
	public static void move(char ch) {
		if (ch == 'n') {
			if(checkEmpty(playerRow - 1, playerCol)) {
				checkTreasure(playerRow - 1, playerCol);
				checkMonster(playerRow - 1, playerCol);
				map.maze[playerRow - 1][playerCol] = p;
				map.maze[playerRow][playerCol] = new Empty();
				playerRow--;
				setVisible();
			}
		}
		else if (ch == 's') {
			if(checkEmpty(playerRow + 1, playerCol)) {
				checkTreasure(playerRow + 1, playerCol);
				checkMonster(playerRow + 1, playerCol);
				map.maze[playerRow + 1][playerCol] = p;
				map.maze[playerRow][playerCol] = new Empty();
				playerRow++;
				setVisible();
			}
		}
		else if (ch == 'e') {
			if(checkEmpty(playerRow, playerCol + 1)) {
				checkTreasure(playerRow, playerCol + 1);
				checkMonster(playerRow, playerCol + 1);
				map.maze[playerRow][playerCol + 1] = p;
				map.maze[playerRow][playerCol] = new Empty();
				playerCol++;
				setVisible();
			}
		}
		else if (ch == 'w') {
			if(checkEmpty(playerRow, playerCol - 1)) {
				checkTreasure(playerRow, playerCol - 1);
				checkMonster(playerRow, playerCol - 1);
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
		int playerAttack = p.getAttack() + p.getAttackBonus();
		int playerDamage = p.getDamage() + p.getDamageBonus();
		int playerDefense = p.getDefense();
		int playerHealth = p.getCurrentHealth();
		int monsterAttack = m.getAttack();
		int monsterDamage = m.getDamage();
		int monsterDefense = m.getDefense();
		int monsterHealth = m.getHealth();
		//boolean monsterDies = false;
		while ((playerHealth > 0) && (monsterHealth > 0)) {
			int pAttack = playerRandom.nextInt(playerAttack);
			int mDefense = monsterRandom.nextInt(monsterDefense);
			if (pAttack > mDefense) {
				int actualPlayerDamage = playerRandom.nextInt(playerDamage);
				monsterHealth = monsterHealth - actualPlayerDamage;
				System.out.println("You hit " + m.getName() + " for " + actualPlayerDamage + " damage!");
				if (monsterHealth <= 0) {
					//monsterDies = true;
					System.out.println(m.getName() + " died!");
					dropTreasure(m);
					break;
				}
			}
			else
				System.out.println("You tried to hit " + m.getName() + " but missed it");
			int mAttack = monsterRandom.nextInt(monsterAttack);
			int pDefense = playerRandom.nextInt(playerDefense);
			if (mAttack > pDefense) {
				int actualMonsterDamage = monsterRandom.nextInt(monsterDamage);
				playerHealth = playerHealth - actualMonsterDamage;
				p.setCurrentHealth(playerHealth);
				System.out.println(m.getName() + " hit you for " + actualMonsterDamage + " damage! Your current health is " + playerHealth);
				if (playerHealth <= 0) {
					System.out.println("You died!");
					game = true;
					break;
				}
			}
			else
				System.out.println(m.getName() + " tried to hit you but missed it");
		}
		p.setCurrentHealth(playerHealth);
	}
	
	public static void checkMonster(int row, int col) {
		if (getType(row, col).equals("Monster")) {
			Monster m = (Monster)map.maze[row][col];
			System.out.println("You ran into a monster, which is a(n) " + m.getName());
			attack(m);
		}
	}
	
	public static void checkTreasure(int row, int col) {
		if (getType(row, col).equals("Treasure")) {
			Treasure t = (Treasure)map.maze[row][col];
			if (t.toString().equals("B")) {
				p.increaseGold(t.getValue());
				System.out.println("You've got " + t.getValue() + " gold! You currently have " + p.getGold() + " gold");
			}
			else if (t.toString().equals("H")) {
				p.increaseCurrentHealth(t.getHealthRestoration());
				System.out.println("You've got " + t.getHealthRestoration() + " health! Your current health is " + p.getCurrentHealth());
			}
			else if (t.toString().equals("S")) {
				Weapon w = new Weapon("Sword +2", 10000, 0, 10, 15, 10);
				p.setBestWeapon(w);
				System.out.println("You've got " + t.getName() + " weapon! Your current weapon is " + p.getBestWeapon().getName());
			}
		}
	}
	
	public static void dropTreasure(Monster m) {
		Random treasureRandom = new Random();
		int goldRandom = treasureRandom.nextInt(100);
		if (goldRandom <= m.getHasGoldProbability()) {
			Treasure gold = map.treasures[2];
			p.increaseGold(gold.getValue());
			System.out.println(m.getName() + " dropped some gold! You've got " + gold.getValue() + " gold! You currently have " + p.getGold() + " gold");
		}
		int potionRandom = treasureRandom.nextInt(100);
		if (potionRandom <= m.getHasPotionProbability()) {
			Treasure potion = map.treasures[1];
			p.increaseCurrentHealth(potion.getHealthRestoration());
			System.out.println(m.getName() + " dropped a health potion! You've got " + potion.getHealthRestoration() + " health! Your current health is " + p.getCurrentHealth());
		}
	}
	
	public static void checkGame() {
		if ((map.maze[exitRow][exitCol].equals(p)) || (p.getCurrentHealth() <= 0))
			game = true;
	}
	
	public static String getType(int row, int col) {
		String type = map.maze[row][col].getClass().getName();
		return type;
	}
	
	public static void printTenLines() {
		System.out.println("\n\n\n\n\n\n\n\n\n");
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
			//printTenLines();
			map.printSideBySide();
			checkGame();
		}
		System.out.println("Game!");
	}

}
