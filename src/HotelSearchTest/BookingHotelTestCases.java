package HotelSearchTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BookingHotelTestCases extends Parameters{

	
@BeforeTest
	
	public void mySetup() {
	driver.get(URL);
	driver.manage().window().maximize();
	WebElement popMsg=driver.findElement(By.cssSelector(".sc-iBmynh.izXFRL"));
	
	if (popMsg.isDisplayed()) {
		WebElement SarButton=driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
		SarButton.click();
	}
	
}
	
	@Test (priority=1)
	
	public void RandomlySelectHotelandCity () {
		
		WebElement HotelTab=driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
	    HotelTab.click();
	    WebElement SearchCityInput=driver.findElement(By.xpath("//input[@data-testid='AutoCompleteInput']"));
	    if (driver.getCurrentUrl().contains("en")) {
	     	SearchCityInput.sendKeys(EnglishCities[RandomEnglishCity]);
	     	WebElement ResultList=driver.findElement(By.xpath("//ul[@data-testid='AutoCompleteResultsList']"));
	     	ResultList.findElements(By.tagName("li")).get(1).click();
	     	    	
	    }else {
	    	SearchCityInput.sendKeys(ArabicCities[RandomArabicCity]);
	    	WebElement ResultList=driver.findElement(By.xpath("//ul[@data-testid='AutoCompleteResultsList']"));
	    	ResultList.findElements(By.tagName("li")).get(1).click();
	    	
	    }
	    
	
	}
	@Test (priority=2)
	public void RandomVisitors() {
		
		WebElement SelectVistorsNumber=driver.findElement(By.xpath("//select[@data-testid='HotelSearchBox__ReservationSelect_Select']"));
		Select selector=new Select(SelectVistorsNumber);
		
		selector.selectByIndex(VisitorNumber);
		
		WebElement SearchButton=driver.findElement(By.xpath("//button[@data-testid='HotelSearchBox__SearchButton']"));
		SearchButton.click();
	}
}
