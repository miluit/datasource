package com.taotao.demo.utils;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum ResCode {

    SUCCESS(20000,"操作成功"),
    ERROR(50000,"操作失败"),
    SYSTEM_ERROR(50001,"系统操作");

    private Integer code;
    private String message;

}
