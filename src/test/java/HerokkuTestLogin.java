import org.openqa.selenium.By;
import org.testng.annotations.Test;
import Parent.BaseTest;
import static org.testng.AssertJUnit.assertTrue;



public class HerokkuTestLogin extends BaseTest {
    @Test
    public void testLogin() {
        browser.get("https://the-internet.herokuapp.com/login ");
        browser.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
        browser.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        browser.findElement(By.xpath("//button[@type='submit']")).click();
        String successMessage = browser.findElement(By.xpath("//div[@class='flash success']")).getText();
        assertTrue(successMessage.contains("You logged into a secure area!"));
    }

}