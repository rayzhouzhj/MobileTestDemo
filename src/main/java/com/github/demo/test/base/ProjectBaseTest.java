package com.github.demo.test.base;

import com.github.demo.app.Calculator;
import com.github.testcommon.test.base.BaseTest;

public class ProjectBaseTest extends BaseTest
{
	public Calculator App;
	
	public ProjectBaseTest()
	{
		System.out.println("Initialize Test "
				+ "[" + this.getClass().getSimpleName() + "]"
				+ " by thread: " + Thread.currentThread().getId());
	}
}
