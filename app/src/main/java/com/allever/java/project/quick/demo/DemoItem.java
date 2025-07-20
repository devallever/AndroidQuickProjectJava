package com.allever.java.project.quick.demo;

public class DemoItem {
    //title
    private String title = "";
    //content
    private String content = "";

    private Runnable action;

    public DemoItem(String title, String content, Runnable action) {
        this.title = title;
        this.content = content;
        this.action = action;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Runnable getAction() {
        return action;
    }

    public void setAction(Runnable action) {
        this.action = action;
    }
}
