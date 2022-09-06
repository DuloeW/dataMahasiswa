package com.bayu.service.general.harisma.core.util.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.bayu.service.general.harisma.core.util.CheckUtil;

public class DateFormatValidation implements ConstraintValidator<DateFormatVal, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return CheckUtil.isDateFormatValid(value);
    }
}
