package HomePage;

import java.time.LocalDate;

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

@Test 

public void CheckQitafLogo () {
	
	WebElement Qitaflogo=driver.findElement(By.xpath("//div[@class='sc-fihHvN eYrDjb']//*[name()='svg']"));
	boolean ActualReslt=Qitaflogo.isDisplayed();
	myAssert.assertEquals(ActualReslt, true);
}

@Test
 
public void CheckHotel()
{
	WebElement HotelTab=driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
	String ActualResult=HotelTab.getAttribute("aria-selected");
	myAssert.assertEquals(ActualResult, "false");

}

@Test

public void CheckDepatureAndReturnDate() {
	
	LocalDate today=LocalDate.now();
	int tomorrow = today.plusDays(1).getDayOfMonth();
	int theDayAfterTomorrow=today.plusDays(2).getDayOfMonth();
	
	String TheDepartureDate=driver.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-kqlzXE blwiEW'] span[class='sc-cPuPxo LiroG']")).getText();
	int TheDepartureDateAsNumer=Integer.parseInt(TheDepartureDate);
	
	String TheReturnDate=driver.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-kqlzXE blwiEW'] span[class='sc-cPuPxo LiroG']")).getText();
	int TheReturnDateAsNumber=Integer.parseInt(TheReturnDate);
	
	myAssert.assertEquals(TheDepartureDateAsNumer, tomorrow);
	myAssert.assertEquals(TheReturnDateAsNumber, theDayAfterTomorrow);
	
}
}
