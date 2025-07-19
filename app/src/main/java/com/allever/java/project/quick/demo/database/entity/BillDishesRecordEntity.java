package com.allever.java.project.quick.demo.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "bill_dishes_record",
        foreignKeys = {
                @ForeignKey(entity = BillRecordEntity.class,
                        parentColumns = "id",
                        childColumns = "billId",
                        onDelete = ForeignKey.CASCADE),
//                @ForeignKey(entity = DishesEntity.class,
//                        parentColumns = "code",
//                        childColumns = "dishesCode")
        })
public class BillDishesRecordEntity {

    //id
    @PrimaryKey(autoGenerate = true)
    private int id;
    //订单id
    @ColumnInfo(index = true)
    private int billId;
    private int count;
    private String dishesCode;

    private String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDishesCode() {
        return dishesCode;
    }

    public void setDishesCode(String dishesCode) {
        this.dishesCode = dishesCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
