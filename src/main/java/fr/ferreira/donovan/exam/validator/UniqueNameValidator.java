package fr.ferreira.donovan.exam.validator;

import fr.ferreira.donovan.exam.repository.interfaces.EntityNameRepository;
import fr.ferreira.donovan.exam.validator.annotation.UniqueName;
import jakarta.persistence.EntityManager;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

    private Class<? extends EntityNameRepository<?>> repositoryClass;

    private final EntityManager em;

    @Autowired
    UniqueNameValidator(EntityManager em) {
        this.em = em;
    }

    @Override
    public void initialize(UniqueName constraintAnnotation) {
        repositoryClass = constraintAnnotation.repositoryClass();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        JpaRepositoryFactory factory = new JpaRepositoryFactory(em);
        EntityNameRepository<?> repository = factory.getRepository(repositoryClass);
        return repository.findByName(s).isEmpty();
    }

}
