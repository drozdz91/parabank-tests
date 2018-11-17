package steps;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import pages.IndexPage;

@CucumberOptions(features = "src/test/resources/gherkin", glue = "steps")
public class MainSteps extends AbstractTestNGCucumberTests {

    protected static WebDriver driver;
    protected static IndexPage indexPage;
    protected ITestContext context;

    public MainSteps() {
        driver = new ChromeDriver();
        indexPage = new IndexPage(driver, "http://parabank.parasoft.com/", context);
    }

    @AfterTest
    public void after() {
        driver.close();
    }
}
