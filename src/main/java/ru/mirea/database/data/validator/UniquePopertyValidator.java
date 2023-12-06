package ru.mirea.database.data.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import ru.mirea.database.annotation.Unique;
import ru.mirea.database.data.repository.housing.jpa.JpaPropertyRepository;

@Component
public class UniquePopertyValidator implements ConstraintValidator<Unique, String> {

    private final JpaPropertyRepository repository;

    public UniquePopertyValidator(JpaPropertyRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value!= null && !repository.existsByName(value);
    }
}
