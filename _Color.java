package hexRGBConverter;

public abstract class _Color {

protected String value;
	
	public _Color (String input) {
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
	abstract int getRed();
	abstract int getGreen();
	abstract int getBlue();
}
