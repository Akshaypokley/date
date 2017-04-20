import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by AKSHAY on 19/04/2017.
 */
public class sd {
    public static void main(String [] args) throws ParseException

    {
        SimpleDateFormat myDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat calDateFormat = new SimpleDateFormat("MMMM yyyy");
        Date setDate=myDateFormat.parse("15/08/2014");
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://seleniumbyneeds.blogspot.in/2015/01/selecting-date-on-jquery-datepicker.html");
        // Switch to frame where the Menu Example is loaded

        driver.switchTo().frame(driver.findElement(By.id("myFiddler"))).switchTo().frame(0);

        driver.findElement(By.id("datepicker")).click();

        Date curDate = calDateFormat.parse(driver.findElement(By.className("ui-datepicker-title")).getText());
        // Joda org.joda.time.Months class to calculate difference
        // to do this converted Date to joda DatTime
        int monthDiff = Months.monthsBetween(new DateTime(curDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1)).getMonths();
        boolean isFuture = true;
        // decided whether set date is in past or future
        if(monthDiff<0){
            isFuture = false;
            monthDiff*=-1;
        }
        // iterate through month difference
        for(int i=1;i<=monthDiff;i++){
            driver.findElement(By.className("ui-datepicker-" + (isFuture?"next":"prev"))).click();
        }
        // Click on Day of Month from table
        driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='" + (new DateTime(setDate).getDayOfMonth()) + "']")).click();

    }

}
