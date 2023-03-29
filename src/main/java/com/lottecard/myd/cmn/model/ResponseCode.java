package com.lottecard.myd.cmn.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ResponseCode implements EnumModel {

	TEST_SUCCESS("200", "SUCCESS", "성공"),
    TEST_ERROR("400", "ERROR", "에러발생");

    private String code;

    private String description;

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
