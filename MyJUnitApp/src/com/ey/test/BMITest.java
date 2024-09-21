package com.ey.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.ey.bmi.BMI;
import com.ey.bmi.BMICalculator;
import com.ey.bmi.BMIException;
import com.ey.bmi.Person;

public class BMITest {

	@Test
	public void calculateBMI_ShouldReturnExpectedValue() {
		BMI bmi = new BMICalculator();

		//given
		Person p = new Person(70, 1.7);
		
		//when
		double actualbmi = bmi.calculateBMI(p);
		
		//then
		double expectedbmi = 24;
		assertEquals(expectedbmi, actualbmi);
	}
	
	@Test
	public void calculateBMI_ShouldThrowBMIException() {
		BMI bmi = new BMICalculator();

		//given
		Person p = new Person(0, 1.7);
		
		//when
		Executable e = ()-> bmi.calculateBMI(p);
		
		//then
		assertThrows(BMIException.class, e);
	}

	@Test
	public void isDietRecommended_ShouldReturnTrue() {
		BMI bmi = new BMICalculator();

		//given
		Person p = new Person(80, 1.7);
		
		//when
		boolean recommended = bmi.isDietRecommended(p);
		
		//then
		assertTrue(recommended);
	}
}
