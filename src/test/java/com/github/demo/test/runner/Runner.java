package com.github.demo.test.runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rayzhou.framework.context.RunTimeContext;
import com.rayzhou.framework.executor.TestExecutor;

public class Runner 
{
    @Test
    public static void testApp() throws Exception 
    {
    	if(!RunTimeContext.getApp().exists())
    	{
    		Assert.fail("App file does not exist: " + RunTimeContext.getApp().getAbsolutePath());
    	}
    	
        TestExecutor executor = TestExecutor.build();
        List<String> packages = new ArrayList<>();
        packages.add("com.github.demo.app.test");
        
        boolean hasFailures = executor.runTests(packages);
        
        Assert.assertFalse(hasFailures, "Testcases have failed in parallel execution");
    }
}
