package com.tommy.bootstart.bootuptake.mvc.view;

/**
 * Section3. Spring Boot 활용
 * Spring Web Mvc
 * ExceptionHandler
 */
public class AppError {

    private final String message;
    private final String reason;

    public AppError(String message, String reason) {
        this.message = message;
        this.reason = reason;
    }

    public String getMessage() {
        return message;
    }

    public String getReason() {
        return reason;
    }
}
