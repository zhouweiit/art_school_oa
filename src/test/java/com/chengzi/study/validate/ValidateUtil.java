package com.chengzi.study.validate;

import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;


public class ValidateUtil {

    /**
     * 约束性校验
     *
     * @param model 领域模型
     * @return 校验结果
     */
    public static MapMessage validate(Object model, Class... groupClass) {
        // ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        ValidatorFactory factory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .failFast(true)
                .buildValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Object>> validateResults = validator.validate(model, groupClass);
        if (validateResults.isEmpty()) {
            return MapMessage.successMessage();
        }

        String errorMessage = validateResults
                .stream()
                .findFirst()
                .map(ConstraintViolation::getMessage)
                .orElse("参数错误");

        return MapMessage.errorMessage(errorMessage).setErrorCode("400");
    }

    public static MapMessage validate(Object model) {
        return ValidateUtil.validate(model);
    }

}
