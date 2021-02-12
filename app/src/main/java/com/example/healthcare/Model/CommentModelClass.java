package com.example.healthcare.Model;

public class CommentModelClass {

    String UserUid;
    String nameOfUser;
    String pushKeyOfPost;
    String Comment;
    String pushKey;

    public String getUserUid() {
        return UserUid;
    }

    public void setUserUid(String userUid) {
        UserUid = userUid;
    }

    public String getNameOfUser() {
        return nameOfUser;
    }

    public void setNameOfUser(String nameOfUser) {
        this.nameOfUser = nameOfUser;
    }

    public String getPushKeyOfPost() {
        return pushKeyOfPost;
    }

    public void setPushKeyOfPost(String pushKeyOfPost) {
        this.pushKeyOfPost = pushKeyOfPost;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public String getPushKey() {
        return pushKey;
    }

    public void setPushKey(String pushKey) {
        this.pushKey = pushKey;
    }

    public CommentModelClass() {
    }

    public CommentModelClass(String userUid, String nameOfUser, String pushKeyOfPost, String comment, String pushKey) {
        UserUid = userUid;
        this.nameOfUser = nameOfUser;
        this.pushKeyOfPost = pushKeyOfPost;
        Comment = comment;
        this.pushKey = pushKey;
    }
}
