package com.ey.test.suite;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import com.ey.test.BMITest4;

@Suite
@SelectClasses({BMITest4.class })
@IncludeTags("qa")
public class BMIQATestSuite {

}
