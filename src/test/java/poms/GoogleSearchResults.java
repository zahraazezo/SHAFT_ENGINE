package poms;

import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Assertions;
import com.shaft.validation.Assertions.AssertionComparisonType;
import com.shaft.validation.Assertions.AssertionType;
import com.shaft.validation.Verifications;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchResults {
    WebDriver driver;
    By resultsStats_label = By.id("appbar");
    By next_button = By.xpath("//table[@id='nav']//span[contains(.,'Next')]");
    By searchResult_box = By.xpath("//div[@class='srg']//div[@class='g']");

    public GoogleSearchResults(WebDriver driver) {
        this.driver = driver;
    }

    public void assertResultsStatsExistsAndIsNotEmpty() {
        Assertions.assertElementAttribute(driver, resultsStats_label, "Text", "", AssertionComparisonType.EQUALS,
                AssertionType.NEGATIVE);
    }

    public void verifyResultsStatsExists() {
        Verifications.verifyElementExists(driver, resultsStats_label, Verifications.VerificationType.POSITIVE);
    }

    public void clickNext() {
        ElementActions.click(driver, next_button);
    }

    public void assert10ResultsPerPage() {
        Assertions.assertEquals(10, ElementActions.getElementsCount(driver, searchResult_box));
    }

}
