import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * This class will contain a test for initializing a
 * new Proposal in Summit.
 *
 */
public class SummitTest {

  private WebDriver driver;

  private static final String SUMMIT_MASTER_URL = "https://master-app.summit-qa.research.vt.edu";

  //Enter the username for the Summit account you create here
  private static final String USERNAME = "fletcher";

  //Enter the password for the Summit account you create here
  private static final String PASSWORD = "fletcher";

  @Before
  public void setup() {
    driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    // And now use this to visit Summit
    driver.get(SUMMIT_MASTER_URL);
  }

  /**
   * Test to see that a registered user can successfully initiate
   * a new proposal.
   *
   * @TODO - Complete this test
   */
  @Test
  public void testSummitProposalInitiation() throws Exception {

    login();

    //Perform proposal initiation

    logout();
  }

  @After
  public void tearDown() {
    driver.close();
  }

  /**
   * Perform login to Summit.
   */
  private void login() {
    WebElement e = driver.findElement(By.id("j_username"));
    e.sendKeys(USERNAME);

    e = driver.findElement(By.id("j_password"));
    e.sendKeys(PASSWORD);

    e = driver.findElement(By.tagName("form"));
    e.submit();

  }

  /**
   * Perform logout from Summit.
   */
  private void logout() {
    WebElement e = driver.findElement(By.id("user-link"));
    e.click();

    e = driver.findElement(By.id("logout-link"));
    e.click();

  }
}
