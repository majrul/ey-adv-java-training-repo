package com.ey.bmi;

public interface BMI {

	//double calculateBMI(double weight, double height);
	double calculateBMI(Person person);
	boolean isDietRecommended(Person person);
}
