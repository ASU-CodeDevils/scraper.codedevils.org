import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class handleSearch{
    public static ArrayList<String> handleSearch(String link, String criteria){
        //New WebDriver with implicit wait of 5 seconds if elements aren't found on page
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Setup page and declare search variable cuz scope and stuff
        driver.get(link);
        WebElement searchField;


        //Try to find the search field via XPATH, to add functionality for more websites can add their specific XPATH to
        //try block via concatenation of the following string " | <xpath>"
        try{
            searchField = driver.findElement(By.xpath(
                    "//input[@type='text' or @type='search' or @placeholder[contains(., 'Search')]]"
            ));
        }catch(Exception e){
            return null;
        }

        //Since we found a search field, clear it, input criteria, submit to navigate to next page
        searchField.clear();
        searchField.sendKeys(criteria);
        searchField.submit();



        //Should now be on page where we can scrape for the links
        ArrayList<String> links = new ArrayList<>();


        //Loop is for changing pages if necessary
        boolean next = true;
        while(next) {

            //If we don't find a next button then we break the loop of changing pages
            WebElement nextButton = null;
            try{
                nextButton = driver.findElement(By.xpath("//a[@data-testid='pagination-page-next']"));
            }catch(Exception e){
                next = false;
            }



            //Isolate individual result elements into a list to iterate over
            List<WebElement> results = driver.findElements(By.xpath("//li[@class='css-1ac2h1w eu4oa1w0']"));

            //For every individual result, find its anchor tag and extract the href attribute.
            //That attribute holds the link we are looking for, so we add to outgoing list :)
            //NOTE: Some elements in the results do not have link or are filler try/catch ignores them
            for (WebElement result : results) {
                try {
                    String temp = result.findElement(By.tagName("a")).getAttribute("href");
                    links.add(temp);
                } catch (Exception ignored) {

                }
            }

            //Continue through the pages :)
            if(nextButton != null)
                driver.navigate().to(nextButton.getAttribute("href"));
        }

        //All done, success!!!!!
        driver.quit();
        return links;
    }
}

