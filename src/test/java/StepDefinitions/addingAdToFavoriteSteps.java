package StepDefinitions;

import Pages.HomePage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Constants.Constants.Path.PATH_TO_TEST_DATA;
import static Constants.Constants.Urls.MAIN_PAGE_URL;
import static Constants.Constants.Urls.VACANCIES_URL;
import static StepDefinitions.BaseTest.driver;

public class addingAdToFavoriteSteps {

    HomePage homePage = new HomePage();

    @Given("Go to main page")
    public void goToMainPage(){
        driver.navigate().to(MAIN_PAGE_URL);
    }

    @And("Go to vacancies page")
    public void goToVacanciesPage(){
        driver.navigate().to(VACANCIES_URL);
    }

    @Given("^Go to (.*) category$")
    public void goToCategory(String categoryName) {
        homePage.clickCategoryByName(categoryName);
    }

    @When("^Click by (.*) job in (.*) industry$")
    public void clickToJobsName(String jobsName, String industry) {
        homePage.clickJobsByName(jobsName, industry);
    }

    @And("^Open (.*) details$")
    public void openDetailRecord(String name) {
        homePage.clickAdByName(name);
    }

    @And("^Hover to (.*) record$")
    public void hoverToRecord(String name) {
        homePage.hoverToRecord(name);
    }

    @And("Click to favorite icon")
    public void clickToFavoriteIcon() {
        if (homePage.favoriteIcon.isDisplayed()) {
            new Actions(driver).
                    moveToElement(homePage.favoriteIcon).click().build().perform();
        } else  {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(homePage.favoriteIcon));
            new Actions(driver).
                    moveToElement(homePage.favoriteIcon).click().build().perform();
        }
    }

    @And("Add ad to favorite")
    public void addToFavorite() {
        homePage.clickAdToFavorite();
    }

    @Then("Check that ad added to favorite increase favorite count")
    public void checkFavoriteCount() {
        int count = homePage.getFavoriteCount();
        Assert.assertEquals(1, count);
    }

    @And("Go to Favorite")
    public void goToFavorite() {
        homePage.clickToFavoriteLink();
    }

    @Then("Check that ad added to favorite")
    public void checkThatAdAddedToFavorite() {
        String expectedDetailsForFirstRecord = BaseTest.readJson(PATH_TO_TEST_DATA, "details", "first job");
        String expectedSpecForFirstRecord = BaseTest.readJson(PATH_TO_TEST_DATA, "specialization", "first job");

        String expectedDetailsForSecondRecord = BaseTest.readJson(PATH_TO_TEST_DATA, "details", "second job");
        String expectedSpecForSecondRecord = BaseTest.readJson(PATH_TO_TEST_DATA, "specialization", "second job");


        String[] actualSpecialization = homePage.getAdDetails("Операторы").split(",");
        String actualDetails = actualSpecialization[1];

        Assert.assertEquals(expectedSpecForFirstRecord, actualSpecialization[0]);
        Assert.assertEquals(expectedDetailsForFirstRecord, actualDetails.trim());

        String[] actualSpecializationForSecondRecord = homePage.getAdDetails("Участники анкетирования").split(",");
        String actualDetailsForSecondRecord = actualSpecializationForSecondRecord[1];

        Assert.assertEquals(expectedSpecForSecondRecord, actualSpecializationForSecondRecord[0]);
        Assert.assertEquals(expectedDetailsForSecondRecord, actualDetailsForSecondRecord.trim());
    }

    @Then("^Check that (.*) ad one record added to favorite$")
    public void checkThatAdAddedOneRecordToFavorite(String searchText) {
        switch (searchText) {
            case ("Операторы") -> {
                String expectedDetailsForFirstRecord = BaseTest.readJson(PATH_TO_TEST_DATA, "details", "first job");
                String expectedSpecForFirstRecord = BaseTest.readJson(PATH_TO_TEST_DATA, "specialization", "first job");
                String[] actualSpecialization = homePage.getAdDetails("Операторы").split(",");
                String actualDetails = actualSpecialization[1];
                Assert.assertEquals(expectedSpecForFirstRecord, actualSpecialization[0]);
                Assert.assertEquals(expectedDetailsForFirstRecord, actualDetails.trim());
            }
            case ("Участники анкетирования") -> {
                String expectedDetailsForSecondRecord = BaseTest.readJson(PATH_TO_TEST_DATA, "details", "second job");
                String expectedSpecForSecondRecord = BaseTest.readJson(PATH_TO_TEST_DATA, "specialization", "second job");
                String[] actualSpecializationForSecondRecord = homePage.getAdDetails("Участники анкетирования").split(",");
                String actualDetailsForSecondRecord = actualSpecializationForSecondRecord[1];
                Assert.assertEquals(expectedSpecForSecondRecord, actualSpecializationForSecondRecord[0]);
                Assert.assertEquals(expectedDetailsForSecondRecord, actualDetailsForSecondRecord.trim());
            }
        }
    }

    @Given("^Set (.*) to search input$")
    public void setSearchText(String text) {
        homePage.setSearchInput(text);
    }
}
