package es.redmic.models.es.common.constraintvalidate.range;

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