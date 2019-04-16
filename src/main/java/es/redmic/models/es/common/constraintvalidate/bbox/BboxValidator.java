package es.redmic.models.es.common.constraintvalidate.bbox;

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
