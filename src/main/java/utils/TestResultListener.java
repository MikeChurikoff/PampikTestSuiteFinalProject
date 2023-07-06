package utils;

import driver.DriverFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;


    public class TestResultListener implements ITestListener {

        @Override
        public void onTestFailure(ITestResult result) {
            var srcFile = ((TakesScreenshot) DriverFactory.startChromeDriver()).getScreenshotAs(OutputType.BYTES);
            saveScreenshot(srcFile);
        }

        @Attachment(value = "Page screenshot", type = "image/png")
        private byte[] saveScreenshot(byte[] screenshot) {
            return screenshot;
        }
    }

