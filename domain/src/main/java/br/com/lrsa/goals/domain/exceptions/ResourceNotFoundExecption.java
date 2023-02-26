package br.com.lrsa.goals.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundExecption extends RuntimeException {

    public ResourceNotFoundExecption(String message){
        super(message);
    }
}
