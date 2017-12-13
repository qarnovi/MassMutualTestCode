package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Config;
import utilities.Driver;
import utilities.Page;

public class HomePage {
	private WebDriver driver;
	
	public HomePage(){
		this.driver = Driver.getInstance();
		PageFactory.initElements(driver, this);
	}
	
	public void navigateTo(){
		driver.get(Config.getProperty("URL"));
	}
	
	public void selectItemsToPurchase(int howMany){
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		for(int i=1; i<=howMany; i++){
			wait.until(ExpectedConditions.visibilityOf(productsTable.findElement(By.xpath("//ul[@id=\"homefeatured\"]//li["+i+"]//a//img"))));
			action.moveToElement(productsTable.findElement(By.xpath("//ul[@id=\"homefeatured\"]//li["+i+"]//a//img"))).
			moveToElement(productsTable.findElement(By.xpath("//ul[@id=\"homefeatured\"]//li["+i+"]//span[.='Add to cart']"))).click().build().perform();
			wait.until(ExpectedConditions.visibilityOf(addedToCartWindow));
			addedToCartWindow.click();
			Page.sleep(500);
		}
	}
	
	@FindBy(id="homefeatured")
	public WebElement productsTable;
	
	@FindBy(xpath="//span[@title='Close window']")
	public WebElement addedToCartWindow;
	
	@FindBy(xpath="//a[@title=\"View my shopping cart\"]")
	public WebElement shoppingCart;
	
	
}
