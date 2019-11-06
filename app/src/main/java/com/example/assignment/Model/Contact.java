package com.example.assignment.Model;

import com.google.gson.annotations.SerializedName;

public class Contact {
    @SerializedName("fullname")
    private String fullname;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("emailid")
    private String emailid;
    @SerializedName("id")
    private int id;
    @SerializedName("phone_no")
    private String phone_no;
    @SerializedName("office")
    private String office;
    @SerializedName("study_level")
    private String study_level;

    public void setId(int id) {
        this.id = id;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public void setStudy_level(String study_level) {
        this.study_level = study_level;
    }

    public String getFullname() {
        return fullname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmailid() {
        return emailid;
    }


}
