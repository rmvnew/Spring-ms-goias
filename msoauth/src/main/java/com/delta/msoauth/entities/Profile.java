package com.delta.msoauth.entities;

import java.io.Serializable;

public class Profile implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long profileId;

    private String profileName;

    public Profile() {
    }

    public Profile(Long profileId, String profileName) {
        this.profileId = profileId;
        this.profileName = profileName;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }
}
