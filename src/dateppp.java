import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by AKSHAY on 18/04/2017.
 */
public class dateppp {

    public static void main(String[] a) throws ParseException {

        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://travel.tfleet.in/");
        driver.findElement(By.id("Email_Id")).sendKeys("ashwini@tcrafttechnologies.com");
        driver.findElement(By.id("Password")).sendKeys("ue8096UE");
        driver.findElement(By.id("btnSubmit1")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.xpath("html/body/div[1]/aside/section/ul/li[5]/a/span")).click();

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        driver.findElement(By.xpath(".//*[@id='datetimepicker1']/span/span")).click();

        String date = "18/05/2017";

        SimpleDateFormat myDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        SimpleDateFormat calDateFormat = new SimpleDateFormat("MMMM YYYY");
SimpleDateFormat caadd=new SimpleDateFormat("dd");

        Date setDate = myDateFormat.parse(date);
        System.out.println(setDate);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        Date curDate = calDateFormat.parse(driver.findElement(By.xpath(".//*[@id='datetimepicker1']/div/ul/li[1]/div/div[1]/table/thead/tr[1]/th[2]")).getText());

        System.out.println(curDate);


        int monthDiff = Months.monthsBetween(new DateTime(curDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1)).getMonths();
        System.out.println(monthDiff);
        boolean isFuture = true;
        if (monthDiff < 0) {
            isFuture = false;
            monthDiff *= -1;
        }

        for (int i = 1; i <= monthDiff; i++) {

            if(isFuture )
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.findElement(By.xpath(".//*[@id='datetimepicker1']/div/ul/li[1]/div/div[1]/table/thead/tr[1]/th[@class="+ (isFuture ? "'next'" : "'prev'") + "]")).click();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//td[@class='day'] and text()='" + caadd.format(setDate).getBytes() + "'")).click();

        driver.close();

    }


    }





          /*  driver.findElement(By.xpath("./*//*[@id='datetimepicker1']/span/span")).click();

            String date = "17/04/2017";

            SimpleDateFormat myDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat calDateFormat = new SimpleDateFormat("MMMM, yyyy");
            System.out.println(calDateFormat);

            String setDate = myDateFormat.format(date);


            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            Date curDate =driver.findElement(By.xpath("//div/ul/li[1]/div/div[1]/table/tbody/tr[4]/td[3]")).getText());

            int monthDiff = Months.monthsBetween(new DateTime(curDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1)).getMonths();
            System.out.println(monthDiff);
            boolean isFuture = true;
            if (monthDiff < 0) {
                isFuture = false;
                monthDiff *= -1;
            }

            for (int i = 1; i <= monthDiff; i++) {
                driver.findElement(By.xpath(" .*//*//**//*[@id='MainContent_txtDate_CalendarExtender_" + (isFuture ? "next" : "prev") + "Arrow']")).click();
            }

            driver.findElement(By.xpath("//div[@id='MainContent_txtDate_CalendarExtender_container']//div[@title='" + new SimpleDateFormat("EEEE, MMMM dd, yyyy").format(setNewDate) + "']")).click();

        }
*/




