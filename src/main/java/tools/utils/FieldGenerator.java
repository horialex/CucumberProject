package tools.utils;

import com.mifmif.common.regex.Generex;

public class FieldGenerator {

	public static enum TypeOfString {
		ALPHA_CAPS, ALPHA, ALPHANUMERIC, NUMERIC, ALPHANUMERICSCHAR, EMAIL,
	}

	public static String generateStringValue(int lenght, TypeOfString type) {

		String value = "";

		switch (type) {

		case ALPHA_CAPS:
			value = "[A-Z]{" + lenght + "}";
			break;

		case ALPHA:
			value = "[A-Za-z]{" + lenght + "}";
			break;

		case NUMERIC:
			value = "[0-9]{" + lenght + "}";
			break;

		case ALPHANUMERIC:
			value = "[0-9a-zA-Z]{" + lenght + "}";
			break;

		case ALPHANUMERICSCHAR:
			value = "[^0-9a-zA-Z]{" + lenght + "}";
			break;

		case EMAIL:
			value = "[0-9a-z]{" + lenght + "}";

			break;
		}
		Generex generex = new Generex(value);
		value = generex.random();

		return value;
	}
}
