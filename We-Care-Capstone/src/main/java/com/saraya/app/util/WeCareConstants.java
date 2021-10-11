package com.saraya.app.util;


/**
 * The Enum ExceptionConstants.
 */
public enum WeCareConstants {

    // Exception message constants
    USER_NOT_FOUND("user.not.found"), GENERAL_EXCEPTION_MESSAGE("general.exception"),

    // Success message constants

    USER_UPDATE_SUCCESS("user.update.success"), USER_DELETE_SUCCESS("user.delete.success");

    private final String type;

    private WeCareConstants(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }

}
