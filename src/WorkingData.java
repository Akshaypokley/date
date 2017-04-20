import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by AKSHAY on 20/04/2017.
 */
public class WorkingData
        {

    public static void main(String args[]) throws ParseException {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://travel.tfleet.in/");
        driver.findElement(By.id("Email_Id")).sendKeys("ashwini@tcrafttechnologies.com");
        driver.findElement(By.id("Password")).sendKeys("ue8096UE");
        driver.findElement(By.id("btnSubmit1")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.xpath("html/body/div[1]/aside/section/ul/li[5]/a/span")).click();
       /* **********************************************************************************************/

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        SimpleDateFormat myDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat calDateFormat = new SimpleDateFormat("MMMM yyyy");
        Date setDate=myDateFormat.parse("15/08/2017");


        driver.findElement(By.xpath(".//*[@id='datetimepicker1']/span/span")).click();

        Date curDate = calDateFormat.parse(driver.findElement(By.xpath(".//*[@id='datetimepicker1']/div/ul/li[1]/div/div[1]/table/thead/tr[1]/th[2]")).getText());
        System.out.println(curDate);

        int monthDiff = Months.monthsBetween(new DateTime(curDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1)).getMonths();
        boolean isFuture = true;
        // decided whether set date is in past or future
        if(monthDiff<0){
            isFuture = false;
            monthDiff*=-1;
        }
        // iterate through month difference
        for(int i=1;i<=monthDiff;i++){
            driver.findElement(By.xpath(".//*[@id='datetimepicker1']/div/ul/li[1]/div/div[1]/table/thead/tr[1]/th[@class="+ (isFuture ? "'next'" : "'prev'") + "]")).click();
        }
        // Click on Day of Month from table
        driver.findElement(By.xpath("//div[@class='datepicker']/div[1]//td[text()='" + (new DateTime(setDate).getDayOfMonth()) + "']")).click();





    }
            }
