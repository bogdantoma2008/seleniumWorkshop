package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestResult;
import org.testng.internal.IResultListener;

public class TestNgListener implements IResultListener {

	public void onTestStart(ITestResult result) {
		System.out
				.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(
				"++++ Start test case : " + result.getMethod().getMethodName() + "++++++++++++++++++++++++++++");
		System.out
				.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		String timeStmap = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		System.out.println("Start time :" + timeStmap);

	}

	public void onTestSuccess(ITestResult result) {
		System.out
				.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out
				.println("++++ End test case : " + result.getMethod().getMethodName() + "++++++++++++++++++++++++++++");
		System.out
				.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		String timeStmap = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		System.out.println("End time :" + timeStmap);
	}

	public void onTestFailure(ITestResult result) {
		System.out
				.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(
				"++++ Failed test case : " + result.getMethod().getMethodName() + "++++++++++++++++++++++++++++");
		System.out
				.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		String timeStmap = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		System.out.println("Failed time :" + timeStmap);
		System.out.println(result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		System.out
				.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(
				"++++ Skipped test case : " + result.getMethod().getMethodName() + "++++++++++++++++++++++++++++");
		System.out
				.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

	}

}