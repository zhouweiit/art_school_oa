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
    public static boolean validate(Object model, Class... groupClass) {
        // ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
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
            System.out.println("成功");
            return true;
        }

        String errorMessage = validateResults
                .stream()
                .findFirst()
                .map(ConstraintViolation::getMessage)
                .orElse("参数错误");

        System.out.println(errorMessage);
        return false;
    }

}
