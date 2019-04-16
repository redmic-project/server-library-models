package es.redmic.models.es.common.constraintvalidate.daterange;

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

public class DateRangeValidator extends BaseValidator<DateTime>
		implements ConstraintValidator<ValidateDateRange, Object> {

	private String startMethodName;
	private String endMethodName;

	@Override
	public void initialize(ValidateDateRange validateDateRange) {
		
		startMethodName = getAccessorMethodName(validateDateRange.start());
		endMethodName = getAccessorMethodName(validateDateRange.end());
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext cvc) {
		
		DateTime startDate = invokeDateGetter(obj, startMethodName);
		DateTime endDate = invokeDateGetter(obj, endMethodName);
		if ((startDate == null && endDate == null) || (startDate != null && endDate == null)) {
			return true;
		}
		if (startDate == null && endDate != null) {
			return false;
		}
		return (startDate.isBefore(endDate));
	}
}
