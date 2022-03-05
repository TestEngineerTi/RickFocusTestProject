package StepDefinitions;

import io.cucumber.java.en.*;

import static StepDefinitions.BaseTest.driver;

public class GoogleSearchSteps_PF  {

    GooglePage_PF googlePage_pf = new GooglePage_PF();

    @Given("go to main page")
    public void goToMainPage(){
        driver.get("https://www.google.com");
    }

    @Given("user is on search page")
    public void user_is_on_search_page() {
        System.out.println("Inside step - user is on search page");
    }
    @When("^user enters a (.*) in search box$")
    public void user_enters_a_text_in_search_box(String text) {
        googlePage_pf.enterTextToSearchField(text);
        System.out.println("Inside step - user enters a text in search box");
    }
    @And("hits enter")
    public void hits_enter() {
        googlePage_pf.pressSearchButton();
        System.out.println("Inside step - hits enter");
    }

    @Then("user is navigated ti search results")
    public void user_is_navigated_ti_search_results() {
        driver.getPageSource().contains("Online Courses");
        System.out.println("Inside step - user is navigated ti search results");
    }
}
