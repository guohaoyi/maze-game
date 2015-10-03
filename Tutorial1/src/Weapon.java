
public class Weapon extends Treasure{
	
	public Weapon(String name, int value, int healthRestoration, int healthRestoration1, int attackBonus, int damageBonus, int probability) {
		super("Weapon", name, value, healthRestoration, attackBonus, damageBonus, probability);
	}
	
	public int compareTo(Weapon w) {
		if ((attackBonus + damageBonus ) > (w.getAttackBonus() + w.getDamageBonus()))
			return 1;
		else if ((attackBonus + damageBonus ) == (w.getAttackBonus() + w.getDamageBonus()))
			return 0;
		else
			return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
