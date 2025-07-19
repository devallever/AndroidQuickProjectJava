package com.allever.java.project.quick.demo.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.room.Transaction;
import androidx.room.Update;
import androidx.sqlite.db.SupportSQLiteQuery;


import com.allever.java.project.quick.demo.database.entity.BillDishesRecordEntity;
import com.allever.java.project.quick.demo.database.entity.BillRecordEntity;
import com.allever.java.project.quick.demo.database.entity.BillWithDishesRef;

import java.util.List;

@Dao
public interface BillRecordDao {

    //ADD
    @Insert
    void addBillRecord(BillRecordEntity billRecordEntity);

    //add BillDishesRecord
    @Insert
    void addBillDishesRecord(BillDishesRecordEntity billDishesRecordEntity);

    //getBillWithDishesList
    @Transaction
    @Query("SELECT * FROM bill_record")
    List<BillWithDishesRef> getBillWithDishesList();

    //getLastBillRecord
    @Query("SELECT * FROM bill_record ORDER BY id DESC LIMIT 1")
    BillRecordEntity getLastBillRecord();

    /***
     * getBillDishesRecordListBy billUserId, payType, createTime > startTime and createTime < endTime order by billCode asc
     * 跑堂当天类型账单
     * @return
     */
//    @Transaction
//    @Query("SELECT * FROM bill_record WHERE billUserId = :billUserId AND createTime >= :startTime AND createTime < :endTime ORDER BY " +
//            "CASE WHEN :sortBy = 'createTime' THEN createTime END, " +
//            "CASE WHEN :sortBy = 'tableCode' THEN tableCode END, " +
//            "CASE WHEN :sortBy = 'billCode' THEN billCode END, " +
//            "CASE WHEN :sortBy = 'amount' THEN amount END " +
//            "asc")
//    public List<BillWithDishesRef> getBillDishesRecordListByBillUserIdAndCreateTimeOrderBy(int billUserId, long startTime, long endTime, String sortBy, String sortOrder);
    @Transaction
    @RawQuery
    List<BillWithDishesRef> getBySql(SupportSQLiteQuery query);

    //getByTableCode order by createTime DESC
    @Transaction
    @Query("SELECT * FROM bill_record WHERE tableCode = :tableCode ORDER BY createTime DESC")
    List<BillWithDishesRef> getByTableCodeOrderByCreateTimeDesc(int tableCode);

    @Transaction
    @Query("SELECT * FROM bill_record WHERE id = :id")
    BillWithDishesRef getById(int id);

    @Update
    void updateBillRecord(BillRecordEntity billRecordEntity);

    //delete all
    @Query("DELETE FROM bill_record")
    void deleteAll();
}
