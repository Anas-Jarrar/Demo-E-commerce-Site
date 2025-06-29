import java.nio.channels.SelectableChannel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyClassTest {
	
	WebDriver driver=new ChromeDriver();
	String TheWebsite="https://practicesoftwaretesting.com/";
	
	@BeforeTest
	public void MySetup() {
		driver.get(TheWebsite);
		driver.manage().window().maximize();
	}
	
	@Test
	public void FilterTest() {
		
		WebElement SortList=driver.findElement(By.cssSelector(".form-select"));
		Select myselect=new Select(SortList);
		myselect.selectByIndex(3);

        WebElement minHandle = driver.findElement(By.cssSelector(".ngx-slider-pointer-min"));
        WebElement maxHandle = driver.findElement(By.cssSelector(".ngx-slider-pointer-max"));
        WebElement SearchBar=driver.findElement(By.id("search-query"));
        WebElement SearchButton=driver.findElement(By.xpath("//button[@data-test='search-submit']"));
        SearchBar.sendKeys("Drill");
        SearchButton.click();
        Actions actions = new Actions(driver);

        actions.clickAndHold(minHandle).moveByOffset(60, 0).release().perform();
        actions.clickAndHold(maxHandle).moveByOffset(-20, 0).release().perform();
        
        String minValue = minHandle.getDomAttribute("aria-valuenow");
        String maxValue = maxHandle.getDomAttribute("aria-valuenow");
        Assert.assertEquals(minValue, "1");
        Assert.assertEquals(maxValue, "89");

	}
	
	
	
	
	@AfterTest
	public void After() {
		
		
		
		
	}
	
	
	

	
	

}
