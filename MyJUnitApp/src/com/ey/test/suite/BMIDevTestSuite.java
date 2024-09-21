package com.ey.test.suite;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.ey.test.BMITest4;

@Suite
//@SelectPackages("com.ey.test") //not working right now, need to check
@SelectClasses({BMITest4.class })
@IncludeTags("dev")
public class BMIDevTestSuite {

}
