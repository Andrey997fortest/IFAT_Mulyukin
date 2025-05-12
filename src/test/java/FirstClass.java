import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import org.openqa.selenium.By;


public class FirstClass extends Parent.BaseTest {

    @Test
    public void zipCode4DigitsCheck() {
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.xpath("//*[@name='zip_code']")).sendKeys("234");
        browser.findElement(By.xpath("//*[@value='Continue']")).click();
        assertEquals(browser.findElement(By.cssSelector(".error_message")).getText(),
                "Oops, error on page. ZIP code should have 5 digits");
    }

    @Test
    public void zipCode5DigitsCheck() {
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.xpath("//*[@name='zip_code']")).sendKeys("23456");
        browser.findElement(By.xpath("//*[@value='Continue']")).click();
        boolean regBtnIsPresent = browser.findElement(By.xpath("//*[@value='Register']")).isDisplayed();
        assertTrue(regBtnIsPresent);
    }
}