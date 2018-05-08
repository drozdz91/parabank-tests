package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends MainPage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void openRegisterPage() {
        driver.get("http://parabank.parasoft.com/parabank/register.htm");
        waitForJStoLoad();
    }

    public void fillFirstName(String firstName) {
        driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        driver.findElement(By.xpath("//input[@id='customer.lastName']")).sendKeys(lastName);
    }

    public void fillAddress(String address) {
        driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys(address);
    }

    public void fillCity(String city) {
        driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys(city);
    }

    public void fillState(String state) {
        driver.findElement(By.xpath("//input[@id='customer.address.state']")).sendKeys(state);
    }

    public void fillZipCode(String zipCode) {
        driver.findElement(By.xpath("//input[@id='customer.address.zipCode']")).sendKeys(zipCode);
    }

    public void fillSSN(String ssn) {
        driver.findElement(By.xpath("//input[@id='customer.ssn']")).sendKeys(ssn);
    }

    public void fillUsername(String username) {
        driver.findElement(By.xpath("//input[@id='customer.username']")).sendKeys(username);
    }

    public void fillPassword(String password) {
        driver.findElement(By.xpath("//input[@id='customer.password']")).sendKeys(password);
    }

    public void fillConfirmationPassword(String confirmPassword) {
        driver.findElement(By.xpath("//input[@id='repeatedPassword']")).sendKeys(confirmPassword);
    }

    public void clickRegisterButton() {
        driver.findElement(By.xpath("//input[@class='button' and @value='Register']")).click();
        waitForJStoLoad();
    }

    public String getErrorTheSameUsernameText() {
        return driver.findElement(By.xpath("//span[@id='customer.username.errors']")).getText();
    }

    public String getErrorWithoutUsernameText() {
        return driver.findElement(By.xpath("//span[@id='customer.username.errors']")).getText();
    }

    public String getErrorWrongConfirmationPasswordText() {
        return driver.findElement(By.xpath("//span[@id='repeatedPassword.errors']")).getText();
    }
}
