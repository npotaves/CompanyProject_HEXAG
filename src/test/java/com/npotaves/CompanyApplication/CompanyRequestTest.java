package com.npotaves.CompanyApplication;

import com.npotaves.CompanyApplication.domain.model.dto.request.CompanyRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Set;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

class CompanyRequestTest {

    private static Validator validator;

    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void shouldValidateCompanyRequestCorrect() {
        CompanyRequest request = new CompanyRequest();
        request.setCuit("12345678901");
        request.setCompanyName("Empresa Test");

        Set<ConstraintViolation<CompanyRequest>> violations = validator.validate(request);
        assertTrue(violations.isEmpty(), "Validación OK");
    }

    @Test
    void shouldDetectCuitEmpty() {
        CompanyRequest request = new CompanyRequest();
        request.setCuit("");
        request.setCompanyName("Empresa XYZ");

        Set<ConstraintViolation<CompanyRequest>> violations = validator.validate(request);
        assertFalse(violations.isEmpty(), "Error validación");

        Set<String> messages = violations.stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());

        assertTrue(messages.contains("El CUIT es obligatorio y debe tener 11 dígitos numéricos"),
                "Mensaje de validación faltante");
    }

    @Test
    void shouldDetectCuitWithIncorrectFormat() {
        CompanyRequest request = new CompanyRequest();
        request.setCuit("12345");
        request.setCompanyName("Empresa XYZ");

        Set<ConstraintViolation<CompanyRequest>> violations = validator.validate(request);
        assertFalse(violations.isEmpty(), "Error validación");

        Set<String> messages = violations.stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());

        assertTrue(messages.contains("El CUIT es obligatorio y debe tener 11 dígitos numéricos"),
                "Mensaje de validación faltante");
    }


}
