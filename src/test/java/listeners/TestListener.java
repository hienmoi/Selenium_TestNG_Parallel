package listeners;

import com.aventstack.extentreports.Status;
import helpers.CaptureHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.AllureManger;
import reports.ExtentReportManager;
import reports.ExtentTestManager;
import utils.LogUtils;

public class TestListener implements ITestListener {

    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    private static int testTotal;
    private static int testPassTotal;
    private static int testFailTotal;
    private static int testSkipTotal;

    @Override
    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub
        LogUtils.info("Setup môi trường: " + arg0.getStartDate());
    }

    @Override
    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub
        LogUtils.info("Kết thúc bộ test: " + arg0.getEndDate());
        LogUtils.info("Tổng số testcase là: " + testTotal);
        LogUtils.info("Tổng số testcase pass là: " + testPassTotal);
        LogUtils.info("Tổng số testcase fail là: " + testFailTotal);
        LogUtils.info("Tổng số testcase skip là: " + testSkipTotal);
        //Kết thúc và thực thi Extents Report
        ExtentReportManager.getExtentReports().flush();
    }

    @Override
    public void onTestStart(ITestResult arg0) {
        // TODO Auto-generated method stub
        LogUtils.info("Bắt đầu chạy TC: " + arg0.getName());
        testTotal++;
        CaptureHelper.startRecord("loginSuccess");
        //Bắt đầu ghi 1 TCs mới vào Extent Report
        ExtentTestManager.saveToReport(getTestName(arg0), getTestDescription(arg0));
    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        // TODO Auto-generated method stub
        LogUtils.info("Đây là test case chạy thành công: " + arg0.getName());
        testPassTotal++;
        CaptureHelper.stopDelayFinishRecord(2);
        //Extent Report
        ExtentTestManager.logMessage(Status.PASS, arg0.getName() + " is passed.");
    }

    @Override
    public void onTestFailure(ITestResult arg0) {
        // TODO Auto-generated method stub
        LogUtils.error("Đây là test case bị fail: " + arg0.getName());
        LogUtils.error(arg0.getThrowable());
        testFailTotal++;
        CaptureHelper.captureScreenshot(arg0.getName());
        CaptureHelper.stopDelayFinishRecord(2);
        //Extent Report
        ExtentTestManager.addScreenshot(arg0.getName());
        ExtentTestManager.logMessage(Status.FAIL, arg0.getThrowable().toString());
        ExtentTestManager.logMessage(Status.FAIL, arg0.getName() + " is failed.");
        //Allure Report
        AllureManger.saveTextLog(arg0.getName() + " is failed.");
        AllureManger.saveScreenshotPNG();
    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        // TODO Auto-generated method stub
        LogUtils.warn("Đây là test case bị bỏ qua: " + arg0.getName());
        LogUtils.error(arg0.getThrowable());
        testSkipTotal++;
        CaptureHelper.stopDelayFinishRecord(2);
        //Extent Report
        ExtentTestManager.logMessage(Status.SKIP, arg0.getThrowable().toString());
    }
}
