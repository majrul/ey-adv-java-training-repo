package com.ey.demo;

import org.springframework.stereotype.Component;

@Component("splChckr")
public class SpellChecker {

	public void checkSpellingMistakes(String document) {
		System.out.println("spellchecker called for " + document);
	}
}
