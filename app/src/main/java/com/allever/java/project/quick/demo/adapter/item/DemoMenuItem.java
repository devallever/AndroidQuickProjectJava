package com.allever.java.project.quick.demo.adapter.item;

public class DemoMenuItem {
    private int iconResId;
    private Runnable action;

    public DemoMenuItem(int iconResId, Runnable action) {
        this.iconResId = iconResId;
        this.action = action;
    }

    public int getIconResId() {
        return iconResId;
    }

    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }

    public Runnable getAction() {
        return action;
    }

    public void setAction(Runnable action) {
        this.action = action;
    }
}
