import java.awt.*;
import javax.swing.JFrame;

public class flag extends JFrame {
	/*
	 * These double arrays consist of the coordinates of the original star I made with a center (100,100) radius 23,  
	 * however with 100 subtracted from every point and divided by 23. Now, the coordinates are configured around and the 
	 * origin (0,0) and have a radius of 1. Now, this allows you, with the use of the star method to place the stars 
	 * anywhere you would like on JFrame.
	 */
	private int [ ] x1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
	private int [ ] y1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
	private double [ ] xg = {0.0/23.0, -7.0/23.0, -23.0/23.0, -12.0/23.0, -14.0/23.0, 0.0/23.0, 14.0/23.0, 12.0/23.0, 23.0/23.0, 7.0/23.0};
	private double [ ] yg = {-25.0/23.0, -10.0/23.0, -8.0/23.0, 4.0/23.0, 20.0/23.0, 12.0/23.0, 20.0/23.0, 4.0/23.0, -8.0/23.0, -10.0/23.0};

	public flag () {
		init();
	}

	public void init() {
		setSize(900,600);
		repaint();
	}

	//Parts of Flag
	//Dimensions are multiplied by 400
	public void paint(Graphics g) {

		//Deletes the past graphics "painted"
		super.paint(g);

		//SCALING VARIABLES

		//set the dimensions of the windows. ww(window width)/wh(window height)
		double ww = 900;
		double wh = 600;

		//sets the current width and height of the window(after being moved or staying stationary) to two different variables
		double width = this.getWidth();
		double height = this.getHeight();

		//The ratio/scale factor of the current window to the preset/flag one
		double sfw = (width/ww);
		double sfh = (height/wh);

		//The average of the two ratios, to get the scale factor for both height and width
		double sf = ((sfw + sfh)/2);


		//RED BACKGROUND

		//Cable No. 70180 Old Glory Red Color for background of flag
		g.setColor(new Color(191, 13, 62));

		//Red Background Coordinates with Scale Factor to change them as the window changes in width and height
		int rx = (int)(50*sf);
		int ry = (int)(100*sf);

		//Red Background Dimensions with Scale Factor to change them as the window changes in width and height
		int rw = (int)(760*sf);
		int rh = (int)(400*sf);

		//Drawing of Red Background using previous variables
		g.fillRect(rx, ry, rw, rh);


		//WHITE RECTANGLES

		//Cable No. 70001 White Color
		g.setColor(new Color(255, 255, 255));

		//White Stripe Coordinates with scale factor for if the window changes in height or width
		int wrx = (int)(50*sf);
		int wry = (int)(131*sf);
		
		//White Stripe dimensions with scale factor for if the window changes in height or width
		int wrw = (int)(760*sf);
		int wrh = (int)(31*sf);

		//Draws the 6 white rectangles that are layered on top of the red background
		for (int i = 0; i < 6; i++) {
			g.fillRect(wrx, (int)(wry + (62*sf*i)), wrw, wrh);
		}

		//Blue Union
		
		//Blue color of the union
		g.setColor(new Color(4, 30, 66));
		
		//Union upper left Coordinates with scale factor for if the window changes in height or width
		int ux = (int)(50*sf);
		int uy = (int)(100*sf);
		
		//Union dimensions with scale factor for if the window changes in height or width
		int uw = (int)(304*sf);
		int uh = (int)(217*sf);

		//Draws the blue union
		g.fillRect(ux, uy, uw, uh);

		//White stars
		
		//Color of the white stars
		g.setColor(new Color(255, 255, 255));
		
		//radius of the star
		double radius = 12.32 * sf;
		
		//Coordinates for the center of the stars
		double scx = ux + (sf*25.2);
		double scy = uy + (sf*21.6);
		
		//Changes in X and Y for the movement of each star through the union
		double movex = (50.4*sf);
		double movey = (21.6*sf);

		//Runs the stars method
		stars(radius, scx, scy);

		/*
		 * Below is a for loop that actually draws the star in their
		 * proper places by utilizing the stars method to find the x1 and y1 values
		 * for the star at a given position and then moving the star according to its column and 
		 * row and finally drawing the star using the fillPolygon method using the x1/y1 double 
		 * arrays as well as the value 10(number of coordinates/points of a star)
		 */
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 9; j++) {
				if (j % 2 == 0) {
					stars(radius, scx + (movex*i), scy + (movey*j));
					g.fillPolygon(x1, y1, 10);
				} else if (i != 5){
					stars(radius, scx + ((movex*(i)) + (25.2*sf)), scy + (movey*j));
					g.fillPolygon(x1, y1, 10);
				}
			}
		}
	}

	/*
	 * This code takes in the center coordinates and radius of the star and 
	 * and changes the x1 and y1 double arrays to match the coordinates
	 * for the star changed based on its new center and radius
	 */
	public void stars(double radius, double starcenter_x, double starcenter_y) {
		for (int i = 0; i < 10; i++) {
			x1[i] = (int)(xg[i] * radius);
			y1[i] = (int)(yg[i] * radius);
		}

		for (int i = 0; i < 10; i++) {
			x1[i] = (int)(x1[i] + starcenter_x);
			y1[i] = (int)(y1[i] + starcenter_y);
		}
	}

}