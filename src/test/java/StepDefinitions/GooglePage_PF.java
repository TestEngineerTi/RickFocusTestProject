package StepDefinitions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class GooglePage_PF extends BaseTest{

    public GooglePage_PF() {
        super.setup();
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "q")
    @CacheLookup
    WebElement searchFiled;


    public void enterTextToSearchField(String text) {
        this.searchFiled.sendKeys(text);
    }

    public void pressSearchButton() {
        this.searchFiled.sendKeys(Keys.ENTER);
    }
}
