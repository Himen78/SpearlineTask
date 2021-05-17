package com.spearline.testCases;

import com.spearline.utilities.BaseClass;
import com.spearline.webAppFunctions.webAppFunctions;
import org.testng.annotations.Test;

public class TestCase001_LoginPage extends BaseClass {

    @Test
    public void TestCase001_UserLogin() throws InterruptedException {
        webAppFunctions webAppFunctions = new webAppFunctions(webDriver);
        webAppFunctions.loginFunction();
    }

}
