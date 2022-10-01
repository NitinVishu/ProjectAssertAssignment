package com.qa.pageLayer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBaseLayer.TestBase;

public class Wikipedia extends TestBase {
	
	public Wikipedia() {
		PageFactory.initElements(driver,this);
	}
	
	public void wikiPortal() {
		driver.get("https://www.wikipedia.org/");
	}
	
	@FindBy(xpath="//input[@id='searchInput']")
	private WebElement searchBx_wiki;
	public void searchMovie(String wikiName) throws InterruptedException {
		searchBx_wiki.sendKeys(wikiName+Keys.ENTER);
		Thread.sleep(1000);
	}
	
	@FindBy(xpath="//li[contains(text(),'December')]")
	private WebElement scrollWiki_down;
	public void scrollDown() throws InterruptedException {
		//Point pc = scrollWiki_down.getLocation();
		//Thread.sleep(1500);
		//int y = pc.getY();
		//Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 450)");
	}
	
	@FindBy(xpath="//li[contains(text(),'December')]")
	private WebElement statusRelease_wiki;
	public String statusRelWik() {
		String relWiki = statusRelease_wiki.getText();
		return relWiki;
	}
	
	@FindBy(xpath="//td[text()='India']")
	private WebElement statusCountry_wiki;
	public String statusCountryWiki() {
		String StatusContryWiki = statusCountry_wiki.getText();
		return StatusContryWiki;		
	}

}
