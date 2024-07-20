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
		myAssert.assertEquals(ActualLanguage, ExpectedEnglishLanguage);
		
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

public void checkDepatureAndReturnDate() {

	// we create an object called today of the class of local date 
			LocalDate today = LocalDate.now();

			// from the same class (localdate) we extracted the date plus 1 (and the results
			// we need only the day of the month we don't need the whole date for example
			// today is 18 + 1 = 19 i got that 19)
			int tomorrow = today.plusDays(1).getDayOfMonth();
			// from the same class (localdate) we extracted the date plus 2 (and the results
			// we need only the day of the month we don't need the whole date for example
			// today is 18 + 2 = 20 i got that 20)
			int theDayAfterTomorrow = today.plusDays(2).getDayOfMonth();

			// we visited the website and we got the depature date and the return date as
			// webelements and from those webelements we extracted the String (
			// getTextMethod())
			String ActualDepatureDateOnTheWebSite = driver
					.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-kqlzXE gmaGJq'] span[class='sc-cPuPxo dVqOVe']"))
					.getText();
			String ActualReturnDateOnTheWebSite = driver
					.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-OxbzP bkqiMc'] span[class='sc-cPuPxo dVqOVe']"))
					.getText();
			
			// we need to convert the String to integer through Integer.parseInt() and we named the variables with 
			// AsNumber to know that the string now is as an integer 

			int ActualReturnDateOnTheWebsiteAsNumber = Integer.parseInt(ActualReturnDateOnTheWebSite);
			int ActualDepatureDateOnTheWebsiteAsNumber = Integer.parseInt(ActualDepatureDateOnTheWebSite);

			
			// we do our assertion by compare 2 integer together ( actualdepaturedate = tomorrow ) 
			// and actual returndate = thedayafterTomorrow
			myAssert.assertEquals(ActualDepatureDateOnTheWebsiteAsNumber, tomorrow);
			myAssert.assertEquals(ActualReturnDateOnTheWebsiteAsNumber, theDayAfterTomorrow);

		}

@Test
public void ChangeLanguageRandomly() throws InterruptedException {
	
	driver.get(websites[randomWebsite]);
	
	if (driver.getCurrentUrl().contains("en")) {
		
		String ActualLanguage=driver.findElement(By.tagName("html")).getAttribute("lang");
		myAssert.assertEquals(ActualLanguage, ExpectedEnglishLanguage);
		
	}else {
		
		String ActualLanguage=driver.findElement(By.tagName("html")).getAttribute("lang");
		myAssert.assertEquals(ActualLanguage, ExpectedArabicLanguage);
			
			
		}
	}
	
	
}

