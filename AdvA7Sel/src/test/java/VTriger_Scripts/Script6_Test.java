package VTriger_Scripts;

import org.testng.annotations.Test;

import genericlib.BaseClass;
import pomrepo.DocumentPage;
import pomrepo.ProductsPage;

public class Script6_Test extends BaseClass  {
	
	@Test
	public void Script6_Test ()
	{
		DocumentPage documentobj = new DocumentPage(driver);	
		documentobj.getdocumentLink().click();
	}

}
