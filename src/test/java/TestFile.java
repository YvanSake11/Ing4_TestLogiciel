import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;


public class TestFile {
    private WebDriver driver;
    String xpathExpression = "//div[@class='style_card__gNEqX']//img[contains(@src, 'Floor-Lamp-Tripod-PNG.png')]/ancestor::div[@class='style_card__gNEqX']";
    private By addToCartButtonLocator = By.id("style_btn_add_cart__gTXM7");

    private By articleCardLocator = By.cssSelector(".style_card__gNEqX");

    private  By email_lod =By.className("style_input__dvx2f");
    private By password =By.className("style_input_password__6FtLe");
    private  By confirme_password=By.id("confirm_password_register");
    private  By inscription=By.className("style_btn__SUrW5");
    private  String path ="src/test/resources/driver/chromedriver.exe";
    @BeforeTest public void setUp(){
        System.setProperty("webdriver.chrome.driver",this.path);
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File("src/test/resources/loginData.properties")));

        String[] users = properties.getProperty("users").split(",");
        String[] passwords = properties.getProperty("passwords").split(",");
        Object[][] data = new Object[users.length][2];
        for (int i = 0; i < users.length; i++) {
            data[i][0] = users[i];
            data[i][1] = passwords[i];
        }
        return data;
    }

    @Test() public void navigateToChrome(){

        this.driver.get("https://ztrain-web.vercel.app/home");
        this.driver.findElement(By.id("style_avatar_wrapper__pEGIQ")).click();
    }

    @Test()
    public  void SingUp(){
        this.driver.get("https://ztrain-web.vercel.app/home");
        this.driver.findElement(By.id("style_avatar_wrapper__pEGIQ")).click();
        this.driver.findElement(By.cssSelector(".MuiTabs-scroller>div>button:nth-child(2)")).click();
        this.driver.findElement(email_lod).sendKeys("yvans11@gmail.com");
        this.driver.findElement(password).sendKeys("yg1c");
        this.driver.findElement(confirme_password).sendKeys("yg1c");
        this.driver.findElement(inscription).click();

    }

    @Test
    public void addToCart() throws InterruptedException {
        driver.get("https://ztrain-web.vercel.app/home");

        // Trouver tous les éléments correspondant aux cartes d'article
        List<WebElement> articleCards = driver.findElements(articleCardLocator);

        // Vérifier s'il y a au moins un article sur la page
        if (!articleCards.isEmpty()) {
            // Cliquer sur le premier article pour l'ajouter au panier (vous pouvez ajuster cette logique selon vos besoins)
            WebElement firstArticleCard = articleCards.get(0);
            firstArticleCard.click();

            // Attendre un court instant pour que la page se charge complètement
            Thread.sleep(1000);

            // Trouver et cliquer sur le bouton "Ajouter au panier"
            WebElement addToCartButton = driver.findElement(addToCartButtonLocator);
            addToCartButton.click();

        }
    }
    @Test
    public void selectMultipleArticles() {
        driver.get("https://ztrain-web.vercel.app/home");
        List<WebElement> articleCards = driver.findElements(articleCardLocator);

        // Parcourir la liste des cartes d'article et les sélectionner
        for (WebElement articleCard : articleCards) {
            articleCard.click();
        }
    }

    @Test()
    public  void Login() throws InterruptedException {
        this.driver.get("https://ztrain-web.vercel.app/home");
        this.driver.findElement(By.id("style_avatar_wrapper__pEGIQ")).click();
        this.driver.findElement(email_lod).sendKeys("yvans11@gmail.com");
        this.driver.findElement(password).sendKeys("yg1c");
        this.driver.findElement(By.id("btn_login")).click();
        Thread.sleep(5000);
        Assert.assertTrue(this.driver.findElement(By.cssSelector(".ant-badge")).isDisplayed());
        System.out.println("le bouton est activé");

    }

    @Test() public void  Logout() throws InterruptedException {
        Thread.sleep(10000);
        this.driver.findElement(By.id("style_avatar_wrapper__pEGIQ")).click();
        this.driver.findElement(By.cssSelector(".ant-menu>li:nth-child(5)")).click();
    }
}
