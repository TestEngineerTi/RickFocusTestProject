package StepDefinitions;

import io.cucumber.java.After;

public class PostConditions extends BaseTest {

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
