package org.example.page;

import org.junit.Test;
import org.openqa.selenium.By;

public class LogoutPage extends Page{
    @Test() public void  logout() throws InterruptedException {
        Thread.sleep(10000);
        this.driver.findElement(By.id("style_avatar_wrapper__pEGIQ")).click();
        this.driver.findElement(By.cssSelector(".ant-menu>li:nth-child(5)")).click();
    }
}
