package com.example.healthcare.Model;

public class PatientInfo {
    private String patientName;
    private String patientEmail;
    private String patientGender;
    private String userType;
    private String patientUid;

    public PatientInfo() {
    }

    public PatientInfo(String patientName, String patientEmail, String patientGender, String userType ,String patientUid) {
        this.patientName = patientName;
        this.patientEmail = patientEmail;
        this.patientGender = patientGender;
        this.userType = userType;
        this.patientUid=patientUid;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public String getUserType() {
        return userType;
    }

    public String getPatientUid() {
        return patientUid;
    }
}
