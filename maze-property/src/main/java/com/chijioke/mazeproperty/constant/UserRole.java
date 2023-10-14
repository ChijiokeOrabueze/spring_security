package com.chijioke.mazeproperty.constant;

import java.util.List;
import java.util.stream.Collectors;

public enum UserRole {
    ADMIN, USER;


    public static String concatenate (List<UserRole> roles){
        return String.join(",",
                roles.stream().map(role-> role.name()).collect(Collectors.toList())
        );
    }
}
