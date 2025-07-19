package com.allever.java.project.quick.lib.helper;

import android.app.Activity;

import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public class ActivityHelper {

    private final List<WeakReference<Activity>> weakActivityList = new LinkedList<>();
    //inner static class
    private static class ActivityHelperHolder {
        private static final ActivityHelper instance = new ActivityHelper();
    }
    public static ActivityHelper getIns() {
        return ActivityHelperHolder.instance;
    }

    //add weakActivity
    public void addActivity(WeakReference<Activity> activity) {
        if (activity == null || activity.get() == null) {
            return;
        }
        weakActivityList.add(activity);
    }

    public void removeActivity(WeakReference<Activity> activity) {
        if (activity == null || activity.get() == null) {
            return;
        }
        weakActivityList.remove(activity);
    }

    public void resumeTop(WeakReference<Activity> activity) {
        if (activity == null || activity.get() == null) {
            return;
        }
        int index = weakActivityList.indexOf(activity);
        if (index == -1) {
            return;
        }

        weakActivityList.add(0, weakActivityList.remove( index));
    }


}
