package fr.ferreira.donovan.exam.custom_response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseException<T> extends CustomResponse<T> {

    private String error;

    public ResponseException(int code, String message, String entity, T value, String error) {
        super(code, message, entity, value);
        this.error = error;
    }
}