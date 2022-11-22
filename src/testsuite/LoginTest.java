package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void UserSholdLoginSuccessfullyWithValidCredentials() {

        WebElement UsernameField = driver.findElement(By.id("username"));
        UsernameField.sendKeys("tomsmith");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");


        WebElement loginlink1 = driver.findElement(By.xpath("//button[@class='radius']/i[1]"));
        loginlink1.click();

        String expectedMessage = "Secure Area";

        // Find the welcome text element and get th text
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//h2[text()=' Secure Area']"));
        String actualMessage = actualTextMessageElement.getText();

        // validate actual and Expected Massage
        Assert.assertEquals("Verify the text", expectedMessage, actualMessage);

    }

    @Test
    public void verifyTheUsernameErrorMessage() {

        WebElement UsernameField = driver.findElement(By.id("username"));
        UsernameField.sendKeys("tomsmith1");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");


        WebElement loginlink1 = driver.findElement(By.xpath("//button[@class='radius']/i[1]"));
        loginlink1.click();

        String expectedMessage = "Your username is invalid!\n"  +
                "×";


        // Find the welcome text element and get th text
        WebElement actualTextMessageElement = driver.findElement(By.id("flash"));
        String actualMessage = actualTextMessageElement.getText();

        // validate actual and Expected Massage
        Assert.assertEquals("Verify the Massage", expectedMessage, actualMessage);


    }

    @Test
    public void verifyThePasswordErrorMessage() {

        WebElement UsernameField = driver.findElement(By.id("username"));
        UsernameField.sendKeys("tomsmith");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword");


        WebElement loginlink1 = driver.findElement(By.xpath("//button[@class='radius']/i[1]"));
        loginlink1.click();

        String expectedMessage = "Your password is invalid!\n"  +
                "×";


        // Find the welcome text element and get th text
        WebElement actualTextMessageElement = driver.findElement(By.id("flash"));
        String actualMessage = actualTextMessageElement.getText();

        // validate actual and Expected Massage
        Assert.assertEquals("Verify the Massage", expectedMessage, actualMessage);

    }

    @After
    public void testDown() {
        closeBrowser();

    }

}
