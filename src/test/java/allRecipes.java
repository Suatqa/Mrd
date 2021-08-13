import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class allRecipes {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url= "https://www.allrecipes.com/";
        driver.get(url);

        //For the page https://allrecipes.com, provide a list of steps to automate the
        // ‘find a recipe’ functionality as you see fit.



        driver.findElement(By.id("search-block")).sendKeys("Classic Spicy Meatloaf");
        WebElement a = driver.findElement(By.id("search-block"));
        a.sendKeys(Keys.RETURN);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement meat = driver.findElement(By.xpath("//div[2]/div/div[2]/div[1]/div[1]/a/div/div[1]/img"));
        meat.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement steps = driver.findElement(By.xpath("//fieldset[@class='instructions-section__fieldset']"));
        String b = steps.getText();
        System.out.println(b);

        System.out.println();


        driver.close();
        driver.quit();


    }
}
