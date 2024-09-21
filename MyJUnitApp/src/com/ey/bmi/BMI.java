package com.ey.bmi;

import java.util.List;

public interface BMI {

	//double calculateBMI(double weight, double height);
	double calculateBMI(Person person);
	boolean isDietRecommended(Person person);
	double[] getBMIValues(List<Person> persons);
	Person findPersonWithLowestBMI(List<Person> persons);
	
}
