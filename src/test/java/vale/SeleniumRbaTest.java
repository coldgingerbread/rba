package vale;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumRbaTest {

	public WebDriver driver;

	@BeforeTest
	public void initDriver() {
		String path = "src/test/resources/util/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void firstTest() throws InterruptedException {
		driver.get("http://www.rba.hr/");
		driver.findElement(By.linkText("Tečajni kalkulator")).click();
		Select dropdownFrom = new Select(driver.findElement(By.id("val1")));
		dropdownFrom.selectByValue("978");
		Select dropdownTo = new Select(driver.findElement(By.id("val2")));
		dropdownTo.selectByValue("826");
		Select dropdownType = new Select(driver.findElement(By.id("kurs")));
		dropdownType.selectByVisibleText("Kupovni");
		driver.findElement(By.id("suma1")).clear();
		driver.findElement(By.id("suma1")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.id("suma1")).sendKeys("40.00");
		Thread.sleep(2000L);
		String textExchange = driver.findElement(By.id("rateExch")).getText();
		String textAmount = driver.findElement(By.id("toHouseExch")).getText().replace("=", "dobijem");
		System.out.println("tečaj je " + textExchange + ", za " + textAmount);

	}

	@AfterTest
	public void tearDown() {
		// driver.close();
		// driver.quit();
	}

}
