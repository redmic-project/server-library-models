package es.redmic.models.es.common.constraintvalidate.phone;

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

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<ValidatePhoneNumber, String> {

	private static final Pattern REGEX_PATTERN = Pattern.compile(
			"^(\\+\\d{1,3}|\\d{4})? ?(\\d{3,5})-? ?(\\d{2,3})-? ?(\\d{1,2})-? ?(\\d{1,2})-? ?(\\d{2,3})$",
			Pattern.MULTILINE);

	@Override
	public boolean isValid(String phoneNumber, ConstraintValidatorContext cvc) {

		if (phoneNumber == null)
			return true;

		if (REGEX_PATTERN.matcher(phoneNumber).find())
			return true;
		else
			return false;

	}

	@Override
	public void initialize(ValidatePhoneNumber constraintAnnotation) {
		// TODO Auto-generated method stub

	}
}
