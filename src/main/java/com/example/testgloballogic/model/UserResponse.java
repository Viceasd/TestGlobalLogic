package com.example.testgloballogic.model;

public class UserResponse {
    private Long id;
    private String created;
    private String modified;
    private String last_login;
    private String token;
    private Boolean isactive;

    @Override
    public String toString() {
        return "UserResponse{" +
                "id='" + id + '\'' +
                ", created='" + created + '\'' +
                ", modified='" + modified + '\'' +
                ", last_login='" + last_login + '\'' +
                ", token='" + token + '\'' +
                ", isactive=" + isactive +
                '}';
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(Boolean isactive) {
        this.isactive = isactive;
    }

}
