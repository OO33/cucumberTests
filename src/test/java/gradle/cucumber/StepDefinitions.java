package gradle.cucumber;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.*;

public class StepDefinitions {
    
	WebDriver driver;

   /* @Then("I open Firefox")
    public void i_open_firefox() 
    {
        driver = new FirefoxDriver();
        driver.get("http://www.google.com");
    }
    
    @When("I search Hello World")
    public void i_search_hello_world()
    {
    	WebElement recherche = driver.findElement(By.name("q"));
    	recherche.sendKeys("Hello World" + Keys.ENTER);
    }
    
    @When("I open Chrome")
    public void i_open_chrome() 
    {
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
    }
    
    @Then("I close the browser")
    public void i_close_the_browser()
    {
    	driver.quit();
    }
    
    @Given("I open IE")
    public void i_open_IE() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }*/


    /*@Before
    public void openBrowser()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }*/

    @Given("I open {string}")
    public void i_open_browser(String browser) {
        if(browser == null) {
            driver = new ChromeDriver();
        }
        else if(browser.equals("chrome"))
        {
            driver = new ChromeDriver();
        }
        else if(browser.equals("firefox"))
        {
            driver = new FirefoxDriver();
        }
    }

    /*@FindBy(id = "searchInput")
    WebElement barreRecherche;

    @FindBy(id = "searchButton")
    WebElement buttonRecherche;

    @FindBy(id = "firstHeading")
    WebElement title;*/

    @After
    public void closeBrowser()
    {
        driver.quit();
    }

    @Given("I open wikipedia")
    public void i_open_wikipedia() {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");

        //throw new PendingException();
    }

   @When("I search {string}")
    public void i_search(String text) {
        WebElement barreRecherche = driver.findElement(By.id("searchInput"));
        barreRecherche.sendKeys(text);
        barreRecherche.sendKeys(Keys.ENTER);

        //barreRecherche.sendKeys(Keys.ENTER);
        //buttonRecherche.click();

        //throw new PendingException();
    }

    /*@Then("I should see {string} in the title")
    public void i_should_see_in_the_title(String text) {
        WebElement title = driver.findElement(By.id("firstHeading"));
        Assert.assertEquals(text, title.getText());
        //throw new PendingException();
    }*/

    @Then("I should see {string} in the title")
    public void i_should_see_articleTitle_in_the_title(String text) {
        WebElement title = driver.findElement(By.id("firstHeading"));
        Assert.assertEquals(text, title.getText());
    }
}
