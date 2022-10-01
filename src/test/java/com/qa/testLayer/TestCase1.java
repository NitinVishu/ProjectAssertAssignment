package com.qa.testLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.testBaseLayer.TestBase;

public class TestCase1 extends TestBase {
	
	@Test(priority=1)
	public void ValidationOfCountry() throws InterruptedException {
		//Details from IMDB
		pushpaImdb.imdbPortal();
		pushpaImdb.enterMovName("Pushpa: The Rise - Part 1");
		pushpaImdb.ClickResult1();
		pushpaImdb.scrollDown();
		
		pushpaImdb.statusCountryIMDB();
		
     	//Details from Wikipedia
		pushWiki.wikiPortal();
		pushWiki.searchMovie("Pushpa: The Rise - Part 1");
		pushWiki.scrollDown();		
		pushWiki.statusRelWik();
		pushWiki.statusCountryWiki();
		
						
		//Assertion for Country validation
		Assert.assertEquals(pushpaImdb.statusCountryIMDB(), pushWiki.statusCountryWiki());
		System.out.println("WOW....Country Validation is passed..!!");
		
	}
	
	@Test(priority=2)
	public void ValidationOfDate() throws InterruptedException {
			
								//Details from IMDB
		pushpaImdb.imdbPortal();
		pushpaImdb.enterMovName("Pushpa: The Rise - Part 1");
		pushpaImdb.ClickResult1();
		pushpaImdb.scrollDown();
		pushpaImdb.clickOnDate();
		pushpaImdb.statusRelease();
		System.out.println("Date from imdb: "+pushpaImdb.statusRelease());
		
		
     							//Details from Wikipedia
		pushWiki.wikiPortal();
		pushWiki.searchMovie("Pushpa: The Rise - Part 1");
		pushWiki.scrollDown();		
		pushWiki.statusRelWik();
		System.out.println("Date from wiki: "+pushWiki.statusRelWik());
								
		//Assertion for Release Date validation
		Assert.assertEquals(pushpaImdb.statusRelease(), pushWiki.statusRelWik());
		
		
	}	

}
