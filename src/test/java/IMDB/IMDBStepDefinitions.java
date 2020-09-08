package IMDB;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class IMDBStepDefinitions {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Browser browser;

    @Before
    public void openBrowser() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);
        browser = new Browser(driver);
    }

    @After
    public void closeBrowser() {
        driver.quit();

    }


    @Given("I am in IMDB page")
    public void i_am_in_IMDB_page() {
        browser.goToPage("https://www.imdb.com/");
        browser.validateHomePage();
    }

    @When("I search by title")
    public void i_search_by_title() {
         browser.searchBy("Titles");
     }

    @Then("It displays movies by the title")
    public void it_displays_movies_by_the_title() {
        browser.displayMoviesBy("it","Titles");
    }

    @When("I search by episode")
    public void i_search_by_episode() {
        browser.searchBy("TV Episodes");
    }

    @Then("It displays movies by episode")
    public void it_displays_movies_by_episode() {
        browser.displayMoviesBy("it","TV Episodes");
    }

    @When("I search by company")
    public void I_search_by_company() {
        browser.searchBy("Companies");
    }


    @When("It displays movies by company")
    public void it_displays_movies_by_company() {
        browser.displayMoviesBy("it","Companies");
    }


    @When("I search by key word")
    public void i_search_by_key_word() {
        browser.searchBy("Keywords");
    }

    @Then("It displays movies by the key word")
    public void it_displays_movies_by_the_key_word() {
        browser.displayMoviesBy("it","Keywords");
    }

    @When("I search by celebs")
    public void i_search_by_celebs() {
        browser.searchBy("Celebs");
    }

    @Then("It displays movies by celebs")
    public void it_displays_movies_by_celebs() {
        browser.displayMoviesBy("it","Celebs");
    }



    /*@Then("It displays movies by genre")
    public void it_displays_movies_by_genre() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }*/

}
