import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.xml.internal.ws.handler.HandlerException;
import dd.initExtentReport;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import static dd.OpenBrowser.getUrl;
import static dd.OpenBrowser.openbrowser;
import static dd.DateFunction.DateFun;
import static dd.TakeScreenShot.takeScreenshot;

/**
 * Created by AKSHAY on 20/04/2017.
 */
public class EnqDate {

    WebDriver driver;
    ExtentReports extent;

    @BeforeClass
    public void h() {
        extent = initExtentReport.init();
        driver = openbrowser("chrome");
        getUrl("url");

    }

    @Test
    public void l() throws ParseException, IOException

    {
        ExtentTest test = extent.startTest("UI Test", "To Test UI ON HOME");
        driver.findElement(By.id("Email_Id")).sendKeys("ashwini@tcrafttechnologies.com");
        driver.findElement(By.id("Password")).sendKeys("ue8096UE");
        driver.findElement(By.id("btnSubmit1")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("html/body/div[1]/aside/section/ul/li[5]/a/span")).click();
         DateFun(driver,"12/08/2017");
        test.log(LogStatus.INFO, " Test Pass");

        test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("./LoginFunction/"+takeScreenshot(driver)));


    }

}