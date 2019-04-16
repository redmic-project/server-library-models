package es.redmic.models.es.utils;

/*-
 * #%L
 * Models
 * %%
 * Copyright (C) 2019 REDMIC Project / Server
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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
