package StepDefinitions;

import Pages.HomePage;
import io.cucumber.java.en.*;
import org.junit.Assert;

import static Constants.Constants.Urls.MAIN_PAGE_URL;
import static StepDefinitions.BaseTest.driver;

public class MainPage {

    HomePage homePage = new HomePage();

    @Given("Go to main page")
    public void goToMainPage(){
        driver.navigate().to(MAIN_PAGE_URL);
    }

    @Given("Go to category")
    public void goToCategory() {
        homePage.clickCategoryByName();
    }

//    @When("^user enters a (.*) in search box$")
//    public void user_enters_a_text_in_search_box(String text) {
//        homePage.clickCategoryByName();
//    }

    @When("click by jobs name")
    public void clickToJobsName() {
        homePage.clickJobsByName();
    }

    @And("open details")
    public void openDetailRecord() {
        homePage.clickAdByName();
    }

    @And("add ad to favorite")
    public void addToFavorite() {
        homePage.clickAdToFavorite();
    }

    @Then("check that ad added to favorite increase favorite count")
    public void checkFavoriteCount() {
        int count = homePage.getFavoriteCount();
        Assert.assertEquals(1, count);
    }
}
