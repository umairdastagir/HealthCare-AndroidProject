package com.example.healthcare.Model;

public class AnsweredModelClass implements Comparable<AnsweredModelClass> {
    String doctorUid;
    String nameOfDoctor;
    String Answer;
    String pushKey;
    String pushKeyOfPost;
    int totalLikes;


    public String getDoctorUid() {
        return doctorUid;
    }

    public void setDoctorUid(String doctorUid) {
        this.doctorUid = doctorUid;
    }

    public String getNameOfDoctor() {
        return nameOfDoctor;
    }

    public void setNameOfDoctor(String nameOfDoctor) {
        this.nameOfDoctor = nameOfDoctor;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public String getPushKey() {
        return pushKey;
    }

    public void setPushKey(String pushKey) {
        this.pushKey = pushKey;
    }

    public String getPushKeyOfPost() {
        return pushKeyOfPost;
    }

    public void setPushKeyOfPost(String pushKeyOfPost) {
        this.pushKeyOfPost = pushKeyOfPost;
    }

    public int getTotalLikes() {
        return totalLikes;
    }

    public void setTotalLikes(int totalLikes) {
        this.totalLikes = totalLikes;
    }

    public AnsweredModelClass() {
    }

    public AnsweredModelClass(String doctorUid, String nameOfDoctor, String answer, String pushKey, String pushKeyOfPost, int totalLikes) {
        this.doctorUid = doctorUid;
        this.nameOfDoctor = nameOfDoctor;
        Answer = answer;
        this.pushKey = pushKey;
        this.pushKeyOfPost = pushKeyOfPost;
        this.totalLikes = totalLikes;
    }

    @Override
    public int compareTo(AnsweredModelClass answeredModelClass) {
        int compareLikes=answeredModelClass.getTotalLikes();
        return compareLikes - totalLikes;
       // return this.totalLikes - compareLikes;
    }
}
