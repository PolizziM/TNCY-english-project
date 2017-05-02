package Tools;

import javafx.beans.property.SimpleStringProperty;

public class Couple {

	@Override
	public String toString() {
		return "Couple [att1=" + att1 + ", att2=" + att2 + "]";
	}

	private final SimpleStringProperty att1;
	private final SimpleStringProperty att2;

	public Couple(SimpleStringProperty att1, SimpleStringProperty att2) {
		this.att1 = att1;
		this.att2 = att2;
	}

	public Couple(String att1, String att2) {
		this.att1 = new SimpleStringProperty(att1);
		this.att2 = new SimpleStringProperty(att2);
	}

	public String getAtt1() {
		return att1.get();
	}

	public String getAtt2() {
		return att2.get();
	}
}
