package br.com.cleber.restwithspringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncorrectParamsException extends RuntimeException implements Serializable {

    public IncorrectParamsException(String exception) {
        super(exception);
    }

}
