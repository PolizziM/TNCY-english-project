package Tools;

import javafx.beans.property.SimpleStringProperty;

public class Vocabulary {
	
	public SimpleStringProperty word;
	public SimpleStringProperty translation;

	public Vocabulary(SimpleStringProperty word, SimpleStringProperty translation) {
		this.word = word;
		this.translation = translation;
	}
	
	public Vocabulary(String word, String translation) {
		this.word = new SimpleStringProperty(word);
		this.translation = new SimpleStringProperty(translation);
	}

	@Override
	public String toString() {
		return "Vocabulary [Word=" + word + ", translation=" + translation + "]";
	}

	public String getWord() {
		return word.get();
	}

	public String getTranslation() {
		return translation.get();
	}
}
