
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestStudent {
	Property sampleProperty;
	ManagementCompany mangementCo ; 
	
	@Before
	public void setUp() throws Exception {
		mangementCo= new ManagementCompany("Patagonia", "2346235", 8);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println(mangementCo.toString());
		mangementCo=null;
	}

	@Test
	public void testAddProperty() {
		sampleProperty = new Property ("Sunnyside", "Watts", 4234, " Will Ramsey",1,1,2,2);		 
		assertEquals(mangementCo.addProperty(sampleProperty),0,0);	//property has been successfully added to index 0
	}
	
	@Test
	public void testGetPropertiesCount() {
		sampleProperty = new Property("Sunnyside", "Watts", 4234, " Will Ramsey",1,1,2,1);		 
		assertEquals(mangementCo.addProperty(sampleProperty),0,0);	
		assertEquals(mangementCo.getPropertiesCount(), 1);
	}
}
