package com.ey.test.suite;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.ey.test.BMITest;
import com.ey.test.BMITest2;
import com.ey.test.BMITest3;

@Suite
@SelectClasses({ BMITest.class, BMITest2.class, BMITest3.class })
public class BMITestSuite {

}
