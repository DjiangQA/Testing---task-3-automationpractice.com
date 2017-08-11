package test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Test1 {

	private WebDriver CMDR;

	Actions actions;
	
	private Navigation N;
	private Signin S;

	private static ExtentReports report;
	private static ExtentTest test;
	private static String reportFilePath = "Report.html";

	@BeforeClass
	public static void beforesetup() {
		report = new ExtentReports();
		ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportFilePath);
		extentHtmlReporter.config().setReportName("Test1_report");
		extentHtmlReporter.config().setDocumentTitle("Test1_report");
		report.attachReporter(extentHtmlReporter);
		test = report.createTest("Test1");
	}

	@Before
	public void setUp() {

		CMDR = new ChromeDriver();
		actions = new Actions(CMDR);
		CMDR.manage().window().maximize();
		
		N = PageFactory.initElements(CMDR, Navigation.class);
		S = PageFactory.initElements(CMDR, Signin.class);

	}

	@Test
	public void test() throws InterruptedException {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(CMDR)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(100, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);
		
		SpreadSheetReader sheetReader = new SpreadSheetReader(System.getProperty("user.dir") + "\\userData.xlsx");
        List<String> row = sheetReader.readRow(1, "UserInfo");
        
        String title 		= row.get(0);
        String firstName 	= row.get(1);
        String lastName 	= row.get(2);
        String emailAddress = row.get(3);
        String passWord 	= row.get(4);
        String DOB_d 		= row.get(5);
        String DOB_m 		= row.get(6);
        String DOB_y 		= row.get(7);
        String address 		= row.get(8);
        String city			= row.get(9);
        String postCode 	= row.get(10);
        String mobile 		= row.get(11);
        String alias 		= row.get(12);
        
        
		
		String targetWebsite = "http://automationpractice.com/index.php?";
		test.info("Test website:"+ targetWebsite);
		CMDR.navigate().to(targetWebsite);
		
		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver CMDR) {
				return CMDR.findElement(By.xpath(N.signin));
			}
		});
		
		actions.moveToElement(N.Signin).click().perform();
		
		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver CMDR) {
				return CMDR.findElement(By.xpath(S.createAnAccount));
			}
		});
		
		actions.moveToElement(S.Email).click().sendKeys(emailAddress);
		
		Thread.sleep(2000);
		actions.moveToElement(S.CreateAnAccount).click().perform();
		
		Thread.sleep(2000);
		
		if (title.equals("Mr"))
		{
			actions.moveToElement(S.TitleMr).click().perform();
		}
		else if (title.equals("Mrs") | title.equals("Ms"))
		{
			actions.moveToElement(S.TitleMrs).click().perform();
		}
		Thread.sleep(1000);
		actions.moveToElement(S.FirstName).click().sendKeys(firstName).perform();
		Thread.sleep(1000);
		actions.moveToElement(S.LastName).click().sendKeys(lastName).perform();
		Thread.sleep(1000);
		actions.moveToElement(S.PassWord).click().sendKeys(passWord).perform();
		Thread.sleep(1000);
		actions.moveToElement(S.DOB_D).click().sendKeys(DOB_d).sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
		actions.moveToElement(S.DOB_M).click().sendKeys(DOB_m).sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
		actions.moveToElement(S.DOB_Y).click().sendKeys(DOB_y).sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
		actions.moveToElement(S.FirstNameAddress).click().sendKeys(firstName).perform();
		Thread.sleep(1000);
		actions.moveToElement(S.LastNameAddress).click().sendKeys(lastName).perform();
		Thread.sleep(1000);
		actions.moveToElement(S.Address).click().sendKeys(address).perform();
		Thread.sleep(1000);
		actions.moveToElement(S.City).click().sendKeys(city).perform();
		//actions.moveToElement(S.State).click().sendKeys(state).sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
		actions.moveToElement(S.PostCode).click().sendKeys(postCode).perform();
		Thread.sleep(1000);
		actions.moveToElement(S.Country).click().sendKeys("U").sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
		actions.moveToElement(S.Mobile).click().sendKeys(mobile).perform();
		Thread.sleep(1000);
		actions.moveToElement(S.Alias).click().sendKeys(alias).perform();
		
		Thread.sleep(5000);
		
	}

	@After
	public void after() {
		test.info("Test Status:" + test.getStatus());
		System.out.println(test.getStatus());
		CMDR.quit();
		report.flush();
	}

	@AfterClass
	public static void afterclass() {

	}
}

/*
 * test.log(
 *				Status.INFO,
 *				"End test Snapshot : "
 *						+ test.addScreenCaptureFromPath(ScreenShot.take(CMDR, "Draggable end of test")));
 * 
 * 
 * wait.until(new Function<WebDriver, WebElement>() {
 *			public WebElement apply(WebDriver CMDR) {
 *				return CMDR.findElement(By.xpath("//*[@id=\"htmlcontent_home\"]/ul/li[5]/a/img"));
 *			}
 *		});
 * 
 * 
 */
