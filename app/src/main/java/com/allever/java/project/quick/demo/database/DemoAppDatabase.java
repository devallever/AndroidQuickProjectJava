package com.allever.java.project.quick.demo.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.allever.java.project.quick.demo.database.dao.BillRecordDao;
import com.allever.java.project.quick.demo.database.dao.DishesDao;
import com.allever.java.project.quick.demo.database.entity.BillDishesRecordEntity;
import com.allever.java.project.quick.demo.database.entity.BillRecordEntity;
import com.allever.java.project.quick.demo.database.entity.DishesEntity;


@Database(entities = {
        DishesEntity.class,
        BillRecordEntity.class,
        BillDishesRecordEntity.class,},
        version = 1,
        exportSchema = false)
public abstract class DemoAppDatabase extends RoomDatabase {

    // 单例实例
    private static volatile DemoAppDatabase INSTANCE;

    //getDatabase
    public static DemoAppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DemoAppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DemoAppDatabase.class, "app_database.db").fallbackToDestructiveMigration() // 开发阶段使用（生产环境移除）
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract DishesDao dishesDao();

    public abstract BillRecordDao billRecordDao();

}
