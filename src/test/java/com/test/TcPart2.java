package com.test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.genericUtils.BaseClass;

import objectRepositoryPages.Homepage;

public class TcPart2 extends BaseClass {

    @Test
    public void tc1() throws Throwable {
        
        Logger log = LogManager.getLogger(this.getClass());
        log.debug("-------Opening Browser and Navigating to the Website------");
        driver.get(fLib.getPropertyKeyValue("url"));
        Homepage hmpg = new Homepage(driver);

        log.debug("-------Clicking on Email and sending the values------");
        hmpg.getEmailbtn().sendKeys(fLib.getPropertyKeyValue("username"));
        log.debug("-------Clicking on Password and sending the values------");
        hmpg.getPassBtn().sendKeys(fLib.getPropertyKeyValue("password"));
        log.debug("-------Clicking on Login------");
        hmpg.getLogin().click();
        Thread.sleep(3000);
        hmpg.getPopup().click();
        Thread.sleep(3000);
        hmpg.getCharback().click();
        Thread.sleep(2000);
        
        hmpg.getTrans().click();
        Thread.sleep(2000);
        hmpg.getLocations().click();
        Thread.sleep(1000);
        hmpg.getUnselect().click();
        Thread.sleep(1000);
        hmpg.getArtAlc().click();
        hmpg.getBliBuf().click();
        Thread.sleep(1000);
        hmpg.getApply1().click();
        Thread.sleep(1000);
        
        hmpg.getMarketPlace().click();
        Thread.sleep(1000);
        hmpg.getUnselect1().click();
        hmpg.getGrubHub().click();
        hmpg.getApply2().click();
        Thread.sleep(2000);
        
        WebElement ele = hmpg.getTable();
        wLib.scrollToWebElement(driver, ele);
        Thread.sleep(2000);
        
        
    }
}
