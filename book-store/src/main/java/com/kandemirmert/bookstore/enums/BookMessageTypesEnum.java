package com.kandemirmert.bookstore.enums;

public enum BookMessageTypesEnum {

    BOOK_NOT_FOUND("0001","Kitap Sistemde Kayıtlı Değil."),
    BOOK_HAS_NOT_SAVED_TO_SYSTEM("0002","Kitap sisteme kaydedilemedi.");

    private String code;
    private String message;

    BookMessageTypesEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


}
