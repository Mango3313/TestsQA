package seleniumtest.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FirstScriptTest {
    public static WebDriver driver;
    private static File path_to_addblock = new File("/Users/daft_/Documents/5.0.4_0");
    public static WebDriverWait wait;
    @BeforeSuite
    public static void settingEnvironment() {
    	System.setProperty("webdriver.edge.driver", "C://edgedriver//msedgedriver.exe");
    	EdgeOptions options = new EdgeOptions();
        options.addArguments("load-extension="+path_to_addblock.getAbsolutePath());
        driver = new EdgeDriver(options);
    	wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        int nTabs = driver.getWindowHandles().size();
        List<String> winHandles = new ArrayList<String>(nTabs);
        for(String s:driver.getWindowHandles()) winHandles.add(s);
        driver.switchTo().window(winHandles.get(0));
        driver.get("https://demoqa.com/automation-practice-form");
        wait.until(ExpectedConditions.titleIs("ToolsQA"));
    }

    @Test
    public void happyPath() throws InterruptedException {
    	//Check if the title is correct
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
        File file = new File("/Users/daft_/Pictures/images.jpg");
        pictureInput.sendKeys(file.getAbsolutePath());
        //currentaddress
        WebElement addressInput = driver.findElement(By.id("currentAddress"));
        addressInput.sendKeys("Asndanskjdnajsndjansdkjnakjsdnkansdjs");
        //stateandcity
        WebElement stateInput = driver.findElement(By.id("react-select-3-input"));
        stateInput.sendKeys("NCR");
        stateInput.sendKeys(Keys.ENTER);
        WebElement cityInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-4-input")));
        cityInput.sendKeys("Delhi");
        cityInput.sendKeys(Keys.ENTER);
        //submit
        WebElement searchButton = driver.findElement(By.id("submit"));
        searchButton.sendKeys(Keys.ENTER);
        
        wait.until(ExpectedConditions.elementToBeClickable(By.id("closeLargeModal")));
        actions.moveToElement(driver.findElement(By.id("closeLargeModal"))).click().perform();
        
    }
    
    @Test
    public void validateFirstNameEmpty() {
    	WebElement fiName = driver.findElement(By.id("firstName"));
    	String value = fiName.getText();
    	Reporter.log(value);
    	fiName.clear();
    	if(value.chars().allMatch(Character::isLetter) == false) 
    		throw new RuntimeException("The values of"
    			+ " the field firstName are not valid");
    }
    @Test
    public void validateFirstNameSpecial() {
    	WebElement fiName = driver.findElement(By.id("firstName"));
    	fiName.sendKeys("Al123#");
    	String value = fiName.getText();
    	Reporter.log(value);
    	fiName.clear();
    	if(value.chars().allMatch(Character::isLetter) == false) 
    		throw new RuntimeException("The values of"
    			+ " the field firstName are not valid");
    }
    @Test
    public void validateFirstName() {
    	WebElement fiName = driver.findElement(By.id("firstName"));
    	fiName.sendKeys("Alan");
    	String value = fiName.getText();
    	Reporter.log(value);
    	fiName.clear();
    	if(value.chars().allMatch(Character::isLetter) == false) 
    		throw new RuntimeException("The values of"
    			+ " the field firstName are not valid");
    }
    @AfterSuite
    public static void finishJob() {
    	driver.quit();
    }
}