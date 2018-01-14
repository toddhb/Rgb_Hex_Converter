package hexRGBConverter;

import java.awt.Color;

public class Hex extends _Color {

	public Hex(String input) {
		super(input);
		// TODO Auto-generated constructor stub
	}

	String parsedValue;
	Color color;

	@Override
	String convert() {

		String rgbValue = "";

		if(!value.equals("")) {
			//parse the input value so that it becomes a well-formed hexadecimal representation
			parse();
			//after parsing, convert the hex to RGB
			color = Color.decode(parsedValue);
			rgbValue = "rgb(" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + ")";
		}
		return rgbValue;
	}

	@Override
	void parse() {
		//TODO: MORE PARSING
		//IF STRING DOES NOT START WITH 0X OR 0x
		//IF STRING DOES NOT REPRESENT VALID HEX CHARS
		if(value.substring(0,1).equals("#")) {
			parsedValue = "0x" + value.substring(1, value.length());//replace a leading # char with 0x
		}
		if (!value.substring(0,2).equals("0x") || !value.substring(0,2).equals("0X")) {
			parsedValue = "0x" + value;//prepend a 0x
		}
	}

	@Override
	int getRed() {
		return color.getRed();
	}

	@Override
	int getGreen() {
		return color.getGreen();
	}

	@Override
	int getBlue() {
		return color.getBlue();
	}

}
