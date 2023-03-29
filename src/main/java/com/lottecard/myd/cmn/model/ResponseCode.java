package com.lottecard.myd.cmn.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ResponseCode implements EnumModel {

    TEST_ERROR("9999", "ERROR", "ERROR");

    @Getter
    private String code;

    @Getter
    private String description;

    @Getter
    private String message;

    ResponseCode(String code, String description, String message) {
        this.code = code;
        this.description = description;
        this.message = message;
    }

    @Override
    public String getKey() {
        return this.code;
    }

    @Override
    public String getValue() {
        return this.message;
    }

}
