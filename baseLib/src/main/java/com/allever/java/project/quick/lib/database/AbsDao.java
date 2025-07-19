package com.allever.java.project.quick.lib.database;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;


public interface AbsDao<T> {

    //add
    @Insert
    void add(T entity);

    @Delete
    void delete(T entity);

    // Update
    @Update
    void update(T entity);
}
