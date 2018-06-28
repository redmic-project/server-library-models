package es.redmic.models.es.common.constraintvalidate.bbox;

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
@Constraint(validatedBy = { BboxValidator.class })
@Documented
public @interface ValidateBbox {
	
	String message() default "{redmic.validation.constraints.ValidateBbox.message}";

	String bottomRightLat();

	String bottomRightLon();

	String topLeftLat();

	String topLeftLon();

	@SuppressWarnings("rawtypes")
	Class[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}