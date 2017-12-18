package hexRGBConverter;

public abstract class Color {
	protected String value;
	
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
	abstract void parse();
}