package com.example.healthcare;

import android.graphics.drawable.Drawable;

public class Model_Tutorial {
    private int cardImage;
    private String Title;
    private int cardBackgroud;

    public int getCardBackgroud() {
        return cardBackgroud;
    }

    public void setCardBackgroud(int cardBackgroud) {
        this.cardBackgroud = cardBackgroud;
    }



    public Model_Tutorial(int cardImage, String title) {
        this.cardImage = cardImage;
        this.Title = title;
    }

    public int getCardImage() {
        return cardImage;
    }

    public void setCardImage(int cardImage) {
        this.cardImage = cardImage;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }
}
