package Pages;

import StepDefinitions.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;

public class HomePage extends BaseTest {

    public HomePage() {
        super.setup();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3[text()='Вакансии']")
    WebElement categoryName;

    @FindBy(xpath = "//label[text()='Здравоохранение']/following-sibling::ul/.//a[text()='Другое']")
    WebElement jobsName;

    @FindBy(xpath = "//*[contains(text(), 'Участники анкетирования')]")
    WebElement adName;

    @FindBy(xpath = "//a[text()='Добавить в избранное']")
    WebElement favoriteLink;

    @FindBy(xpath = "//a[text()='Избранное:']/following-sibling::span")
    WebElement favoriteCount;

    public void clickCategoryByName() {
        categoryName.click();
    }

    public void clickJobsByName() {
        jobsName.click();
    }

    public void clickAdByName() {
        new Actions(driver).
                moveToElement(adName).moveByOffset(0,0).click().build().perform();
    }

    public void clickAdToFavorite() {
        if (favoriteLink.isDisplayed()) {
            new Actions(driver).
                    moveToElement(favoriteLink).click().build().perform();
        }
    }

    public int getFavoriteCount() {
        return Integer.parseInt(favoriteCount.getText());
    }
}
