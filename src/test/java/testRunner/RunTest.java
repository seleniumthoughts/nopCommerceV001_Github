package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features=".//Features/Customers.feature",
		//features={".//Features/Customers.feature",".//Features/Login.feature"},
		features=".//Features/", // All feature files
		glue="stepDefinitions",
		monochrome=true,
		//tags="@regression or @sanity",// running specific 'Scenarios' from different features files
		//tags={"@regression,@sanity"},// executes both 
		tags="not @smoke", // all remaining Scenarios will executes(Not @smoke)
		dryRun=false, // if it is false then test case will executes
		plugin={"pretty",
		       "html:test-output"}
		)
public class RunTest {

}
