package utilities;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.*;

import java.io.File;

public class Listeners implements ITestListener {
    private ExtentSparkReporter htmlReporter;
    private ExtentReports reports;
    private ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        configureReports();
        System.out.println("Test suite started: " + context.getName());
    }

    private void configureReports() {
        htmlReporter = new ExtentSparkReporter("ExtentListenerReportDemo.html");
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);

        reports.setSystemInfo("Machine", "ChandraPC");
        reports.setSystemInfo("OS", "Windows");

        htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
        htmlReporter.config().setReportName("This is my first Report");
        htmlReporter.config().setTheme(Theme.DARK);
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
        test = reports.createTest(result.getName());
        test.log(Status.PASS, MarkupHelper.createLabel("Test passed: " + result.getName(), ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
        test = reports.createTest(result.getName());
        String screenshotPath = System.getProperty("user.dir") + File.separator + "Screenshots" + File.separator + result.getName() + ".png";

        try {
            test.log(Status.FAIL, MarkupHelper.createLabel("Test failed: " + result.getName(), ExtentColor.RED));
            if (new File(screenshotPath).exists()) {
                test.fail("Screenshot attached:").addScreenCaptureFromPath(screenshotPath);
            } else {
                test.fail("Screenshot not found at: " + screenshotPath);
            }
        } catch (Exception e) {
            test.fail("An error occurred while attaching the screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
        test = reports.createTest(result.getName());
        test.log(Status.SKIP, MarkupHelper.createLabel("Test skipped: " + result.getName(), ExtentColor.YELLOW));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test failed but within success percentage: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test suite finished: " + context.getName());
        if (reports != null) {
            reports.flush();
        }
    }
}
