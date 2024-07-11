package runners;

import io.cucumber.java.nl.Stel;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.example.page.*;
import org.openqa.selenium.bidi.storage.PartialCookie;
import org.testng.annotations.Test;
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html"

        },
        features = "src/test/resources/feature/accounte.feature",
        glue = {"stepdefinition","src/main/java/org/example/page"}
)
public class RunnersTest extends AbstractTestNGCucumberTests{
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage=new RegisterPage();
    HomePage homePage = new HomePage();
    LogoutPage logoutPage = new LogoutPage();



    @Test
    public  void loginPage() throws InterruptedException {
        loginPage.login();
    }
    @Test
    public  void LogoutPage() throws InterruptedException {
        logoutPage.logout();
    }
    @Test
    public  void  registerPage(){
        registerPage.singUp();
    }
    @Test
    public void homepage(){
        homePage.navigate();
    }

}
