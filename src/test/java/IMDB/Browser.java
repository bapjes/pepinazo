package IMDB;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class Browser {
    protected WebDriver driver;
    protected WebDriverWait wait;



    public void openBrowser() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);
    }


    public void closeBrowser() {
        driver.quit();

    }


    protected void goToPage(String url)
    {
        openBrowser();
        driver.get(url);
    }

    protected boolean waitElementvisible(By locator)
    {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        }
        catch(Exception e)
        {
            Assert.fail("Element was not found \n");
            return false;
        }
    }

    protected void validateHomePage() {
        By logo = By.cssSelector("#home_img_holder");
        waitElementvisible(logo);

        //search text are
        By search = By.cssSelector("[name=\"q\"]");
        waitElementvisible(search);

        //assertEquals(driver.getTitle(),"");
        System.out.println("You are on IMDB page");
    }

    protected void  clickElement(By locator)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }


    private void selectMenuoption(String option) {
        boolean found = false;

        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@id = \"navbar-search-category-select-contents\"]//a")));
        System.out.println("Options in the Menu :  " + options.size());
        for (WebElement element :options )
        {
          if (element.getText().equals(option.trim()))
            {
                found = true;
                element.click();
                break;
            }
        }
        assertTrue("The option '" + option + "' was not found in the menu", found);
    }


    protected void inputText(By locator,String texto) {
        waitElementvisible(locator);
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(texto);
    }

    protected void searchBy(String option)
    {
        By searchLabel = By.xpath("//form[@id= \"nav-search-form\"]//label");
        clickElement(searchLabel);

        selectMenuoption(option.trim());
        System.out.println("Search by : " + driver.findElement(searchLabel).getText());
        //assertEquals("The search by " + option + " fails",option.trim(),driver.findElement(searchLabel).getText().trim());
    }

     protected void displayMoviesBy(String movie,String option)
    {
        By searchText = By.xpath("//*[@id=\"suggestion-search\"]");
        inputText(searchText,movie);

        By searchButton = By.id("suggestion-search-button");
        clickElement(searchButton);

        List<WebElement> movies = driver.findElements(By.cssSelector("td.result_text"));
        System.out.println("The '" + movie + "' movie was found in the following option : " + option);
        for(WebElement element: movies) {
            System.out.println(element.getText());
            }
        closeBrowser();
    }
}
