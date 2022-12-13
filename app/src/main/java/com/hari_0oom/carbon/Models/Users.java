package com.hari_0oom.carbon.Models;

public class Users {
    String profilepic, mail, userName, Password, userId, lastMessage;

    public Users(String profilepic, String mail, String userName, String password, String userId, String lastMessage) {
        this.profilepic = profilepic;
        this.mail = mail;
        this.userName = userName;
        Password = password;
        this.userId = userId;
        this.lastMessage = lastMessage;
    }
    public Users(){}



    //Signup constructor

    public Users(String mail, String userName, String password) {
        this.mail = mail;
        this.userName = userName;
        Password = password;
    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUserId(String key) {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }
}
