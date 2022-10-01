package com.qa.pageLayer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBaseLayer.TestBase;

public class IMDB extends TestBase {
	
	public IMDB() {
		PageFactory.initElements(driver,this);
	}
	
	public void imdbPortal() {
	driver.get("https://www.imdb.com/");
	}
	
	@FindBy(xpath="//input[@placeholder='Search IMDb']")
	private WebElement search_box;
	public void enterMovName(String imdbName) {
		search_box.sendKeys(imdbName+Keys.ENTER);
	}
	
	@FindBy(xpath="//a[text()='Pushpa: The Rise - Part 1']")
	private WebElement search_rslt1;
	public void ClickResult1() throws InterruptedException {
		search_rslt1.click();
	}
	
	@FindBy(xpath="//a[text()='December 17, 2021 (United States)']")
	private WebElement scroll_down;
	public void scrollDown() throws InterruptedException {
		Point pc = scroll_down.getLocation();
		int y = pc.getY();		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 6146)");	
		
	}	

	@FindBy(xpath="//a[text()='December 17, 2021 (United States)']")
	private WebElement relDate_click;
	public void clickOnDate() throws InterruptedException {		
		relDate_click.click();	
			}
	
	@FindBy(xpath="//td[text()='17 December 2021']")
	private WebElement statusRelease_imdb;
	public String statusRelease() throws InterruptedException{		
		String releaseIMDB = statusRelease_imdb.getText();
		return releaseIMDB;		
	}
	
	public void navigateBack() throws InterruptedException {
		driver.navigate().back();
		Thread.sleep(2000);
	}
	
	@FindBy(linkText="India")
	private WebElement statusCountry_imdb;
	public String statusCountryIMDB() {
		String countryIMDB=statusCountry_imdb.getText();
		return countryIMDB;
	}

}
