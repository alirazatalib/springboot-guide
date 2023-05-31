package com.guide.springboot.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ExceptionDetails {
    private String errorMessage;
    private String errorDetails;
    private LocalDateTime timeStamp;
}
