package com.vfoprojects.apilista.controller.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable {

    private String message;

    public FieldMessage() {

    }

    public FieldMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
