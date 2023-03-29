package vale;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
	public void firstTest() {
		driver.get("http://www.rba.hr/");
		driver.findElement(By.linkText("Tečajni kalkulator")).click();
	}
	
	@AfterTest
	public void tearDown() {
		//driver.close();
		//driver.quit();
	}

}
