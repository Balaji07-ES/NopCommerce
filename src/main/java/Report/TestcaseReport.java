package Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestcaseReport {
    static public String path;
    public static ExtentReports getReportObject() {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhss").format(new Date());
        path = System.getProperty("user.dir") + File.separator + "reports" + File.separator + "index_" + timeStamp + ".html";
        ExtentSparkReporter report = new ExtentSparkReporter(path);
        report.config().setDocumentTitle("NopCommerce Testcases Report");
        report.config().setReportName("Execution Report");


        ExtentReports extent = new ExtentReports();
        extent.attachReporter(report);
        extent.setSystemInfo("Tester", "Balaji");
        extent.setSystemInfo("Environment","Prod");

        return extent;
    }
}
