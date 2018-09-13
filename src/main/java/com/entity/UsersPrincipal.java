package com.entity;

import org.springframework.stereotype.Component;

import javax.security.auth.Subject;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.nio.file.attribute.UserPrincipal;
import java.security.Principal;

public final class UsersPrincipal implements Principal,Serializable {
    private String name;

    public UsersPrincipal(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
