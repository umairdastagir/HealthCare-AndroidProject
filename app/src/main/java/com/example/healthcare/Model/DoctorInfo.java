package com.example.healthcare.Model;

public class DoctorInfo {
    private String doctorName;
    private String doctorEmail;
   private String doctorSpecification;
   private String user_type;
    private String reg_id;
    private String doctorUid;
    private double lat;
    private double lan;


    public DoctorInfo() {
    }

    public DoctorInfo(String doctorName, String doctorEmail, String doctorSpecification, String user_type, String reg_id, String doctorUid) {
        this.doctorName = doctorName;
        this.doctorEmail = doctorEmail;
        this.doctorSpecification = doctorSpecification;
        this.user_type = user_type;
        this.reg_id = reg_id;
        this.doctorUid=doctorUid;

    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public String getDoctorSpecification() {
        return doctorSpecification;
    }

    public String getUser_type() {
        return user_type;
    }

    public String getReg_id() {
        return reg_id;
    }

    public String getDoctorUid() {
        return doctorUid;
    }

    public double getLat() {
        return lat;
    }

    public double getLan() {
        return lan;
    }
}
