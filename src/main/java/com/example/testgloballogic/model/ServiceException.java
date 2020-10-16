package com.example.testgloballogic.model;

public class ServiceException extends Exception{

    private Integer httpStatus;
    private String message;


    private static final long serialVersionUID = -528134378438377740L;

    public ServiceException(Integer httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;

    }



    public ServiceException(ErrorMessage errorMessage){
        this.httpStatus = errorMessage.getHttpStatus();
        this.message = errorMessage.getMessage();

    }





    public Integer getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(Integer httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



}