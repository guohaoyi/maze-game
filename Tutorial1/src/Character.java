
public class Character {
	
	protected int health;
	protected int attack;
	protected int defense;
	protected int damage;
	protected boolean visible;
	
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

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
