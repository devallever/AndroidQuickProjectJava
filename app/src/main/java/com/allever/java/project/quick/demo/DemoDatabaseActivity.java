package com.allever.java.project.quick.demo;

import com.allever.java.project.quick.databinding.DemoActivityDatabaseBinding;
import com.allever.java.project.quick.demo.base.DemoBaseActivity;
import com.allever.java.project.quick.demo.database.DemoDBRepository;
import com.allever.java.project.quick.demo.database.DemoPayType;
import com.allever.java.project.quick.demo.database.DemoTimeUtils;
import com.allever.java.project.quick.demo.database.entity.BillDishesRecordEntity;
import com.allever.java.project.quick.demo.database.entity.BillRecordEntity;
import com.allever.java.project.quick.demo.database.entity.BillWithDishesRef;
import com.allever.java.project.quick.demo.database.entity.DishesEntity;
import com.allever.java.project.quick.lib.util.GsonUtils;
import com.allever.java.project.quick.lib.util.ThreadUtils;

import java.util.List;

public class DemoDatabaseActivity extends DemoBaseActivity<DemoActivityDatabaseBinding> {

    private int userId = 0; // form 1 to 50
    @Override
    protected DemoActivityDatabaseBinding getViewBinding() {
        return DemoActivityDatabaseBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initView() {
        adaptStatusBar();
        mBinding.btnInitDatabaseData.setOnClickListener(v -> {
            userId++;
            if (userId > 10) {
                userId = 1;
            }

            ThreadUtils.runOnIoThreadDelayed(() -> {
                List<BillWithDishesRef> billWithDishesList = DemoDBRepository.getInstance().getBillList(userId, DemoTimeUtils.getToday7amTimestamp(), DemoPayType.PAY_TYPE_ALL, "createTime DESC");
                ThreadUtils.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mBinding.tvResult.setText(GsonUtils.toJson(billWithDishesList));
                    }
                });
            });
        });
    }

    @Override
    protected void initData() {
        initDatabaseData();
    }

    private void initDatabaseData() {
        ThreadUtils.runOnIoThreadDelayed(() -> {
            //delete all dishes
            DemoDBRepository.getInstance().deleteAllDishes();
            DemoDBRepository.getInstance().deleteAllBill();

            //add 50 dishes
            for (int i = 1; i <= 50; i++) {
                DishesEntity dishesEntity = new DishesEntity();
                dishesEntity.setCode(i+"");
                dishesEntity.setName("Dishes" + i);
                dishesEntity.setPrice(i);
                dishesEntity.setTaxInHouse(i);
                dishesEntity.setTaxTakeout(i);
                dishesEntity.setBuffetType("B" + i);
                dishesEntity.setEnablePrint(true);
                dishesEntity.setFirstSortType(1);
                DemoDBRepository.getInstance().addDishes(dishesEntity);
            }

            //add 10 billRecord
            for (int i = 1; i <= 10; i++) {
                BillRecordEntity billRecordEntity = new BillRecordEntity();
                billRecordEntity.setBillCode(i);
                billRecordEntity.setBillUserId(i);
                billRecordEntity.setTableCode(i);
                billRecordEntity.setCreateTime(System.currentTimeMillis());
                billRecordEntity.setAmount(i);
                billRecordEntity.setPayTotal(i);
                billRecordEntity.setTipsTotal(i);
                billRecordEntity.setPayType(DemoPayType.PAY_TYPE_CASH);
                billRecordEntity.setOrderType(1);
                billRecordEntity.setUpload(false);
                billRecordEntity.setCanceled(false);
                DemoDBRepository.getInstance().addBillRecord(billRecordEntity);
                BillRecordEntity lastBillRecord = DemoDBRepository.getInstance().getLastBillRecord();

                for (int j = 0; j < i; j++) {
                    BillDishesRecordEntity billWithDishesRef = new BillDishesRecordEntity();
                    billWithDishesRef.setBillId(lastBillRecord.getId());
                    billWithDishesRef.setCount(i);
                    DishesEntity dishesEntity = DemoDBRepository.getInstance().getDishesByCode(j+1 + "");
                    billWithDishesRef.setDishesCode(dishesEntity.getCode());
                    //add
                    DemoDBRepository.getInstance().addBillDishesRecord(billWithDishesRef);
                }
            }
        });
    }
}
