package es.redmic.models.es.common.constraintvalidate.range;

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

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.joda.time.DateTime;

import es.redmic.models.es.common.constraintvalidate.common.BaseValidator;

public class RangeValidator extends BaseValidator<DateTime> implements ConstraintValidator<ValidateRange, Object> {

	private String minMethodName;
	private String maxMethodName;

	@Override
	public void initialize(ValidateRange validateZRange) {
		minMethodName = getAccessorMethodName(validateZRange.min());
		maxMethodName = getAccessorMethodName(validateZRange.max());
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext cvc) {
		Double min = invokeDateGetter(obj, minMethodName);
		Double max = invokeDateGetter(obj, maxMethodName);

		if (min == null && max == null)
			return false;
		if (min != null && max != null)
			return (min <= max);
		else
			return true;
	}
}
