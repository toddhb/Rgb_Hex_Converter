package hexRGBConverter;

public class Hex extends Color {

	public Hex(String input) {
		super(input);
		// TODO Auto-generated constructor stub
	}

	String parsedValue;

	@Override
	String convert() {
		String rgbValue = "";

		if(!value.equals("")) {
			//parse the input value so that it becomes a well-formed hexadecimal representation
			parse();
			//after parsing, convert the hex to RGB
			//rgbValue = value + "rgb!";//TODO
			//then fill the RGB field with the converted value
			GUI.setText(GUI.textFieldRgb, rgbValue);
		}
		//preserve the original hex input
		return value;
	}

	@Override
	void parse() {
		//TODO
	}

}
