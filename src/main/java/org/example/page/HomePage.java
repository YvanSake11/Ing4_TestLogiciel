package org.example.page;

import jdk.jfr.Description;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends Page {
    @FindBy(css = "nav>div:nth-child(4)")
    private WebElement avatar;

    @FindBy(className = "style_input__dvx2f")
    private  WebElement email_login;

    @FindBy(className = "style_input_password__6FtLe")
    private  WebElement motpasse_login;

    @FindBy(id = "btn_login")
    private WebElement connexion;



    @FindBy(css = ".style_card__gNEqX")
    private List<WebElement> articleCards;

    private  String  URL="https://ztrain-web.vercel.app/home";
   /* public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    */
    public  void  navigate(){
        this.get(URL);
    }
    public void  fillemail(String email){
        this.email_login.sendKeys(email);
    }
    public void  fillpassword(String motpasse){
        this.motpasse_login.sendKeys(motpasse);
    }

    public void login(String email , String motpasse){

        this.fillemail(email);
        this.fillpassword(motpasse);
        this.connexion.click();
    }

    public List<WebElement> getArticleCards() {
        return articleCards;
    }

    public void clickArticleCard(WebElement articleCard) {
        articleCard.click();
    }
}

