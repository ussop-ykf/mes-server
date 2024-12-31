package org.example.messerver.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Admin implements Serializable {
    private Integer id;
    private String username;
    private String password;
}
