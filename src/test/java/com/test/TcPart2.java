package com.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
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

        try {
            
            XSSFWorkbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Table Data");

            Row headerRow = sheet.createRow(0);

            String[] headers = {"order_id", "location", "Order State", "Type", "Lost Sale", "Net Payout", "payout_id", "payout_date"};
            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }

            List<WebElement> orderIds = driver.findElements(By.xpath("//table[@class='MuiTable-root css-15i8i05-MuiTable-root']//tbody//tr//td[1]//h6"));
            List<WebElement> lostSale = driver.findElements(By.xpath("//table[@class='MuiTable-root css-15i8i05-MuiTable-root' ]//tbody//tr//td[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-sizeMedium css-lbkwwv-MuiTableCell-root']//h6[@class='MuiTypography-root MuiTypography-subtitle2 css-11mtq93-MuiTypography-root']"));
            List<WebElement> netPayout = driver.findElements(By.xpath("//table[@class='MuiTable-root css-15i8i05-MuiTable-root' ]//tbody//tr//td[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-sizeMedium css-17vxtza-MuiTableCell-root' or @class='MuiTableCell-root MuiTableCell-body MuiTableCell-sizeMedium css-vw7ars-MuiTableCell-root']"));
            List<WebElement> orderState = driver.findElements(By.xpath("//table[@class='MuiTable-root css-15i8i05-MuiTable-root' ]//tbody//tr//td[3]//h6[@class='MuiTypography-root MuiTypography-subtitle2 css-11mtq93-MuiTypography-root' and text()='REVERSAL' or text()='CHARGEBACK']"));
            List<WebElement> location = driver.findElements(By.xpath("//table[@class='MuiTable-root css-15i8i05-MuiTable-root' ]//tbody//tr//td[2]//h6[@class='MuiTypography-root MuiTypography-subtitle2 css-11mtq93-MuiTypography-root' and text()='Artisan Alchemy' or text()='Blissful Buffet']"));
            
            
            int locationRowNum = 1;
            for (int i = 0; i < location.size(); i++) {
                Row row = sheet.getRow(locationRowNum);
                if (row == null) {
                	row = sheet.createRow(locationRowNum);
                }

                WebElement orderStateElement = orderState.get(i);
                String orderStateText = orderStateElement.getText();
                
                WebElement orderIdsElement = orderIds.get(i);
                String orderIdsText = orderIdsElement.getText();
                
                WebElement locationElement = location.get(i);
                String locationText = locationElement.getText();
                
                
                if (orderStateText.equals("REVERSAL")) {
                	row.createCell(0).setCellValue(orderIdsText);
                	row.createCell(1).setCellValue(locationText);
                	row.createCell(2).setCellValue(orderStateText);
                	locationRowNum++;
                	row = sheet.createRow(locationRowNum);
                	
                	row.createCell(0).setCellValue(orderIdsText);
                	row.createCell(1).setCellValue(locationText);
                	row.createCell(2).setCellValue(orderStateText);
                	locationRowNum++;
                	row = sheet.createRow(locationRowNum);
                	
                	row.createCell(0).setCellValue(orderIdsText);
                	row.createCell(1).setCellValue(locationText);
                	row.createCell(2).setCellValue(orderStateText);
                	locationRowNum++;
                	
                } else {
                	row.createCell(0).setCellValue(orderIdsText);
                	row.createCell(1).setCellValue(locationText);
                	row.createCell(2).setCellValue(orderStateText);
                	locationRowNum++;
                	row = sheet.createRow(locationRowNum);
                	
                	row.createCell(0).setCellValue(orderIdsText);
                	row.createCell(1).setCellValue(locationText);
                	row.createCell(2).setCellValue(orderStateText);
                	locationRowNum++;
                }
            }

            int rowIdx = 1;
            List<WebElement> tyPiPd = driver.findElements(By.xpath("//table[@class='MuiTable-root css-15i8i05-MuiTable-root' ]//tbody//tr//td[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-sizeMedium css-2hjqd0-MuiTableCell-root' and 4]"));
            for (int i = 0; i < tyPiPd.size(); i++) {
                Row row = sheet.getRow(rowIdx);
                if (row == null) {
                    row = sheet.createRow(rowIdx);
                }

                WebElement tyPiPdElement = tyPiPd.get(i);
                String tyPiPdText = tyPiPdElement.getText();
                if (i % 3 == 0) {
                    row.createCell(3).setCellValue(tyPiPdText);
                } else if (i % 3 == 1) {
                    row.createCell(6).setCellValue(tyPiPdText);
                } else if (i % 3 == 2) {
                    row.createCell(7).setCellValue(tyPiPdText);
                    rowIdx++;
                }
            }

            int rowNum = 1;
            for (int i = 0; i < lostSale.size(); i++) {
                Row row = sheet.getRow(rowNum);
                WebElement lostSaleElement = lostSale.get(i);
                String lostSaleText = lostSaleElement.getText();
                row.createCell(4).setCellValue("'"+lostSaleText);
                rowNum++;
            }

            int prowNum = 1;
            for (int i = 0; i < netPayout.size(); i++) {
                Row row = sheet.getRow(prowNum);
                
                WebElement netPayoutElement = netPayout.get(i);
                String netPayoutText = netPayoutElement.getText();
                row.createCell(5).setCellValue("'"+netPayoutText);
                prowNum++;
            }
            
            String fileName = "table_data_" + jLib.getCurrentDate() + ".csv";
            try (FileOutputStream fos = new FileOutputStream(fileName)) {
                workbook.write(fos);
                System.out.println("Excel file created successfully: " + fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
