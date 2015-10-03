
public class Player extends Character {
	
	private int currentHealth;
	private int gold;
	private Weapon bestWeapon;
	private boolean visible;
	
	public Player(int startHealth, int startAttack, int startDefense, int startDamage) {
		super(startHealth, startAttack, startDefense, startDamage);
		currentHealth = startHealth;
		gold = 0;
		setBestWeapon(null);
		visible = true;
	}
	
	public boolean isVisible() {
		return visible;
	}

	public Weapon getBestWeapon() {
		return bestWeapon;
	}

	public void setBestWeapon(Weapon bestWeapon) {
		if (bestWeapon == null) {
			this.bestWeapon = bestWeapon;
			System.out.println("You've got a weapon!\n" + bestWeapon.getName() + "\nAttack Bonus: " + bestWeapon.getAttackBonus() + "\nDamage Bonus: " + bestWeapon.getDamageBonus());
		}
		else {
			if (bestWeapon.compareTo(this.bestWeapon) == -1)
				this.bestWeapon = bestWeapon;
		}
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
