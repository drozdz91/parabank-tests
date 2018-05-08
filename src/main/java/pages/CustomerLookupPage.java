package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerLookupPage extends MainPage {

    public CustomerLookupPage(WebDriver driver) {
        super(driver);
    }

    public void openCustomerLookupPage() {
        driver.get("http://parabank.parasoft.com/parabank/lookup.htm");
        waitForJStoLoad();
    }

    public void fillFirstName(String firstName) {
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastName);
    }

    public void fillAddress(String address) {
        driver.findElement(By.xpath("//input[@id='address.street']")).sendKeys(address);
    }

    public void fillCity(String city) {
        driver.findElement(By.xpath("//input[@id='address.city']")).sendKeys(city);
    }

    public void fillState(String state) {
        driver.findElement(By.xpath("//input[@id='address.state']")).sendKeys(state);
    }

    public void fillZipCode(String zipCode) {
        driver.findElement(By.xpath("//input[@id='address.zipCode']")).sendKeys(zipCode);
    }

    public void fillSSN(String ssn) {
        driver.findElement(By.xpath("//input[@id='ssn']")).sendKeys(ssn);
    }

    public void clickMyLoginInfoButton() {
        driver.findElement(By.xpath("//input[@class='button' and @value='Find My Login Info']")).click();
        waitForJStoLoad();
    }

    public String getErrorWithoutFirstNameText() {
        return driver.findElement(By.xpath("//span[@id='firstName.errors']")).getText();
    }

    public String getErrorWithoutLastNameText() {
        return driver.findElement(By.xpath("//span[@id='lastName.errors']")).getText();
    }
}
