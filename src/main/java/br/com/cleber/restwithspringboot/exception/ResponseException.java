package br.com.cleber.restwithspringboot.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@Getter
@AllArgsConstructor
public class ResponseException implements Serializable {

    private Date timestamp;
    private String message;
    private String details;

}
