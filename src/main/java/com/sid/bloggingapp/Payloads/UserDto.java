package com.sid.bloggingapp.Payloads;

public class UserDto {

    private int userId;

    private String emailId;

    private String password;

    private String name;

    private String about;

    // Constructors
    public UserDto() {
    }

    public UserDto(int userId, String emailId, String password, String name, String about) {
        this.userId = userId;
        this.emailId = emailId;
        this.password = password;
        this.name = name;
        this.about = about;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

}
