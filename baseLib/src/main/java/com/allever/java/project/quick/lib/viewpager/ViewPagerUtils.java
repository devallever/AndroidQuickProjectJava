package com.allever.java.project.quick.lib.viewpager;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.lang.reflect.Field;

public class ViewPagerUtils {
    /**
     * 设置 ViewPager2 的滑动阈值，解决灵敏度问题
     *
     * @param viewPager 要修改的 ViewPager2 实例
     */
    public static void modifyTouchSlop(@NonNull ViewPager2 viewPager) {
        try {
            // 获取 ViewPager2 中的 mRecyclerView 字段
            Field recyclerViewField = ViewPager2.class.getDeclaredField("mRecyclerView");
            recyclerViewField.setAccessible(true);
            RecyclerView recyclerView = (RecyclerView) recyclerViewField.get(viewPager);

            // 获取 RecyclerView 中的 mTouchSlop 字段
            Field touchSlopField = RecyclerView.class.getDeclaredField("mTouchSlop");
            touchSlopField.setAccessible(true);
            int touchSlop = (int) touchSlopField.get(recyclerView);

            // 修改滑动阈值，乘以一个经验值（例如 4）
            touchSlopField.set(recyclerView, touchSlop * 4);
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
    }
}
