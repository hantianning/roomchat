package com.jyyr.ssm.entity;

import java.io.Serializable;
import java.util.Date;

public class Managers implements Serializable {

    private static final long serialVersionUID = 5467444998633711538L;
    private Integer mid;
    private String managername;
    private String managerpassword;
    private String managerphone;
    private Integer managerlid;
    private String salt;
    private String positionname;
    private Integer gender;
    private Date birth;


    public Managers() {
        super();
    }

    public Managers(Integer mid, String managername, String managerpassword, String managerphone, Integer managerlid, String salt, String positionname, Integer gender, Date birth) {
        super();
        this.mid = mid;
        this.managername = managername;
        this.managerpassword = managerpassword;
        this.managerphone = managerphone;
        this.managerlid = managerlid;
        this.salt = salt;
        this.positionname = positionname;
        this.gender = gender;
        this.birth = birth;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername;
    }

    public String getManagerpassword() {
        return managerpassword;
    }

    public void setManagerpassword(String managerpassword) {
        this.managerpassword = managerpassword;
    }

    public String getManagerphone() {
        return managerphone;
    }

    public void setManagerphone(String managerphone) {
        this.managerphone = managerphone;
    }

    public Integer getManagerlid() {
        return managerlid;
    }

    public void setManagerlid(Integer managerlid) {
        this.managerlid = managerlid;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPositionname() {
        return positionname;
    }

    public void setPositionname(String positionname) {
        this.positionname = positionname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Managers{" +
                "mid=" + mid +
                ", managername='" + managername + '\'' +
                ", managerpassword='" + managerpassword + '\'' +
                ", managerphone='" + managerphone + '\'' +
                ", managerlid=" + managerlid +
                ", salt='" + salt + '\'' +
                ", positionname='" + positionname + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                '}';
    }
}
