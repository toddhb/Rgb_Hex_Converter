package hexRGBConverter;

public class Rgb extends Color {
	public Rgb(String input) {
		super(input);
		// TODO Auto-generated constructor stub
	}

	String parsedValue, r, g, b;

	@Override
	String convert() {
		String hexValue = "";

		if(!value.equals("")) {
			//parse the input value so that it becomes a well-formed RGB
			parse();
			//after parsing, convert the RGB to hexadecimal
			hexValue = String.format("#%02X%02X%02X", Integer.parseInt(r), Integer.parseInt(g), Integer.parseInt(b));
			//then fill the Hex field with the converted value
			GUI.setText(GUI.textFieldHex, hexValue);
		}
		//preserve the original RGB input
		return value;
	}

	@Override
	void parse() {
		parsedValue = value.trim();//trim leading and trailing whitespace
		parsedValue = parsedValue.replaceAll("\\s+", "");//ignore all other whitespaces
		//TODO: more parsing
		r = parsedValue.split(",")[0];
		if (r.length() > 3) {
			r = r.substring(0, 2);//only take first 3 digits
		}
		g = parsedValue.split(",")[1];
		if (g.length() > 3) {
			g = g.substring(0, 2);
		}
		b = parsedValue.split(",")[2];
		if (b.length() > 3) {
			b = b.substring(0, 2);
		}
	}

}
