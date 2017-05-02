package Tools;

import javafx.beans.property.SimpleStringProperty;

public class Verbs {

	private final SimpleStringProperty verbalBase;
	private final SimpleStringProperty preterit;
	private final SimpleStringProperty pastParticiple;
	private final SimpleStringProperty t1;
	private final SimpleStringProperty t2;

	public Verbs(SimpleStringProperty verbalBase, SimpleStringProperty preterit, SimpleStringProperty pastParticiple, SimpleStringProperty t1, SimpleStringProperty t2) {
		this.verbalBase = verbalBase;
		this.preterit = preterit;
		this.pastParticiple = pastParticiple;
		this.t1 = t1;
		this.t2 = t2;
	}

	public Verbs(String verbalBase, String preterit, String pastParticiple, String t1, String t2) {
		this.verbalBase = new SimpleStringProperty(verbalBase);
		this.preterit = new SimpleStringProperty(preterit);
		this.pastParticiple = new SimpleStringProperty(pastParticiple);
		this.t1 = new SimpleStringProperty(t1);
		this.t2 = new SimpleStringProperty(t2);
	}

	@Override
	public String toString() {
		return "Verbs [verbalBase=" + verbalBase + ", preterit=" + preterit + ", pastParticiple=" + pastParticiple
				+ ", t1=" + t1 + ", t2=" + t2 + "]";
	}

	public String getVerbalBase() {
		return verbalBase.get();
	}

	public String getPreterit() {
		return preterit.get();
	}

	public String getPastParticiple() {
		return pastParticiple.get();
	}

	public String getT1() {
		return t1.get();
	}

	public String getT2() {
		return t2.get();
	}
	
	public void setVerbalBase(String v) {
		this.verbalBase.set(v);
	}
	
	
}
