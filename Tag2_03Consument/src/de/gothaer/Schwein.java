package de.gothaer;

public class Schwein {
	
	private String name="Nobody";
	private int gewicht = 10;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGewicht() {
		return gewicht;
	}
	
	private void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}
	public void fressen() {
		gewicht++;
	}
	@Override
	public String toString() {
		return "Schwein [name=" + name + ", gewicht=" + gewicht + "]";
	}

}
