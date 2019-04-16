package es.redmic.models.es.common.constraintvalidate.language;

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

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LanguageValidator implements ConstraintValidator<ValidateLanguage, String> {

	private static String[] LANGS = { "es", "en", "it", "de", "fr", "pt" };
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext cvc) {
		
		if (value == null)
			return true;

		if (!Arrays.asList(LANGS).contains(value))
			return false;
		
		return true;
	}

	@Override
	public void initialize(ValidateLanguage constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}
}
