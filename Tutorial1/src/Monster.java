
public class Monster extends Character {
	
	protected String name;
	protected int hasPotionProbability;
	protected int hasGoldProbability;
	protected boolean visible;
	
	public Monster(String name, int startHealth, int startAttack, int startDefense, int startDamage, int potion, int gold) {
		super(startHealth, startAttack, startDefense, startDamage);
		this.name = name;
		hasPotionProbability = potion;
		hasGoldProbability = gold;
		setVisible(false);
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean newVisible) {
		visible = newVisible;
	}

	public String toString() {
		return name.substring(0, 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Monster m = new Monster("Dragon",100,4,2,0,99,99);
		System.out.println(m);
	}

}
