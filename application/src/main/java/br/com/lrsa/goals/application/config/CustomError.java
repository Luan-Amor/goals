package br.com.lrsa.goals.application.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomError {

    private int status;
    private String message;
}
