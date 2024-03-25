package com.example.btvn_day04.models;

public class Post {
    private String avatar;
    private String name;
    private String day;
    private String caption;
    public String picture;
    private int numReact;
    private int numCmt;
    private int numShare;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getNumReact() {
        return numReact;
    }

    public void setNumReact(int numReact) {
        this.numReact = numReact;
    }

    public int getNumCmt() {
        return numCmt;
    }

    public void setNumCmt(int numCmt) {
        this.numCmt = numCmt;
    }

    public int getNumShare() {
        return numShare;
    }

    public void setNumShare(int numShare) {
        this.numShare = numShare;
    }

    public Post(String avatar, String name, String day, String caption, String picture, int numReact, int numCmt, int numShare) {
        this.avatar = avatar;
        this.name = name;
        this.day = day;
        this.caption = caption;
        this.picture = picture;
        this.numReact = numReact;
        this.numCmt = numCmt;
        this.numShare = numShare;
    }

    public Post() {
    }

    @Override
    public String toString() {
        return "Post{" +
                "avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                ", day='" + day + '\'' +
                ", caption='" + caption + '\'' +
                ", picture='" + picture + '\'' +
                ", numReact=" + numReact +
                ", numCmt=" + numCmt +
                ", numShare=" + numShare +
                '}';
    }
}
