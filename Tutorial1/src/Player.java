
public class Player extends Character {
	
	private int currentHealth;
	private int gold;
	private Weapon bestWeapon;
	private boolean visible;
	
	public Player(int startHealth, int startAttack, int startDefense, int startDamage) {
		super(startHealth, startAttack, startDefense, startDamage);
		setCurrentHealth(startHealth);
		gold = 0;
		setBestWeapon(null);
		visible = true;
	}
	
	public boolean isVisible() {
		return visible;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	public Weapon getBestWeapon() {
		return bestWeapon;
	}

	public void setBestWeapon(Weapon w) {
		if (bestWeapon == null)
			bestWeapon = w;
		else {
			if(bestWeapon.compareTo(w) == -1)
				bestWeapon = w;
		}
	}
	
	public int getAttackBonus() {
		if (bestWeapon == null)
			return 0;
		else
			return bestWeapon.getAttackBonus();
	}
	
	public int getDamageBonus() {
		if (bestWeapon == null)
			return 0;
		else
			return bestWeapon.getDamageBonus();
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
