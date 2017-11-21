package com.demo.keeptuit.service;

import org.hibernate.validator.HibernateValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Validator for business models
 */
@Component
public class ModelValidator {
    private static final Logger log = LoggerFactory.getLogger(ModelValidator.class);

    private Validator validator;

    public ModelValidator() {
        ValidatorFactory factory = Validation.byProvider( HibernateValidator.class )
                .configure()
                .buildValidatorFactory();
        this.validator = factory.getValidator();
    }

    /**
     * Validate a given objects against constraints defined
     *
     * @param object - object to be validated
     * @param <T> - type of the object to be validated
     * @throws ConstraintViolationException - when validation fails
     */
    public <T> void validate(final T object) {

        Set<ConstraintViolation<T>> violations = validator.validate(object);

        violations.stream()
                .filter(violation -> violation.getPropertyPath() != null)
                .forEach(violation -> log.warn("Constraint violation for field: {} in object: {}, error: {}",
                        violation.getPropertyPath().toString(), violation.getRootBeanClass(), violation.getMessage()));

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
