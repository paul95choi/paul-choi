package Data_Crawling;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {
	public static WebDriver driver;
	public static String base_url= "https://www.joongang.co.kr";
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C:\\Users\\kopo\\Downloads\\chromedriver_win32\\chromedriver.exe";
	
	public static void main(String[] args) {
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		driver = new ChromeDriver();
		crawl();
	}
	public static void crawl() {
		try {
			driver.get(base_url);
			//String temp = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div[1]/div[3]/div/div[2]/div[1]/a[1]/div[1]/div[2]")).getText();
			//driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[5]/ul/li[5]/a/span[1]")).click();
			
			//검색창 클릭
			driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div[2]/div/form/fieldset/div/input")).click();
			Thread.sleep(500);
			
			//값을 입
			driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div[2]/div/form/fieldset/div/input")).sendKeys("김민재");
			Thread.sleep(1000);

			//엔터키
			driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div[2]/div/form/fieldset/div/input")).sendKeys(Keys.RETURN);
			Thread.sleep(1000);
			//System.out.println(temp);
			//System.out.println(driver.getPageSource());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//driver.close();
		}
	}

}
