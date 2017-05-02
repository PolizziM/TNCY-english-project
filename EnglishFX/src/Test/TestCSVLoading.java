package Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Tools.Listening;
import Tools.Verbs;

public class TestCSVLoading {

	static ArrayList<Verbs> data;
	static ArrayList<Listening> data2;

	public static void main(String[] args) throws FileNotFoundException {
		/*data = loadCSV("ressources/documents/irregularVerbs.csv");
		for (Verbs v : data) {
			System.out.println(v);
		}*/
		
		data2 = loadCSV("ressources/documents/toeic.csv");
		for (Listening q : data2) {
			System.out.println(q);
		}
	}

	public static ArrayList<Listening> loadCSV(String str) throws FileNotFoundException {
		File file = new File(str);
		Scanner sc = new Scanner(file);
		String line = sc.next();

		ArrayList<Listening> questions = new ArrayList<Listening>();


		for (int i = 0;i<100;i++) {

			Scanner scLine = new Scanner(line);
			scLine.useDelimiter(";");

			String q = scLine.next(); // Question
			String answer = scLine.next(); // Answer

			questions.add(new Listening(q,answer));
			scLine.close();
			line = sc.next();
		}
		sc.close();
		return questions;
	}
	
	/*public static ArrayList<Verbs> loadCSV(String str) throws FileNotFoundException {
		File file = new File(str);
		Scanner sc = new Scanner(file);
		String line = sc.next();

		ArrayList<Verbs> verbs = new ArrayList<Verbs>();


		for (int i = 0;i<161;i++) {

			//System.out.println("Ligne : "+line);
			Scanner scLine = new Scanner(line);
			scLine.useDelimiter(";");

			String verbalBase = scLine.next(); // Verbal Base
			String preterit = scLine.next(); // Preterit
			String pastPracticle = scLine.next(); // Past Practicle
			String t1 = scLine.next(); // Translation 1
			String t2 = scLine.next(); // Translation 2

			verbs.add(new Verbs(verbalBase,preterit,pastPracticle,t1,t2));
			scLine.close();
			line = sc.next();
		}
		sc.close();
		return verbs;
	}*/

}
