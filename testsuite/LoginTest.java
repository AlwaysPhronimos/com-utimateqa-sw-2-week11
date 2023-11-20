package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userShouldNavigateToLoginPageSuccessfully * click on the ‘Sign In’ link
 * Verify the text ‘Welcome Back!’
 * 2. verifyTheErrorMessage
 * click on the ‘Sign In’ link
 * Enter invalid username
 * Enter invalid password
 * Click on Login button
 * Verify the error message ‘Invalid email or password.’
 */
public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() throws InterruptedException {
        openBrowser(baseUrl);
        Thread.sleep(4000);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully()  throws InterruptedException {
        //click on the ‘Sign In’ link
        driver.findElement(By.partialLinkText("Sign")).click();
        Thread.sleep(4000);
        //Verify the text ‘Welcome Back!’
        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        Assert.assertEquals(expectedText, actualText);
        Thread.sleep(4000);
    }

    @Test
    public void verifyTheErrorMessage()  throws InterruptedException {
        // click on the ‘Sign In’ link
     driver.findElement(By.linkText("Sign In")).click();
        Thread.sleep(4000);
        // Enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("prime123@gmail.com");
        Thread.sleep(4000);
        // Enter invalid password
        driver.findElement(By.id("user[password]")).sendKeys("prime123");
        Thread.sleep(4000);
        //Click on Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(4000);
        // Verify the error message ‘Invalid email or password.’
        String expectedErrorMessage = "Invalid email or password.";
        String actualErrorMessage = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
