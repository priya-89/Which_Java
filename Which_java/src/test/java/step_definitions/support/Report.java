package step_definitions.support;


import org.testng.Reporter;


public class Report {

    public static void pass(String message) {

        System.out.println("Pass: " + message);
        Reporter.log("Pass: " + message);
    }


    public static void fail(String message) {

        System.out.println("Fail: " + message);
        Reporter.log("Fail: " + message);
    }


    public static void info(String message) {

        System.out.println("Info: " + message);
        Reporter.log("Info: " + message);
    }


}