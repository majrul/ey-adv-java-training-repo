package com.ey.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("txtEdtr")
public class TextEditor {

	@Autowired
	private SpellChecker sp;
	
	public void load(String document) {
		System.out.println("texteditor loaded "+document);
		//SpellChecker sp = new SpellChecker();
		sp.checkSpellingMistakes(document);
	}
}
