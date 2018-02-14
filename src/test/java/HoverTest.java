import api.ApiHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HoverPage;

import java.io.IOException;

import static org.testng.Assert.assertTrue;
import static setup.DriverSetup.getDriver;

/**
 * Created by sargis on 12/21/17.
 */
public class HoverTest extends BaseTest {
    private ChromeDriver driver;
    private HoverPage hoverPage;

    @BeforeMethod
    public void setUp() {
        hoverPage = new HoverPage();

    }

    @Test
    public void dropdownSelect() throws IOException {
        getDriver().get("http://development.click2sure.co.za");
        ((JavascriptExecutor)getDriver()).executeScript(String.format(
                "window.localStorage.setItem('ngStorage-user_auth','%s');", new ApiHelper().login("k2324@yopmail.com", "qwe123123")));
        getDriver().get("http://development.click2sure.co.za");
        assertTrue(hoverPage.isHeaderNotDisplayed(), "Header was visible!");
        hoverPage.hoverAvatar();
        assertTrue(hoverPage.isHeaderDisplayed(), "Header was not visible!");

        assertTrue(hoverPage.getHeader().getText().contains("name: user1"),
                "Header text was not correct!");
    }

}
