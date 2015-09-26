
public class Wall {
	
	private static boolean visible;
	
	public Wall() {
		setVisible(false);
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean newVisible) {
		visible = newVisible;
	}

	public String toString() {
		return "W";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
