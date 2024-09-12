package com.ey.exam.core;

import java.util.List;

public class Question {

	private String text;
	private List<Option> options;

	public Question(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}
	
	/*private String option1;
	private String option2;
	private String option3;
	private String option4;*/
	
	
}
