package es.redmic.models.es.common.constraintvalidate.language;

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