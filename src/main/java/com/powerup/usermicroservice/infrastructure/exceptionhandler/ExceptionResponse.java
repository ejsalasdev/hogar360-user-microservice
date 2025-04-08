package com.powerup.usermicroservice.infrastructure.exceptionhandler;

import java.time.LocalDateTime;

public record ExceptionResponse(String message, LocalDateTime timeStamp) {
}
