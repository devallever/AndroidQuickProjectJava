package com.allever.java.project.quick.demo;

public class DemoItem {
    //title
    private String title;
    //content
    private String content;

    public DemoItem(String title, String content) {
        this.title = title;
        this.content = content;
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
}
