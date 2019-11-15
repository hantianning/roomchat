package com.jyyr.ssm.entity;


import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {


    private static final long serialVersionUID = 2663018816850422305L;
    private Integer id;
    private String username;
    private String password;
    private Date birth;
    private String phone;
    private Integer gender;
    private String salt;

    public User() {
    }

    public User(Integer id, String username, String password, Date birth, String phone, Integer gender, String salt) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.birth = birth;
        this.phone = phone;
        this.gender = gender;
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birth='" + birth + '\'' +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                ", salt='" + salt + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
