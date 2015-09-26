
public class Character {
	
	private int health;
	private int attack;
	private int defense;
	private int damage;
	
	public Character(int startHealth, int startAttack, int startDefense, int startDamage) {
		setHealth(startHealth);
		setAttack(startAttack);
		setDefense(startDefense);
		setDamage(startDamage);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Character c = new Character(100,5,2,0);
		System.out.println(c);
	}

}
