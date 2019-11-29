package com.ygl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Log {
    private Integer id;
    private String name;
    private Date quantum;
    private String methodmessage;
    private String result;
}
