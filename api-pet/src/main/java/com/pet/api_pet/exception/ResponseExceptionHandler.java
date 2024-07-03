package com.pet.api_pet.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.naming.AuthenticationException;
import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {


        @ExceptionHandler(Exception.class)
        public ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest request){
            ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
            return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @ExceptionHandler(ModelNotFoundException.class)
        public ResponseEntity<ExceptionResponse> handleModelNotFoundException(ModelNotFoundException ex, WebRequest request){
            ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
            return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(RuntimeException.class)
        public ResponseEntity<ExceptionResponse> handleRuntimeException(RuntimeException ex, WebRequest request){
            ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
            return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @ExceptionHandler(DataIntegrityViolationException.class)
        public ResponseEntity<ExceptionResponse> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request){
            ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), "Data already exists", request.getDescription(false));
            return new ResponseEntity<>(er, HttpStatus.CONFLICT);
        }

        protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
            String msg = ex.getBindingResult().getAllErrors().stream().map(
                    e -> e.getCode().concat(":").concat(e.getDefaultMessage()).concat(",")
            ).collect(Collectors.joining());

            ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), msg, request.getDescription(false));
            return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(AuthenticationException.class)
        public ResponseEntity<ExceptionResponse> handleAuthenticationException(AuthenticationException ex, WebRequest request){
        ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), "User not authenticated", request.getDescription(false));
        return new ResponseEntity<>(er, HttpStatus.UNAUTHORIZED);
        }

        @ExceptionHandler(AccessDeniedException.class)
        public ResponseEntity<ExceptionResponse> handleAccessDeniedException(AccessDeniedException ex, WebRequest request){
        ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), "Access denied", request.getDescription(false));
        return new ResponseEntity<>(er, HttpStatus.FORBIDDEN);
        }

}