package HotelSearchTest;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

import org.openqa.selenium.WebDriver;

public class Parameters {

	WebDriver driver=new ChromeDriver();
	String URL=("https://www.almosafer.com/en");
	
	String []ArabicCities= {"دبي","جدة"};
	String []EnglishCities= {"Dubai","Jeddah","Riyadh"};
	
	Random rand=new Random();
	
	int RandomArabicCity=rand.nextInt(ArabicCities.length);
	int RandomEnglishCity=rand.nextInt(EnglishCities.length);
	
	int VisitorNumber=rand.nextInt(2);
}
