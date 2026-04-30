package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class HTMLReport {

	public static ExtentReports extent;

	public static ExtentReports getInstance() {

		if (extent == null) {

			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

			ExtentSparkReporter reporter = new ExtentSparkReporter("reports/ExtentReports" + timestamp + ".html");
			extent = new ExtentReports();
			extent.attachReporter(reporter);

		}

		return extent;
	}
}