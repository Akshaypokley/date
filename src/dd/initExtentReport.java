package dd;


import com.relevantcodes.extentreports.ExtentReports;

/**
 * Created by AKSHAY on 17/04/2017.
 */
public class initExtentReport {
    static ExtentReports extent;

    public static ExtentReports init()

    {
            extent=new ExtentReports("C:\\Users\\AKSHAY\\IdeaProjects\\date\\ExtenReport\\extent.html",false);
        return extent;
    }
}
