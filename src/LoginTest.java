import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();

        driver.findElement(By.id("username")).sendKeys("Updated Name");
        driver.findElement(By.id("password")).sendKeys("SuperSuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String msg = driver.findElement(By.id("flash")).getText();

        if(msg.contains("You logged into a secure area!")){
            System.out.println("Login Successful ✅");
        } else {
            System.out.println("Login Failed ❌");
        }

        driver.quit();
    }
}