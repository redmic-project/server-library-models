package es.redmic.models.es.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public abstract class DecimalUtils {
	
	private static final char DECIMAL_SEPARATOR_DEFAULT = '.';
	
	private static final String DECIMAL_FORMAT_DEFAULT = "#.###";
	
	public static Double roundDecimals(Double d) {
		return roundDecimals(d, DECIMAL_FORMAT_DEFAULT, DECIMAL_SEPARATOR_DEFAULT);
	}
	
	public static Double roundDecimals(Double d, String decimalFormat) {
		return roundDecimals(d, decimalFormat, DECIMAL_SEPARATOR_DEFAULT);
	}
	
	public static Double roundDecimals(Double d, String decimalFormat, char decimalSeparator) {
		if (d == null || !(d instanceof Double))
			return null;
		DecimalFormatSymbols format = DecimalFormatSymbols.getInstance();
		format.setDecimalSeparator(decimalSeparator);
		DecimalFormat twoDForm = new DecimalFormat(decimalFormat, format);
		return Double.valueOf(twoDForm.format(d));
	}
}