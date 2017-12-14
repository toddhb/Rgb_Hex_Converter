package hexRGBConverter;

public abstract class Color {
	private String value;
	
	public Color (String input) {
		value = input;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String newValue) {
		value = newValue;
	}
	
	abstract String convert();
}