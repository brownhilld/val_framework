package wiki_framework;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Valtech_Home {


	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
	
	    //String LANG = args[0];
	    //String SEARCH_TEXT = args[1];
	    						
		// Create a new instance of the FireFox driver
		WebDriver driver = new FirefoxDriver();
 
		// Storing the valtech Url in a variable
		String url = "https://www.valtech.co.uk//";

		//manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		
		//STEP 1
		driver.get(url);		
		
		if(driver.getPageSource().contains("Latest News"))
		{
		    System.out.println("Latest News Found");
		}

		else
		{
		    System.out.println("Latest News Not Found");
		}

		
		driver.findElement(By.cssSelector("a[href*='services']")).click();		
						
	    List<WebElement> servicesHeader = driver.findElements(By.xpath("//h1[contains(text(), 'Services')]"));
	    
	    
	    if(servicesHeader.size() > 0)
	    {
	        System.out.println("Found h1 header Services");
	    }	
	    else
	    	System.out.println("Not Found h1 header Services");
		
	    driver.navigate().back();	    
	    
		driver.findElement(By.cssSelector("a[href*='cases']")).click();		
		
	    List<WebElement> casesHeader = driver.findElements(By.xpath("//h1[contains(text(), 'Work')]"));
	    if(casesHeader.size() > 0)
	    {
	        System.out.println("Found h1 header Cases");
	    }
	    else
	    	System.out.println("Not Found h1 header Cases");
		
	    driver.navigate().back();	    
	    
		driver.findElement(By.cssSelector("a[href*='jobs']")).click();		
		
	    List<WebElement> jobsHeader = driver.findElements(By.xpath("//h1[contains(text(), 'Careers')]"));
	    if(jobsHeader.size() > 0)
	    {
	        System.out.println("Found h1 header Jobs");
	    }	
	    else
	    	System.out.println("Not Found h1 header Jobs");
	    
	    driver.navigate().back();
	    
	    String offices = driver.findElement(By.cssSelector("p.foot__offices")).getText();	    
	    
	    int count = 0;
	    for (int i=0; i < offices.length(); i++)
	    {
	        if (offices.charAt(i) == '|')
	        {
	             count++;
	        }
	    }
	    
	    //Number of offices
	    System.out.println (count + 1);
	    
	    driver.quit();
		
	}

}
