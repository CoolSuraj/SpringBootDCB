package com.dcb.SpringBootTutorial.error;

import com.dcb.SpringBootTutorial.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;


//ControllerAdvice is used for Exception Handling,
// it will handle all the exceptions if not explicitly mentioned
// we can give/ define base backage or class for which this Exception handller is applicable
@ControllerAdvice
@ResponseStatus
//@RestControllerAdvice is combo of above two
public class RestResponseEntityExceptionHandler extends
        ResponseEntityExceptionHandler {

//this needs to be used as to tell this as Exception Handller
    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException departmentNotFoundException, WebRequest webRequest){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND , departmentNotFoundException.getMessage());
       //this will give proper Error message
        /*
        *
        * {
            "status": "404 NOT_FOUND",
            "message": "Department Id Not Found"
        }
        *
        * */
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    // Handle all other generic exceptions (Fallback), Kind of Global Exception Handller
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleGlobalException(Exception ex) {

        ErrorMessage message = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR , ex.getMessage());
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
