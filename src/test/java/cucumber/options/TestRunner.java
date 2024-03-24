package cucumber.options;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;




@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/Cucumber.html",
				"json:target/jsonReports/cucumber.json",
				"junit:target/cucumber-reports/Cucumber.xml",
				//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				//"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				},//reporting purpose
		monochrome=false,  //console output color
		features = "src/test/resources/features/Post.feature"
				    
				    , //location of feature files
				glue= {"stepDefinition"} //location of step definition files
	)

/*	public class TestRunner extends  AbstractTestNGCucumberTests {
		@DataProvider(parallel=false)
		public Object[][]scenarios(){
			
			return super.scenarios();
		
		}
}*/

public class TestRunner{

} 
