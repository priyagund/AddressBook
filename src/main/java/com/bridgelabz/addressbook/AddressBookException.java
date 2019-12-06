package com.bridgelabz.addressbook;

public class AddressBookException extends Exception {

    public ExceptionType type;

    public enum ExceptionType {
        FILE_NOT_FOUND, INVALID_FILE_TYPE, FILE_ALREADY_EXIST, INVALID_NUMBER,

    }

    public AddressBookException(ExceptionType type, String message) {
        super(message);
        this.type = type;

    }


}
