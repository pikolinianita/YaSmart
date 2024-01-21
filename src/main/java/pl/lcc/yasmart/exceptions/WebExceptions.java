package pl.lcc.yasmart.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class WebExceptions {

    private WebExceptions(){
        throw new RuntimeException("This class cannot be created: " + getClass().getName());
    }

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public static class HackerException extends RuntimeException{

        public HackerException(String message) {
            super(message);
        }
    }
}
