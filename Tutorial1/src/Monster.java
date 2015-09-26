
public class Monster extends Character {
	
	private double hasPotionProbability;
	private double hasGoldProbability;
	private boolean visible;
	
	public Monster(int startHealth, int startAttack, int startDefense, int startDamage) {
		super(startHealth, startAttack, startDefense, startDamage);
		hasPotionProbability = 0.5;
		hasGoldProbability = 0.5;
		setVisible(false);
	}
	
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean newVisible) {
		visible = newVisible;
	}

	public String toString() {
		return "G";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Monster m = new Monster(100,4,2,0);
		System.out.println(m);
	}

}
