package com.pesteam.paditech_android_huynq_first;

/**
 * Created by bangindong on 12/11/2017.
 */

public class Screen5ChildAdapterVerticalClass {
        private String img;
        private int status;
        private String name;
        private String content;
        private int youWatchedOrNot;
        private int frWatchedOrNot;
        private int whoSend;
        private String time;

    public Screen5ChildAdapterVerticalClass(String img, int status, String name, String content, int youWatchedOrNot, int frWatchedOrNot, int whoSend, String time) {
        this.img = img;
        this.status = status;
        this.name = name;
        this.content = content;
        this.youWatchedOrNot = youWatchedOrNot;
        this.frWatchedOrNot = frWatchedOrNot;
        this.whoSend = whoSend;
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYouWatchedOrNot() {
        return youWatchedOrNot;
    }

    public void setYouWatchedOrNot(int youWatchedOrNot) {
        this.youWatchedOrNot = youWatchedOrNot;
    }

    public int getFrWatchedOrNot() {
        return frWatchedOrNot;
    }

    public void setFrWatchedOrNot(int frWatchedOrNot) {
        this.frWatchedOrNot = frWatchedOrNot;
    }

    public int getWhoSend() {
        return whoSend;
    }

    public void setWhoSend(int whoSend) {
        this.whoSend = whoSend;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
