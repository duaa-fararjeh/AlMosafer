package HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTestCases extends Parameters{
	
	@BeforeTest
	
	public void mySetup() {
		driver.manage().window().maximize();
		driver.get(URL);
		WebElement popMsg=driver.findElement(By.cssSelector(".sc-iBmynh.izXFRL"));
		
		if (popMsg.isDisplayed()) {
			WebElement SarButton=driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
			SarButton.click();
		}
		
		
		
	}
	
	
	@Test
	
	public void CheckTheDefualtLanguageIsCorect () {
		
		String ActualLanguage=driver.findElement(By.tagName("html")).getAttribute("lang");
		myAssert.assertEquals(ActualLanguage, ExpectedLanguage);
		
	}

	@Test
	
	public void CheckTheCurrenyIsCorrect () {
		
		String ActualCurrecy=driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']")).getText();
		
		myAssert.assertEquals(ActualCurrecy, ExpectedCurrency);
		
	}
	
@Test
	
	public void CheckTheContactNumber () {
		
		String ActualNumber=driver.findElement(By.tagName("strong")).getText();
		myAssert.assertEquals(ActualNumber, ExpectedNumber);
		
	}
}
