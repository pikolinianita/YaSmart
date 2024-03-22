package pl.lcc.yasmart.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
public class WebExceptions {

    private WebExceptions() throws IllegalAccessException {
        throw new IllegalAccessException("This class cannot be created: " + getClass().getName());
    }

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public static class HackerException extends RuntimeException{
        public HackerException(String message) {
            super(message);
             log.warn("Hacker: " + message);
        }
    }

    public static class TaskNotFoundException extends RuntimeException {

        public TaskNotFoundException(String message){
            super(message);
            log.warn("Task Exception: " + message);
        }

    }
}
