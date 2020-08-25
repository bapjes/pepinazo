package IMDB;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class IMDBStepDefinitions extends Browser{


    @Given("I am in IMDB page")
    public void i_am_in_IMDB_page() {
        goToPage("https://www.imdb.com/");
        validateHomePage();
    }


    @When("I search by title")
    public void i_search_by_title() {
         searchBy("Titles");
     }

    @Then("It displays movies by the title")
    public void it_displays_movies_by_the_title() {
        displayMoviesBy("it","Titles");
    }

    @When("I search by episode")
    public void i_search_by_episode() {
        searchBy("TV Episodes");
    }

    @Then("It displays movies by episode")
    public void it_displays_movies_by_episode() {
        displayMoviesBy("it","TV Episodes");
    }

    @When("I search by company")
    public void I_search_by_company() {
        searchBy("Companies");
    }


    @When("It displays movies by company")
    public void it_displays_movies_by_company() {
        displayMoviesBy("it","Companies");
    }


    @When("I search by key word")
    public void i_search_by_key_word() {
        searchBy("Keywords");
    }

    @Then("It displays movies by the key word")
    public void it_displays_movies_by_the_key_word() {
        displayMoviesBy("it","Keywords");
    }

    @When("I search by celebs")
    public void i_search_by_celebs() {
        searchBy("Celebs");
    }

    @Then("It displays movies by celebs")
    public void it_displays_movies_by_celebs() {
        displayMoviesBy("it","Celebs");
    }



    /*@Then("It displays movies by genre")
    public void it_displays_movies_by_genre() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }*/

}
