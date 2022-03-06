package StepDefinitions;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;

import static java.util.concurrent.TimeUnit.SECONDS;


public abstract class BaseTest {

    protected static WebDriver driver;

    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver" );
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, SECONDS);
    }

    public static String readJson(String filePath, String value, String name) {
        String text = null;
        try {
            FileReader reader = new FileReader(filePath);

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            JSONObject structure = (JSONObject) jsonObject.get(name);
            text = structure.get(value).toString();
        } catch (IOException | ParseException | NullPointerException ex) {
            ex.printStackTrace();
        }
        return text;
    }
}
