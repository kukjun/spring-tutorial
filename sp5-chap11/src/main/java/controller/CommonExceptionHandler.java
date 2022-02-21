package controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("controller")
public class CommonExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public String handleRunTimeException() {
        return "error/commonException";
    }
}
