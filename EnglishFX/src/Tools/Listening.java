package Tools;

import javafx.beans.property.SimpleStringProperty;

public class Listening {
	
	private final SimpleStringProperty question;
	private final SimpleStringProperty answer;

	public Listening(SimpleStringProperty question, SimpleStringProperty answer) {
		this.question = question;
		this.answer = answer;
	}
	
	public Listening(String question, String answer) {
		this.question = new SimpleStringProperty(question);
		this.answer = new SimpleStringProperty(answer);
	}

	@Override
	public String toString() {
		return "Listening [question=" + question + ", answer=" + answer + "]";
	}
	
}
