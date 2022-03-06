package Pages;

import StepDefinitions.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseTest {

    public HomePage() {
        super.setup();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Добавить в избранное']")
    WebElement favoriteLink;

    @FindBy(xpath = "(//a[@href='javascript:void(0);']//img)[1]")
    public WebElement favoriteIcon;

    @FindBy(xpath = "//a[text()='Избранное:']/following-sibling::span")
    WebElement favoriteCount;

    @FindBy(xpath = "//a[@id='favorites-link' and text()='Избранное:']")
    WebElement linkToFavorite;

    @FindBy(xpath = "//input[@id='search_value']")
    WebElement searchInput;


    /**
     * Set text to search input and press submit.
     *
     * @param text test data for searching
     */
    public void setSearchInput(String text) {
        if (searchInput.isDisplayed()) {
            searchInput.sendKeys(text);
            searchInput.submit();
        } else {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(favoriteLink));
            searchInput.sendKeys(text);
            searchInput.submit();
        }
    }

    /**
     * set locator for ad by details and create web element
     *
     *  @param adName test data for searching
     */
    public WebElement adDetails( String adName) {
        return driver.findElement(By.xpath("(//a[contains(text(),'" + adName + "')])[2]"));
    }

    /**
     * set locator for ads category by name and create web element
     *
     *  @param name test data for searching
     */
    public WebElement categoryName(String name) {
        return driver.findElement(By.xpath("//h3[text()='" + name + "']"));
    }

    /**
     * set locator for ad by name and create web element
     *
     *  @param name test data for searching
     */
    public WebElement adName(String name) {
        return driver.findElement(By.xpath("//*[contains(text(), '" + name + "')]"));
    }

    /**
     * set locator for ads name and industry and create web element
     *
     *  @param adsName ads name
     *  @param industry name of industry
     */
    public WebElement jobsCategory(String adsName, String industry) {
        return driver.findElement(By.xpath("//label[text()='" + industry + "']/following-sibling::ul/.//a[text()='" + adsName + "']"));
    }

    /**
     * click to category link by name
     *
     *  @param categoryName name of category
     */
    public void clickCategoryByName(String categoryName) {
        categoryName(categoryName).click();
    }

    /**
     * click to ads link by name and category
     *
     *  @param jobsName ads name
     *  @param industry ads industry
     */
    public void clickJobsByName(String jobsName, String industry) {
        jobsCategory(jobsName, industry).click();
    }

    /**
     * click to ads link for opening more details by name of ad
     *
     *  @param name name of ad record (details)
     */
    public void clickAdByName(String name) {
        new Actions(driver).
                moveToElement(adName(name)).moveByOffset(0,0).click().build().perform();
    }

    /**
     * hover to ads record by name
     *
     *  @param name name of ad record (details)
     */
    public void hoverToRecord(String name) {
        new Actions(driver).
                moveToElement(adName(name)).build().perform();
    }

    /**
     * press to 'Add to favorite' which located inside record
     */
    public void clickAdToFavorite() {
        if (favoriteLink.isDisplayed()) {
            new Actions(driver).
                    moveToElement(favoriteLink).click().build().perform();
        } else {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(favoriteLink));
            new Actions(driver).
                    moveToElement(favoriteLink).click().build().perform();
        }
    }

    /**
     * get count of added favorite ads
     */
    public int getFavoriteCount() {
        return Integer.parseInt(favoriteCount.getText());
    }

    /**
     * get ads details from table
     */
    public String getAdDetails(String adName) {
        return adDetails(adName).getText();
    }

    /**
     * press to 'Favorites' button
     */
    public void clickToFavoriteLink() {
        linkToFavorite.click();
    }
}
