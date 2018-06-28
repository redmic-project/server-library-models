package es.redmic.models.es.common.constraintvalidate.daterange;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = { DateRangeValidator.class })
@Documented
public @interface ValidateDateRange {
	String message() default "{redmic.validation.constraints.ValidateDateRange.message}";

	String start();

	String end();

	@SuppressWarnings("rawtypes")
	Class[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}