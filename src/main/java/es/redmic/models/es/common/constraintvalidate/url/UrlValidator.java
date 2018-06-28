package es.redmic.models.es.common.constraintvalidate.url;

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