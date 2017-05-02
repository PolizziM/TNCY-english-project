package Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import Tools.Vocabulary;

public class TestCSVVocab {
	
	static ArrayList<Vocabulary> vocab = new ArrayList<Vocabulary>();
	
	public static void main(String[] args) throws IOException {
		vocab=loadCSV("ressources/documents/travelling.csv");
	}
	
	public static ArrayList<Vocabulary> loadCSV(String str) throws IOException {
		ArrayList<Vocabulary> vocab = new ArrayList<Vocabulary>();
		
		FileReader fr = new FileReader(str);
		BufferedReader br = new BufferedReader(fr);
		String currentLine;
		
		while ((currentLine = br.readLine()) != null) {
			String[] line = currentLine.split(";", 2);
			String word  = line[0]; // Word
			String trans =line[1]; // translation
			System.out.println("Word: " + word);
			System.out.println("Translation: "+trans +"\n");
			vocab.add(new Vocabulary(word,trans));
		}
		br.close();
		fr.close();
		return vocab;
	}

}
