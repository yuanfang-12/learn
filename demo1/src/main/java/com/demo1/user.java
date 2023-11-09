package com.demo1;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;


public class user {

    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;

    //构造方法
    public user(int id, String username, String password) {
    }

}
