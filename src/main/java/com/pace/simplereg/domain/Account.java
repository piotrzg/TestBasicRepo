package com.pace.simplereg.domain;

import javax.validation.constraints.Size;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoEntity;
import org.springframework.roo.addon.tostring.RooToString;

import java.io.Serializable;

@RooJavaBean
@RooToString
@RooMongoEntity
public class Account implements Serializable {

    @Size(min = 6, max = 40)
    private String username;

    @Size(min = 6, max = 40)
    private String password;
}
