package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Mylistener implements ITestListener {
	
	public void onStart(ITestContext context) {
	    System.out.println("Test execution started");//Before the starting of execution
	  }
	
	public void onTestStart(ITestResult result) {
	   
		System.out.println("Test method execution started");//before the start of every test method execution
	  }

	 public void onTestSuccess(ITestResult result) {
		 System.out.println("Test method passed");//For every test method inside the class
		  }
	 public void onTestFailure(ITestResult result) {
		 System.out.println("Test method failed");
		  }
	 public void onTestSkipped(ITestResult result) {
		 System.out.println("Test method skipped");
		  }
	 

}
