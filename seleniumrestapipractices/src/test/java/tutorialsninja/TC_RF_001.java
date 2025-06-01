package tutorialsninja;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_001 {
	@Test
	public static void registerPage() throws Exception {
		WebDriver driver = new ChromeDriver();
		//global wait applicable for all the elements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();	
		driver.findElement(By.id("input-firstname")).sendKeys("ThiruNagesh");

		driver.findElement(By.id("input-lastname")).sendKeys("Srinivasan");

		driver.findElement(By.id("input-email")).sendKeys(generateNewEmail());

		driver.findElement(By.id("input-telephone")).sendKeys("8072719663");

		driver.findElement(By.id("input-password")).sendKeys("13121997@Thiru");

		driver.findElement(By.id("input-confirm")).sendKeys("13121997@Thiru");

		driver.findElement(By.name("agree")).click();

		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();

		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());

		String accountCreated="Your Account Has Been Created!";
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText(),accountCreated );

		String p1 ="Congratulations! Your new account has been successfully created!";
		String p2="You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String p3="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String p4="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"content\"]/p[1]")).getText(),p1, p1);
		System.out.println(p1);


		String actualresultp2=driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]")).getText();
		Assert.assertEquals(actualresultp2,p2, p2);
		System.out.println(p2);

		String actualresultp3=driver.findElement(By.xpath("//*[@id=\"content\"]/p[3]")).getText();
		Assert.assertEquals(actualresultp3,p3, p3);
		System.out.println(p3);
		String actualresultp4=driver.findElement(By.xpath("//*[@id=\"content\"]/p[4]")).getText();
		Assert.assertEquals(actualresultp4,p4, p4);
		System.out.println(p4);
		
		System.out.println("Register page has been automated successfully");
	}


	public static String generateNewEmail() {
		return new Date().toString().replaceAll("[\\s:]", "") + "@thiru.com";
	}

}
