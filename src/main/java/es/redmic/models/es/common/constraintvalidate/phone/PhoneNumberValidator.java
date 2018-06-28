package es.redmic.models.es.common.constraintvalidate.phone;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<ValidatePhoneNumber, String> {

	private static final Pattern REGEX_PATTERN = Pattern
			.compile("^(00\\d\\d|\\+\\d\\d)? ?(\\d\\d\\d)-? ?(\\d\\d)-? ?(\\d)-? ?(\\d)-? ?(\\d\\d)$", Pattern.MULTILINE);

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