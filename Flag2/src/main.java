import java.awt.Color;
//This is the main class. It sets the background color to a night gray and
//creates a flag object.
public class main {
	public static void main(String[] args) {
		flag c = new flag();
		c.setDefaultCloseOperation(c.EXIT_ON_CLOSE);
		c.getContentPane().setBackground(Color.LIGHT_GRAY);
		c.setVisible(true);
	}
}