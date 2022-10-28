/**
 * Class: CMSC203 
 * Instructor: Prof. Ping Wei Tsai
 * Description: This is a property management software, Property class
 * Due: 10/25/2022
 * Platform/compiler: Eclipse Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
 * Name: Nicolas Negahdari
 */

public class Property {
	private double rentAmount;
	private String propertyName;
	private String city;
	private String owner;
	private Plot plot;
	
	public Property() {
		this("", "", -1, "");
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this(propertyName, city, rentAmount, owner, 0, 0, 1, 1);
	}
	
	public Property(String propertyName, String city, double rentAmount, 
					String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName; this.city = city; 
		this.rentAmount = rentAmount; this.owner = owner;
		this.plot = new Plot(x, y, width, depth);
	}
	
	public Property(Property otherProperty) {
		this(otherProperty.propertyName, otherProperty.city, otherProperty.rentAmount, 
			 otherProperty.owner, otherProperty.plot.getX(), otherProperty.plot.getY(), 
			 otherProperty.plot.getWidth(), otherProperty.plot.getDepth());
	}
	
	public Plot getPlot() {return plot;}
	public String getPropertyName() {return propertyName;}
	public String getCity() {return city;}
	public double getRentAmount() {return rentAmount;}
	public String getOwner() {return owner;}
	
	public String toString() {
		return String.format("%s,%s,%s,%.2f", propertyName, city, owner, rentAmount);
	}
}
