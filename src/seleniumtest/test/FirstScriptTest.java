package seleniumtest.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class FirstScriptTest {
    public WebDriver driver;

    @BeforeEach
    public void preparation(){
        System.setProperty("webdriver.edge.driver", "C://edgedriver//msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        String title = driver.getTitle();
        Assertions.assertEquals("ToolsQA", title);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    @Test
    public void eightComponents() throws InterruptedException {
        //Set actions to perform operations over radio and check buttons
        Actions actions = new Actions(driver);
        /*Indentify webelements on page*/
        //name
        WebElement inputFirstName = driver.findElement(By.id("firstName"));
        inputFirstName.sendKeys("Jorge");
        WebElement inputLastName = driver.findElement(By.id("lastName"));
        inputLastName.sendKeys("Fuentes");
        //email
        WebElement inputEmail = driver.findElement(By.id("userEmail"));
        inputEmail.sendKeys("fake@mail.com");
        //gender
        WebElement inputGender1,inputGender2,inputGender3;
        inputGender1 = driver.findElement(By.id("gender-radio-1"));
        actions.moveToElement(inputGender1).click().perform();
        inputGender2 = driver.findElement(By.id("gender-radio-2"));
        actions.moveToElement(inputGender2).click().perform();
        inputGender3 = driver.findElement(By.id("gender-radio-3"));
        actions.moveToElement(inputGender3).click().perform();
        //mobile
        WebElement mobileNumber = driver.findElement(By.id("userNumber"));
        mobileNumber.sendKeys("0123456789");
        //dateOfBirth
        WebElement dateOfBirth = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirth.sendKeys("10 Sep 1997");
        //subjects
        WebElement subjectsInput = driver.findElement(By.id("subjectsInput"));
        subjectsInput.sendKeys("HelloWorld");
        //hobbies
        WebElement hobbiesInput1,hobbiesInput2,hobbiesInput3;
        hobbiesInput1= driver.findElement(By.id("hobbies-checkbox-1"));
        actions.moveToElement(hobbiesInput1).click().perform();
        hobbiesInput2 = driver.findElement(By.id("hobbies-checkbox-2"));
        actions.moveToElement(hobbiesInput2).click().perform();
        hobbiesInput3 = driver.findElement(By.id("hobbies-checkbox-3"));
        actions.moveToElement(hobbiesInput3).click().perform();
        //picture
        WebElement pictureInput = driver.findElement(By.id("uploadPicture"));
        //currentaddress
        WebElement addressInput = driver.findElement(By.id("currentAddress"));
        addressInput.sendKeys("Asndanskjdnajsndjansdkjnakjsdnkansdjs");
        //stateandcity
        WebElement stateInput = driver.findElement(By.id("react-select-3-input"));
        WebElement cityInput = driver.findElement(By.id("react-select-4-input"));
        //submit
        WebElement searchButton = driver.findElement(By.id("submit"));
        actions.moveToElement(searchButton).click().perform();

        Thread.sleep(5000);
        
        driver.quit();
    }
}