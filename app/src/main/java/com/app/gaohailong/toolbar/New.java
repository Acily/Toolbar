package com.app.gaohailong.toolbar;

/**
 * Created by donglinghao on 2015-10-30.
 */
public class New {
    private String title;
    private int imageUrl;
    private String time;

    public New(String title, int imageUrl, String time) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
