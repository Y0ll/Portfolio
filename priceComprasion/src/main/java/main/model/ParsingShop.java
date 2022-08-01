package main.model;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.Date;


public class ParsingShop
{
    private String pathToFile = "data/prices.xls";
    private String nameProduct;
    public ParsingShop(String nameProduct) throws IOException {
        this.nameProduct = nameProduct;
    }

    public void parsingMVIDEO() throws IOException, InterruptedException {
        String search = "https://www.mvideo.ru/product-list-page?q=" + nameProduct;
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(search);
        String product = "Name = ";
        Thread.sleep(3000);
        String price = driver.findElements(By.cssSelector("body > mvid-root > div > mvid-primary-layout > mvid-layout > div > main > mvid-srp > mvid-product-list-block > div.plp__card-grid > mvid-product-list > mvid-plp-product-cards-layout > div > mvid-product-cards-row > div > div:nth-child(6) > mvid-plp-price-block > div > mvid-price > div > span")).get(0).getText();
        String name = driver.findElements(By.cssSelector("body > mvid-root > div > mvid-primary-layout > mvid-layout > div > main > mvid-srp > mvid-product-list-block > div.plp__card-grid > mvid-product-list > mvid-plp-product-cards-layout > div > mvid-product-cards-row > div > div:nth-child(4) > mvid-plp-product-title > div > a")).get(0).getText();
        driver.close();
        writeIntoExcel(pathToFile, name, price, "MVIDEO");
    }

    public void parsingDNS() throws IOException, InterruptedException {
        String search = "https://www.dns-shop.ru/search/?q=" + nameProduct;
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(search);
        String product = "";
        Thread.sleep(3000);
        try { driver.findElements(By.cssSelector("#search-results > div.products-list > div > div.catalog-products.view-simple > div:nth-child(1)")).get(0).click();}
        catch (Exception ignored) {}
        try{ driver.findElements(By.cssSelector("body > div.container.category-child > div > div.products-page__content > div.products-page__list > div.products-list > div > div:nth-child(2) > div:nth-child(1) > a")).get(0).click();}
        catch (Exception ignored){}
        Thread.sleep(3000);
        try {
            String name = driver.findElements(By.cssSelector("div.product-card-top.product-card-top_full > h1")).get(0).getText() + " " + driver.findElements(By.cssSelector("div.product-card-top.product-card-top_full > div.product-card-top__specs")).get(0).getText();
            String price = driver.findElements(By.cssSelector("div.product-card-top.product-card-top_full > div.product-card-top__buy > div.product-buy.product-buy_one-line > div > div.product-buy__price")).get(0).getText();
            writeIntoExcel(pathToFile, name, price, "DNS");
        }
        catch (Exception ignodred){}
        driver.close();
    }

    @SuppressWarnings("deprecation")
    public static void writeIntoExcel(String file, String nameProduct, String priceProduct, String shop) throws FileNotFoundException, IOException {
        try
        {
            FileInputStream myxls = new FileInputStream(file);
            HSSFWorkbook pricesSheet = new HSSFWorkbook(myxls);
            HSSFSheet worksheet = pricesSheet.getSheetAt(0);
            int lastRow=worksheet.getLastRowNum();
            Row row = worksheet.createRow(++lastRow);
            row.createCell(0).setCellValue(shop);
            row.createCell(1).setCellValue(nameProduct);
            row.createCell(2).setCellValue(priceProduct);
            row.createCell(3).setCellValue((new Date()).toString());
            myxls.close();
            FileOutputStream output_file =new FileOutputStream(new File(file));
            pricesSheet.write(output_file);
            output_file.close();
        }
        catch(Exception e)
        {
        }
    }

}
