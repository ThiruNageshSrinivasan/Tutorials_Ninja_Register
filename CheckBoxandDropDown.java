package SevendaysPracticeSession;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckBoxandDropDown {

    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.in/amol.html");

        // Form filling
        driver.findElement(By.id("name")).sendKeys("thirunagesh srinivasan");
        driver.findElement(By.id("email")).sendKeys("thirusrinivasan558@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("13121997@Prac");

        // Toggle checkboxes
        toggleCheckbox(driver.findElement(By.id("check0")), "Java");
        toggleCheckbox(driver.findElement(By.id("check1")), "Selenium");
        toggleCheckbox(driver.findElement(By.id("check2")), "Cucumber");

        // Select each radio button and print its value
        for (int i = 0; i <= 2; i++) {
            WebElement radio = driver.findElement(By.id("rad" + i));
            radio.click();
            System.out.println("Selected radio: " + radio.getAttribute("value"));
            Thread.sleep(2000); // Optional wait to observe selection
        }

        // Handle dropdown
        WebElement seltext = driver.findElement(By.id("seltext"));
        Select sc = new Select(seltext);
        List<WebElement> options = sc.getOptions();

        System.out.println("Available dropdown options:");
        for (WebElement option : options) {
            System.out.println("- " + option.getText());
        }

        // Select each dropdown option
        for (int i = 0; i < options.size(); i++) {
            sc.selectByIndex(i);
            System.out.println("Selected: " + sc.getFirstSelectedOption().getText());
            Thread.sleep(1000);
        }

        driver.quit();
    }

    private static void toggleCheckbox(WebElement checkbox, String label) {
        if (checkbox.isSelected()) {
            checkbox.click();
            System.out.println("Checkbox '" + label + "' was selected, now unselected.");
        } else {
            checkbox.click();
            System.out.println("Checkbox '" + label + "' was unselected, now selected.");
        }
    }
}