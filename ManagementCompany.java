/**
 * Class: CMSC203 
 * Instructor: Prof. Ping Wei Tsai
 * Description: This is a property management software, ManagementCompany class
 * Due: 10/25/2022
 * Platform/compiler: Eclipse Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
 * Name: Nicolas Negahdari
 */

public class ManagementCompany {
	public static final int MAX_PROPERTY = 5;
	public static final int MGMT_WIDTH = 10;
	public static final int MGMT_DEPTH = 10;
	
	private String name, taxID;
	private double mgmFee;
	
	private int numberOfProperties;
	private Property[] properties;
	private Plot plot;
	
	public ManagementCompany() {
		this("", "", 0);
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this(name, taxID, mgmFee, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee, 
							 int x, int y, int width, int depth) {
		this.name = name; this.taxID = taxID; this.mgmFee = mgmFee;
		plot = new Plot(x, y, width, depth);
		properties = new Property[MAX_PROPERTY];
		numberOfProperties = 0;
	}
	
	public ManagementCompany(ManagementCompany otherCompany) {
		this(otherCompany.name, otherCompany.taxID, otherCompany.mgmFee, 
			 otherCompany.plot.getX(), otherCompany.plot.getY(),
			 otherCompany.plot.getWidth(), otherCompany.plot.getDepth());
		this.properties = otherCompany.getProperties();
		this.numberOfProperties = otherCompany.getPropertiesCount();
	}
	
	int addProperty(String name, String city, double rent, String owner) {
		Property property = new Property(name, city, rent, owner, 0, 0, 0, 0);
		return addProperty(property);
	}
	
	public int addProperty(String name, String city, double rent, 
						   String owner, int x, int y, int width, int depth) {
		return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
	}
	
	public int addProperty(Property property) {
		if(isPropertiesFull()) return -1;
		if(property == null) return -2;
		if(!this.plot.encompasses(property.getPlot())) return -3;
		for(int i = 0; i < numberOfProperties; i++)
			if(property.getPlot().overlaps(properties[i].getPlot())) return -4;
		properties[numberOfProperties] = property;
		numberOfProperties += 1;
		return numberOfProperties - 1;
	}
	
	public void removeLastProperty() {
		for(int i = MAX_PROPERTY - 1; i >= 0; i--)
			if(properties != null) {
				properties[i] = null;
				break;
			}
	}
	
	public boolean isPropertiesFull() {
		return numberOfProperties == MAX_PROPERTY;
	}
	
	public int getPropertiesCount() {return numberOfProperties;}
	public Property[] getProperties() {return properties;}
	public double getMgmFeePer() {return mgmFee;}
	public String getName() {return name;}
	public String getTaxID() {return taxID;}
	public Plot getPlot() {return plot;}
	
	
	public double getTotalRent() {
		double totalRent = 0;
		for(Property prop : properties)
			if(prop == null) break;
			else totalRent += prop.getRentAmount();
		return totalRent;
	}
	
	public Property getHighestRentProperty() {
		Property highestRentProperty = properties[0];
		for(Property prop : properties)
			if(prop == null) break;
			else if(prop.getRentAmount() > highestRentProperty.getRentAmount()) 
					highestRentProperty = prop;
		return highestRentProperty;
	}
	
	
	public boolean isManagementFeeValid() {
		return mgmFee >= 0 && mgmFee <= 100;
	}
	
	
	public String toString() {
		double totMgmFee = 0;
		String bar = "____________________________________________";
		String l = "List of the properties for ";
		String mgmtCompanyStr = String.format("%s%s, taxID: %s\n%s\n", l, name, taxID, bar);
		for(Property prop : properties)
			if(prop == null) break;
			else {
				mgmtCompanyStr += prop.toString() + "\n";
				totMgmFee += (mgmFee/100) * prop.getRentAmount();
			}
		mgmtCompanyStr += bar + "\ntotal management fee: " + totMgmFee;
		return mgmtCompanyStr;
	}
}