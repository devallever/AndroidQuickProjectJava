package com.allever.java.project.quick.demo.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "dishes")
public class DishesEntity {

    //primarykey id
    @PrimaryKey(autoGenerate = true)
    private int id;

    //firstId
    private int firstId;
    //secondId
    private int secondId;
    //thirdId
    private int thirdId;
    private int firstSortType;
    //dishesId
    private int dishesId;
    //code
    private String code;
    //name
    private String name;
    //price
    private float price;
    //taxInHouse
    private double taxInHouse;
    //TaxTakeout
    private double taxTakeout;
    //buffetType
    private String buffetType;
    //enablePrint
    private boolean enablePrint;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFirstId() {
        return firstId;
    }

    public void setFirstId(int firstId) {
        this.firstId = firstId;
    }

    public int getSecondId() {
        return secondId;
    }

    public void setSecondId(int secondId) {
        this.secondId = secondId;
    }

    public int getThirdId() {
        return thirdId;
    }

    public void setThirdId(int thirdId) {
        this.thirdId = thirdId;
    }

    public int getDishesId() {
        return dishesId;
    }

    public void setDishesId(int dishesId) {
        this.dishesId = dishesId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public double getTaxInHouse() {
        return taxInHouse;
    }

    public void setTaxInHouse(double taxInHouse) {
        this.taxInHouse = taxInHouse;
    }

    public double getTaxTakeout() {
        return taxTakeout;
    }

    public void setTaxTakeout(double taxTakeout) {
        this.taxTakeout = taxTakeout;
    }

    public String getBuffetType() {
        return buffetType;
    }

    public void setBuffetType(String buffetType) {
        this.buffetType = buffetType;
    }

    public boolean isEnablePrint() {
        return enablePrint;
    }

    public void setEnablePrint(boolean enablePrint) {
        this.enablePrint = enablePrint;
    }

    public int getFirstSortType() {
        return firstSortType;
    }

    public void setFirstSortType(int firstSortType) {
        this.firstSortType = firstSortType;
    }
}
