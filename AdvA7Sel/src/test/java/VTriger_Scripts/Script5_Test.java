package VTriger_Scripts;

import org.testng.annotations.Test;

import genericlib.BaseClass;
import pomrepo.ProductsPage;

public class Script5_Test extends BaseClass  {
	
	@Test
	public void Script5_Test ()
	{
		ProductsPage productobj = new ProductsPage(driver);	
		productobj.getproductLink().click();
	}

}
