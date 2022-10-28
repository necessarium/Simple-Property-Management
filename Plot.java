/**
 * Class: CMSC203 
 * Instructor: Prof. Ping Wei Tsai
 * Description: This is a property management software, Plot class
 * Due: 10/25/2022
 * Platform/compiler: Eclipse Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
 * Name: Nicolas Negahdari
 */

public class Plot {
	private int x1, y1, x2, y2, width, depth;
	
	public Plot() {
		this(0, 0, 1, 1);
	}

	public Plot(int x, int y, int w, int d) {
		x1 = x; y1 = y;
		width = w; depth = d;
		x2 = x1 + width; y2 = y1 + depth;
	}
	
	public Plot(Plot otherPlot) {
		this(otherPlot.x1, otherPlot.y1, otherPlot.width, otherPlot.depth);
	};
	
	
	private boolean inInclRange(int val, int min, int max) {
		return val >= min && val <= max;
	}
	
	
	public boolean overlaps(Plot otherPlot) {
		int xA1 = this.x1, xA2 = this.x2;
		int yA1 = this.y1, yA2 = this.y2;
		int xB1 = otherPlot.x1, xB2 = otherPlot.x2;
		int yB1 = otherPlot.y1, yB2 = otherPlot.y2;
		if(xA1 >= xB2 || xA2 <= xB1 || yA1 >= yB2 || yA2 <= yB1) return false;
		else return true;
	}
	
	public boolean encompasses(Plot otherPlot) {
		int xA1 = this.x1, xA2 = this.x2;
		int yA1 = this.y1, yA2 = this.y2;
		int xB1 = otherPlot.x1, xB2 =  otherPlot.x2;
		int yB1 = otherPlot.y1, yB2 =  otherPlot.y2;
		if(inInclRange(xB1, xA1, xA2) && inInclRange(xB2, xA1, xA2))
			if(inInclRange(yB1, yA1, yA2) && inInclRange(yB2, yA1, yA2))
				return true;
		return false;
	}
	
	public void setX(int x) {x1 = x;}
	public void setY(int y) {y1 = y;}
	public void setWidth(int w) {width = w;}
	public void setDepth(int d) {depth = d;}
	
	public int getX() {return x1;}
	public int getY() {return y1;}
	public int getWidth() {return width;}
	public int getDepth() {return depth;}
	
	public String toString() {
		return String.format("%d,%d,%d,%d", x1, y1, width, depth);
	}
}
