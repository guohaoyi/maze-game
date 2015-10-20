
public class Treasure {
	
	protected String type;
	protected String name;
	protected int value;
	protected int healthRestoration;
	protected int attackBonus;
	protected int damageBonus;
	protected int probability;
	protected boolean visible;
	
	public Treasure(String type, String name, int value, int healthRestoration, int attackBonus, int damageBonus, int probability) {
		this.setType(type);
		this.setName(name);
		this.setValue(value);
		this.setHealthRestoration(healthRestoration);
		this.setAttackBonus(attackBonus);
		this.setDamageBonus(damageBonus);
		this.setProbability(probability);
		//setPickedUp(false);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getHealthRestoration() {
		return healthRestoration;
	}

	public void setHealthRestoration(int healthRestoration) {
		this.healthRestoration = healthRestoration;
	}

	public int getAttackBonus() {
		return attackBonus;
	}

	public void setAttackBonus(int attackBonus) {
		this.attackBonus = attackBonus;
	}

	public int getDamageBonus() {
		return damageBonus;
	}

	public void setDamageBonus(int damageBonus) {
		this.damageBonus = damageBonus;
	}

	public int getProbability() {
		return probability;
	}

	public void setProbability(int probability) {
		this.probability = probability;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String toString() {
		return name.substring(0, 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
