
public class Monster extends Character {
	
	private String name;
	private int hasPotionProbability;
	private int hasGoldProbability;
	
	public Monster(String name, int startHealth, int startAttack, int startDefense, int startDamage, int potion, int gold) {
		super(startHealth, startAttack, startDefense, startDamage);
		this.name = name;
		setHasPotionProbability(potion);
		setHasGoldProbability(gold);
		setVisible(false);
	}
	
	public String getName() {
		return name;
	}
	
	public int getHasPotionProbability() {
		return hasPotionProbability;
	}

	public void setHasPotionProbability(int hasPotionProbability) {
		this.hasPotionProbability = hasPotionProbability;
	}

	public int getHasGoldProbability() {
		return hasGoldProbability;
	}

	public void setHasGoldProbability(int hasGoldProbability) {
		this.hasGoldProbability = hasGoldProbability;
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
