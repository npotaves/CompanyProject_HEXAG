package com.npotaves.CompanyApplication.domain.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CuitValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCuit {
    String message() default "El CUIT es obligatorio y debe tener 11 dígitos numéricos";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
