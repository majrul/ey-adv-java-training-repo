package com.ey.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.ey.demo.Calculator;

class CalculatorTest {

	@Test
	void testAdd() {
		//given
		Calculator c = new Calculator();
		//when
		int actualResult = c.add(10, 20);
		int expectedResult = 30;
		//then
		assertEquals(expectedResult, actualResult);
		
		/*if(result == 30)
			report that the code is working as expected
		else
			report that the code is not working as expected*/
			
		//NO NO NO NO NO NO NO NO
		//System.out.println(result);
	}
	
	@Test
	void testSub() {
		Calculator c = new Calculator();
		int actualResult = c.sub(10, 20);
		int expectedResult = -10;
		assertEquals(expectedResult, actualResult);
		
	}

}
