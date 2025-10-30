package baseTest;

import Report.TestcaseReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Listener extends BaseTest implements ITestListener {
    ExtentReports extent = TestcaseReport.getReportObject();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test=extent.createTest(result.getMethod().getMethodName().toUpperCase());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL,result.getMethod().getMethodName()+"is Failed" );
        test.fail(result.getThrowable().getMessage());
        try {
            String imgPath = new BaseTest().getScreenShots(result.getMethod().getMethodName());
            test.addScreenCaptureFromPath(imgPath);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        String reportPath = TestcaseReport.path;
        File extentReport = new File(reportPath);
        try {
            Desktop.getDesktop().browse(extentReport.toURI());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        extent.flush();
    }
}
