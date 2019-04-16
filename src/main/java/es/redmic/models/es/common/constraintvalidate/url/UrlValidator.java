package es.redmic.models.es.common.constraintvalidate.url;

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

import java.net.MalformedURLException;
import java.net.URL;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UrlValidator implements ConstraintValidator<ValidateUrl, String> {

	@Override
	public boolean isValid(String url, ConstraintValidatorContext cvc) {

		if (url == null)
			return true;
		
		try {
			new URL(url);
			return true;
		} catch (MalformedURLException e) {
			return false;
		}

	}

	@Override
	public void initialize(ValidateUrl constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}
}
