package VTriger_Scripts;

import org.testng.annotations.Test;

import genericlib.BaseClass;
import pomrepo.DocumentPage;
import pomrepo.LeadsPage;
import pomrepo.ProductsPage;

/**
 * We need to change name with _Test Prefix as if we want to run pom.xml without surefire plugin it will
 * run only those tests that are prefix with _Test
 * @author Raghav Maheshwari
 *
 */
public class Script1_Test extends BaseClass  {
	
	@Test (groups="Leads")
	public void Script1_Test ()
	{
		LeadsPage leadsobj = new LeadsPage(driver);	
		leadsobj.getLeadsLink().click();
	}

}
