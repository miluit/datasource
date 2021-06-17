package com.taotao.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@TableName("brand") 不写这个会有啥
@Builder(toBuilder = true)
public class Brand implements Serializable {
    /** ID   为啥这块不用int */
    private Integer id;

    private String name;

    private String image;

    private String initial;

    private Integer sort;

}
