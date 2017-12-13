package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Driver;

public class OrderPage {
	private WebDriver driver;
	
	public OrderPage(){
		this.driver = Driver.getInstance();
		PageFactory.initElements(driver, this);
	}
	
	public void addQuantities(int position, int count){
		WebElement quantityInputBox = ordersTable.findElement(By.xpath("//tbody//tr["+ position +"]//td[5]//input[2]"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(quantityInputBox));
		quantityInputBox.click();
		quantityInputBox.clear();
		quantityInputBox.sendKeys(String.valueOf(1+count)+Keys.ENTER);
	}
	
	public double getUnitPrice(int position){
		String price = ordersTable.findElement(By.xpath("//table[@id=\"cart_summary\"]//tbody//tr["+ position +"]//td[4]//span[1]/span")).getText();
		price = price.substring(1);
		return Double.valueOf(price);
	}
	
	public double getTotalPriceOfAnItem(int position){
		String price = ordersTable.findElement(By.xpath("//table[@id=\"cart_summary\"]//tbody//tr["+ position +"]//td[6]//span")).getText();
		price = price.substring(1);
		return Double.valueOf(price);
	}
	
	public double getSumOfPrices(int countOfItems){
		String[] prices = new String[countOfItems];
		for(int position=1; position<=countOfItems; position++){
			String price = ordersTable.findElement(By.xpath("//table[@id=\"cart_summary\"]//tbody//tr["+ position +"]//td[6]//span")).getText();
			prices[position-1] = price.substring(1);
		}
		double sum = 0;
		for(String price : prices){
			sum+=Double.valueOf(price);
		}
		return sum;
	}
	
	public double getTotalProductsPrice(){
		String price = ordersTable.findElement(By.xpath("//table[@id=\"cart_summary\"]//tfoot//tr[1]//td[3]")).getText();
		price = price.substring(1);
		return Double.valueOf(price);
	}
	
	@FindBy(id="summary_products_quantity")
	public WebElement shoppingCartSummaryMessage;
	
	@FindBy(xpath="//table[@id=\"cart_summary\"]")
	public WebElement ordersTable;
	
}
