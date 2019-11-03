package com.chengzi.art.school.framework.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    public static Result validate(Object model, Class... groupClass) {
        ValidatorFactory factory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .failFast(true)
                .buildValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<Object>> validateResults;
        if (groupClass == null || groupClass.length == 0) {
            validateResults = validator.validate(model);
        } else {
            validateResults = validator.validate(model, groupClass);
        }
        if (validateResults.isEmpty()) {
            return new Result(true, null);
        }

        String errorMessage = validateResults
                .stream()
                .findFirst()
                .map(ConstraintViolation::getMessage)
                .orElse("参数错误");

        return new Result(true, errorMessage);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Result {

        private boolean result;

        private String message;

    }

}
