package br.com.softblue.jogoforca.core;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.softblue.jogoforca.game.GameException;
import br.com.softblue.jogoforca.utils.RandomUtils;

import java.util.List;

public class Dictionary {
	
	private static final String FILE_NAME = "dictionario.txt";
	
	private List<String> words = new ArrayList<>();
	
	private void load() {
		
		try (Scanner scanner = 
				new Scanner(getClass().getResourceAsStream("/" + FILE_NAME))){
			
			while (scanner.hasNextLine()) {
				String word = scanner.nextLine().trim();
				words.add(word);
				
			}
			
			if(words.size() == 0) {
				throw new GameException("A lista de palavra n�o pode ser vazia");
			}
		}
	}
	
	public Word nextWord() {
		int pos = RandomUtils.newRandomNumber(0, words.size());
		return new Word(words.get(pos));
	}

}
