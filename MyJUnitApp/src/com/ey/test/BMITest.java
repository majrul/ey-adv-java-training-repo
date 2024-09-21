package com.ey.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.ey.bmi.BMICalculator;
import com.ey.bmi.Person;

public class BMITest {

	@Test
	public void calculateBMI() {
		BMICalculator bmiCalculator = new BMICalculator();

		//given
		Person p = new Person(70, 1.7);
		
		//when
		double actualbmi = bmiCalculator.calculateBMI(p);
		
		//then
		double expectedbmi = 24;
		assertEquals(expectedbmi, actualbmi);
	}
}
