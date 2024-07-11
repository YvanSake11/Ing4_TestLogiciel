package org.example.page;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class RegisterPage extends Page{

    @FindBy(className = "style_input__dvx2f")
    private WebElement email_login;

    @FindBy(className = "style_input_password__6FtLe")
    private  WebElement motpasse_login;

    @FindBy(id = "btn_login")
    private WebElement connexion;
    private  By email_lod =By.className("style_input__dvx2f");
    private By password =By.className("style_input_password__6FtLe");
    private  By confirme_password=By.id("confirm_password_register");
    private  By inscription=By.className("style_btn__SUrW5");
    private  String  URL="https://ztrain-web.vercel.app/home";
    @Test()
    public  void singUp(){
        this.driver.get("https://ztrain-web.vercel.app/home");
        this.driver.findElement(By.id("style_avatar_wrapper__pEGIQ")).click();
        this.driver.findElement(By.cssSelector(".MuiTabs-scroller>div>button:nth-child(2)")).click();
        this.driver.findElement(email_lod).sendKeys("yvans@gmail11.com");
        this.driver.findElement(password).sendKeys("yg1c");
        this.driver.findElement(confirme_password).sendKeys("yg1c");
        this.driver.findElement(inscription).click();

    }
}
