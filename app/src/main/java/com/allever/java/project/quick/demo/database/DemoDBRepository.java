package com.allever.java.project.quick.demo.database;

import androidx.sqlite.db.SimpleSQLiteQuery;

import com.allever.java.project.quick.demo.database.dao.BillRecordDao;
import com.allever.java.project.quick.demo.database.dao.DishesDao;
import com.allever.java.project.quick.demo.database.entity.BillDishesRecordEntity;
import com.allever.java.project.quick.demo.database.entity.BillRecordEntity;
import com.allever.java.project.quick.demo.database.entity.BillWithDishesRef;
import com.allever.java.project.quick.demo.database.entity.DishesEntity;
import com.allever.java.project.quick.lib.App;
import com.allever.java.project.quick.lib.util.LogUtils;

import java.util.List;

public class DemoDBRepository {

    private DemoAppDatabase mAppDatabase;

    private DishesDao mDishesDao;
    private BillRecordDao mBillRecordDao;


    public static DemoDBRepository getInstance() {
        return DataBaseRepositoryHolder.instance;
    }

    //constructor
    private DemoDBRepository() {
        mAppDatabase = DemoAppDatabase.getDatabase(App.context);
        mDishesDao = mAppDatabase.dishesDao();
        mBillRecordDao = mAppDatabase.billRecordDao();
    }

    //Dishes///////////////////////////////////////////////////////////////////////////////////////
    //addDishes
    public void addDishes(DishesEntity dishesEntity) {
        mDishesDao.addDishes(dishesEntity);
    }

    //deleteAllDishes
    public void deleteAllDishes() {
        mDishesDao.deleteAll();
    }

    //getDishesList
    public List<DishesEntity> getDishesList() {
        return mDishesDao.getAll();
    }

    //getDishesByCode
    public DishesEntity getDishesByCode(String code) {
        return mDishesDao.getByCode(code);
    }

    //getByThirdSortId
    public List<DishesEntity> getDishesListByThirdId(int thirdId) {
        return mDishesDao.getDishesListByThirdId(thirdId);
    }


    //BillRecord///////////////////////////////////////////////////////////////////////////////////
    //addBillRecord
    public void addBillRecord(BillRecordEntity billRecordEntity) {
        mBillRecordDao.addBillRecord(billRecordEntity);
    }

    //addBillWithDishesRecord
    public void addBillDishesRecord(BillDishesRecordEntity billWithDishesRef) {
        mBillRecordDao.addBillDishesRecord(billWithDishesRef);
    }

    //getAllBillWithDishesList
    public List<BillWithDishesRef> getAllBillWithDishesList() {
        return mBillRecordDao.getBillWithDishesList();
    }

    //getLastBillRecord
    public BillRecordEntity getLastBillRecord() {
        return mBillRecordDao.getLastBillRecord();
    }

    public List<BillWithDishesRef> getBillList(int selectedUserId, long selectedDate, int selectPayType, String selectSortCondition) {
        long[] oneDay7amTimestamps = DemoTimeUtils.get7amTimestamps(selectedDate);
        long startTime = oneDay7amTimestamps[0];
        long endTime = oneDay7amTimestamps[1];
        String sql = "SELECT * FROM bill_record WHERE billUserId = " + selectedUserId + " AND payType = " + selectPayType + " AND createTime >= " + startTime + " AND createTime < " + endTime + " ORDER BY " + selectSortCondition;
        if (selectedUserId == 0) {
            if (selectPayType == DemoPayType.PAY_TYPE_ALL) {
                sql = "SELECT * FROM bill_record WHERE createTime >= " + startTime + " AND createTime < " + endTime + " ORDER BY " + selectSortCondition;
            } else {
                sql = "SELECT * FROM bill_record WHERE payType = " + selectPayType + " AND createTime >= " + startTime + " AND createTime < " + endTime + " ORDER BY " + selectSortCondition;
            }
        } else {
            if (selectPayType == DemoPayType.PAY_TYPE_ALL) {
                sql = "SELECT * FROM bill_record WHERE billUserId = " + selectedUserId + " AND createTime >= " + startTime + " AND createTime < " + endTime + " ORDER BY " + selectSortCondition;
            } else {
                sql = "SELECT * FROM bill_record WHERE billUserId = " + selectedUserId + " AND payType = " + selectPayType + " AND createTime >= " + startTime + " AND createTime < " + endTime + " ORDER BY " + selectSortCondition;
            }
        }

        LogUtils.d("boss sql = " + sql);

        return mBillRecordDao.getBySql(new SimpleSQLiteQuery(sql));

    }

    //getBillByTableCodeOrderByTimeDesc
    public List<BillWithDishesRef> getBillByTableCodeOrderByTimeDesc(int tableCode) {
        return mBillRecordDao.getByTableCodeOrderByCreateTimeDesc(tableCode);
    }

    //getBillById
    public BillWithDishesRef getBillById(int id) {
        return mBillRecordDao.getById(id);
    }

    //updateBill
    public void updateBill(BillRecordEntity billRecordEntity) {
        mBillRecordDao.updateBillRecord(billRecordEntity);
    }

    public void deleteAllBill() {
        mBillRecordDao.deleteAll();
    }

    //inner static  class
    private static class DataBaseRepositoryHolder {
        private static final DemoDBRepository instance = new DemoDBRepository();
    }
}
