package com.ygl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain =  true)
public class Admin {
    private Integer id;
    private String name;
    private String username;
    private String password;
    private String sex;

}
