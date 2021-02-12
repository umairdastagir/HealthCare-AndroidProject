package com.example.healthcare.Model;

public class Like {
    boolean Liked;
    String userId;
    String pushKeyOfPost;

    public Like(boolean liked, String userId, String pushKeyOfPost) {
        Liked = liked;
        this.userId = userId;
        this.pushKeyOfPost = pushKeyOfPost;
    }

    public Like() {
    }

    public boolean isLiked() {
        return Liked;
    }

    public void setLiked(boolean liked) {
        Liked = liked;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPushKeyOfPost() {
        return pushKeyOfPost;
    }

    public void setPushKeyOfPost(String pushKeyOfPost) {
        this.pushKeyOfPost = pushKeyOfPost;
    }
}
