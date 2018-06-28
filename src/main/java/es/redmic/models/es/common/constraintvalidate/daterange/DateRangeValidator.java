package es.redmic.models.es.common.constraintvalidate.daterange;

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