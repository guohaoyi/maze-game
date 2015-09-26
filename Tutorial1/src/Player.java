
public class Player extends Character {
	
	private int currentHealth;
	private int gold;
	private Weapon bestWeapon;
	private boolean visible;
	
	public Player(int startHealth, int startAttack, int startDefense, int startDamage) {
		super(startHealth, startAttack, startDefense, startDamage);
		currentHealth = startHealth;
		gold = 0;
		bestWeapon = null;
		visible = true;
	}
	
	public boolean isVisible() {
		return visible;
	}

	public String toString() {
		return "U";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player p = new Player(100,5,2,0);
		System.out.println(p);
	}

}
