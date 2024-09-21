package com.ey.bmi;

public class BMICalculator implements BMI {

	@Override
	public double calculateBMI(Person person) {
		double weight = person.getWeight();
		double height = person.getHeight();
		
		if(weight <=0 || height <= 0)
			throw new BMIException("Incorrect Data");
		
		double bmi = weight / (height * height);
		return Math.round(bmi);
	}

	@Override
	public boolean isDietRecommended(Person person) {
		double bmi = calculateBMI(person);
		if(bmi < 25)
			return false;
		else
			return true;
	}
}
