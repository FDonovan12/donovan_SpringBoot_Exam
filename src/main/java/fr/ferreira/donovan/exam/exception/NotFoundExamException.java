package fr.ferreira.donovan.exam.exception;

import lombok.Getter;

@Getter
public class NotFoundExamException extends RuntimeException {

    private final String type;

    private final String field;

    private final Object value;

    public NotFoundExamException(String type, String field, Object value) {
        super("Entity not found");
        this.type = type;
        this.field = field;
        this.value = value;
    }
}
