package com.pesteam.paditech_android_huynq_first;

import java.util.ArrayList;

/**
 * Created by bangindong on 12/8/2017.
 */

public class Screen4ChildAdapterClass {
    final static int TYPE_WATCHED = 1;
    final static int TYPE_NOT_WATCH = 2;
    final static int TYPE_CLICK = 1;
    final static int TYPE_UNCLICK = 2;
    final static int STATUS_WOW = 0;
    final static int STATUS_LIKE = 1;
    final static int STATUS_CMT = 2;
    final static int STATUS_FB = 3;
    private String[] list_people;
    private int action_watch;
    private String img;
    private String text;
    private int status;
    private int action_click;
    private String time;

    public Screen4ChildAdapterClass(String[] list_people, int action_watch, String img, String text, int status, int action_click, String time) {
        this.list_people = list_people;
        this.action_watch = action_watch;
        this.img = img;
        this.text = text;
        this.status = status;
        this.action_click = action_click;
        this.time = time;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getAction_watch() {
        return action_watch;
    }

    public void setAction_watch(int action_watch) {
        this.action_watch = action_watch;
    }

    public int getAction_click() {
        return action_click;
    }

    public void setAction_click(int action_click) {
        this.action_click = action_click;
    }

    public String[] getList_people() {
        return list_people;
    }

    public void setList_people(String[] list_people) {
        this.list_people = list_people;
    }
}
