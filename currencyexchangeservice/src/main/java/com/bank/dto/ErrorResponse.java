package com.bank.dto;

import lombok.Value;

@Value
public class ErrorResponse {
    int code;
    String message;
}
