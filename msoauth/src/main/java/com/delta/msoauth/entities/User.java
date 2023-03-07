package com.delta.msoauth.entities;

import java.io.Serializable;
import java.util.Set;


public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long userId;

    private String userName;

    private String userEmail;

    private String userPassword;

    private String recoverCode;

    private boolean isActive;


    private Set<Profile> profiles;

    public User(String userName, String userEmail, String userPassword, Set<Profile> profiles,boolean isActive) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.profiles = profiles;
        this.isActive = isActive;
    }

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getRecoverCode() {
        return recoverCode;
    }

    public void setRecoverCode(String recoverCode) {
        this.recoverCode = recoverCode;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Set<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(Set<Profile> profiles) {
        this.profiles = profiles;
    }
}
