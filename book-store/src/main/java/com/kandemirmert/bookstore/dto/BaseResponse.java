package com.kandemirmert.bookstore.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Builder
@ToString
@Getter
@Setter
public class BaseResponse implements Serializable {

    private static final long serialVersionUID = -3397753498461010370L;
    private String code;
    private String message;

}