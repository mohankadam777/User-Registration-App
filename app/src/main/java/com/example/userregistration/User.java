package com.example.userregistration;

public class User {
    String uName;
    String uDOB;
    String uEmailId;

    public User(String uName, String uDOB, String uEmailId){
        this.uName= uName;
        this.uDOB=uDOB;
        this.uEmailId=uEmailId;
    }


    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuDOB() {
        return uDOB;
    }

    public void setuDOB(String uDOB) {
        this.uDOB = uDOB;
    }

    public String getuEmailId() {
        return uEmailId;
    }

    public void setuEmailId(String uEmailId) {
        this.uEmailId = uEmailId;
    }
}
