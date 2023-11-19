package com.example.oauth.entity;

import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class UserEntity {

    private  String  username ;
    private String password ;

    private String email ;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private Collection<GrantedAuthority> grantedAuthorityCollections =new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<GrantedAuthority> getGrantedAuthorityCollections() {
        return grantedAuthorityCollections;
    }

    public void setGrantedAuthorityCollections(Collection<GrantedAuthority> grantedAuthorityCollections) {
        this.grantedAuthorityCollections = grantedAuthorityCollections;
    }

    public UserEntity() {
    }
}
