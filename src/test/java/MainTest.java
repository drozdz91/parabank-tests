import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.*;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class MainTest {

    protected WebDriver driver;
    protected IndexPage indexPage;
    protected ITestContext context;

    @BeforeMethod
    @Parameters({"url"})
    public void before(ITestContext context, String url) throws MalformedURLException {
        driver = new ChromeDriver();
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        capabilities.setCapability("version", "65");
//        capabilities.setCapability("platform", "WINDOWS");
//        driver = new RemoteWebDriver(new URL("http://192.168.0.31:4444/wd/hub"), capabilities);
        indexPage = new IndexPage(driver, url, context);
        this.context = context;
    }

    @AfterMethod
    public void after() {
        driver.close();
    }
}
