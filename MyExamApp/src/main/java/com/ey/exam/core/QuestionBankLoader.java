package com.ey.exam.core;

import java.util.ArrayList;
import java.util.List;

public class QuestionBankLoader {

	public List<Question> loadQuestionsOnHTML() {
		//in a real app, we will load the questions from DB
		QuestionBank qb = new QuestionBank();
		qb.addNewSubject("HTML");
		
		Question q = new Question("What is the correct HTML for creating a hyperlink?");
		List<Option> options = new ArrayList<Option>();
		options.add(new Option("&lt;a url=\"http://www.w3schools.com\"&gt;W3Schools.com&lt;/a&gt;", false));
		options.add(new Option("&lt;a name=\"http://www.w3schools.com\"&gt;W3Schools.com&lt;/a&gt;", false));
		options.add(new Option("&lt;a href=\"http://www.w3schools.com\"&gt;W3Schools&lt;/a&gt;", true));
		options.add(new Option("&lt;a&gt;http://www.w3schools.com&lt;/a&gt;", false));
		q.setOptions(options);
		qb.addNewQuestion("HTML", q);

		q = new Question("Which character is used to indicate an end tag?");
		options = new ArrayList<Option>();
		options.add(new Option("*", false));
		options.add(new Option("/", false));
		options.add(new Option(">", true));
		options.add(new Option("\\", false));
		q.setOptions(options);
		qb.addNewQuestion("HTML", q);

		q = new Question("Inline elements are normally displayed without starting a new line.");
		options = new ArrayList<Option>();
		options.add(new Option("Yes", true));
		options.add(new Option("No", false));
		q.setOptions(options);
		qb.addNewQuestion("HTML", q);

		return qb.getQuestions("HTML");
	}
}
