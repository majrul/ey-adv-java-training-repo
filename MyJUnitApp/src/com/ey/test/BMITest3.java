package com.ey.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.ey.bmi.BMI;
import com.ey.bmi.BMICalculator;
import com.ey.bmi.BMIException;
import com.ey.bmi.Person;

public class BMITest3 {
	
	@ParameterizedTest
	@CsvFileSource(resources = "/bmi.csv", numLinesToSkip = 1)
	public void calculateBMI_FromCSVFileInput_ShouldReturnExpectedValue(double weight, double height, double expected) {
		BMI bmi = new BMICalculator();
		
		//given
		Person p = new Person(weight, height);
		
		//when
		double actual = bmi.calculateBMI(p);
		
		//then
		assertEquals(expected, actual);
	}
	
}
