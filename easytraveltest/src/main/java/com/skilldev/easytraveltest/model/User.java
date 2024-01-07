package com.skilldev.easytraveltest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class User extends AbstractEntity{

    @NotNull
    private String username;

    @NotNull
    private String password;

}
