package es.redmic.models.es.common.constraintvalidate.bbox;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import es.redmic.models.es.common.constraintvalidate.common.BaseValidator;

public class BboxValidator extends BaseValidator<Double> implements ConstraintValidator<ValidateBbox, Object> {

    
    private String bottomRightLatMethodName;
    private String bottomRightLonMethodName;
    private String topLeftLatMethodName;
    private String topLeftLonMethodName;

    @Override
    public void initialize(ValidateBbox validateBbox) {
    	
    	bottomRightLatMethodName = getAccessorMethodName(validateBbox.bottomRightLat());
        bottomRightLonMethodName= getAccessorMethodName(validateBbox.bottomRightLon());
        topLeftLatMethodName = getAccessorMethodName(validateBbox.topLeftLat());
        topLeftLonMethodName = getAccessorMethodName(validateBbox.topLeftLon());
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext cvc) {
    	Double bottomRightLat = invokeDateGetter(obj, bottomRightLatMethodName);
        Double bottomRightLon= invokeDateGetter(obj, bottomRightLonMethodName);
        Double topLeftLat = invokeDateGetter(obj, topLeftLatMethodName);
        Double topLeftLon = invokeDateGetter(obj, topLeftLonMethodName);
        
        if (bottomRightLat == null || bottomRightLon == null || topLeftLat == null || topLeftLon == null) {
            return false;
        }
        if (bottomRightLat > topLeftLat)
        	return false;
        
        if (bottomRightLon < topLeftLon)
        	return false;
        return true;
    }
}