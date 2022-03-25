package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class LoginPage<userNames> {


    //InputDataFromSheet inputDataFromSheet = new InputDataFromSheet();
    WebDriver driver;
    By userName = By.xpath("//*[@id='user-name']");
    By password = By.xpath("//*[@id='password']");
    By loginButton = By.xpath("//*[@id='login-button']");
    By logout = By.xpath("//*[@id='logout_sidebar_link']");


    public void loginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterUsername(By userName){
         driver.findElement(userName).sendKeys();
    }
    public void enterPassword(){
        WebElement element2 = driver.findElement(password);
        element2.sendKeys();
    }
    public void clickLoginButton(){
        WebElement login = driver.findElement(loginButton);
        login.click();
    }
    public  void  addChart(){
        driver.findElement(By.xpath("//*[@class='product_sort_container']")).click();
        driver.findElement(By.xpath("//*[@value='hilo']")).click();
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
        Boolean enable = driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-fleece-jacket']")).isEnabled();
        if(enable){
            System.out.println("the button is enabled");
        }
        else {
            System.out.println("The button is enabled");
        }
        String amount = driver.findElement(By.xpath("//*[@id='inventory_container']/div/div[1]/div[2]/div[2]/div/text()[2]")).getText();
        String str=driver.findElement(By.id(amount)).getText();
        str=str.replace("$","");
        if(Float.parseFloat(str)<=100){
            driver.findElement(addToCart).click();
        }
        if(amt<=100){
            driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
        }
        else {

        }

        public void clickCart(){
            driver.findElement(By.xpath("//*[@class='shopping_cart_link']")).click();
        }
    }


    public static void main(String[] args) throws IOException, InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("");
        InputDataFromSheet inputDataFromSheet = new InputDataFromSheet();
        inputDataFromSheet.login(driver);


    }

}
