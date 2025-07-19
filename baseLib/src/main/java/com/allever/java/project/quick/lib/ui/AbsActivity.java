package com.allever.java.project.quick.lib.ui;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.allever.java.project.quick.lib.R;
import com.allever.java.project.quick.lib.helper.ActivityHelper;
import com.allever.java.project.quick.lib.statusbar.StatusBarCompat;
import com.allever.java.project.quick.lib.swipeback.BGAKeyboardUtil;
import com.allever.java.project.quick.lib.swipeback.BGASwipeBackHelper;
import com.allever.java.project.quick.lib.util.LogUtils;
import com.allever.java.project.quick.lib.util.ToastUtils;

import java.lang.ref.WeakReference;

public abstract class AbsActivity extends AppCompatActivity implements BGASwipeBackHelper.Delegate {

    private BGASwipeBackHelper mSwipeBackHelper;
    private WeakReference<Activity> mWeakActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // 「必须在 Application 的 onCreate 方法中执行 BGASwipeBackHelper.init 来初始化滑动返回」
        // 在 super.onCreate(savedInstanceState) 之前调用该方法
        if (enableEnterAnim()){
            initSwipeBackFinish();
        }

        if (isFullScreen()) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE | View.SYSTEM_UI_FLAG_FULLSCREEN);
            StatusBarCompat.translucentStatusBar(this, true);
        }

        ////状态栏颜色
        if (isDarkMode()) {
            StatusBarCompat.cancelLightStatusBar(this);
        } else {
            StatusBarCompat.changeToLightStatusBar(this);
        }

        super.onCreate(savedInstanceState);
        LogUtils.d("onCreate: " + getClass().getSimpleName());
        mWeakActivity = new WeakReference<>(this);
        ActivityHelper.getIns().addActivity(mWeakActivity);

        if (enableEnterAnim()) {
            //打开动画
            overridePendingTransition(R.anim.open_begin, R.anim.open_end);
        }

        initView();
        initData();

    }

    /**
     * 初始化滑动返回。在 super.onCreate(savedInstanceState) 之前调用该方法
     */
    private void initSwipeBackFinish() {
        mSwipeBackHelper = new BGASwipeBackHelper(this, this);

        // 「必须在 Application 的 onCreate 方法中执行 BGASwipeBackHelper.init 来初始化滑动返回」
        // 下面几项可以不配置，这里只是为了讲述接口用法。

        // 设置滑动返回是否可用。默认值为 true
        mSwipeBackHelper.setSwipeBackEnable(true);
        // 设置是否仅仅跟踪左侧边缘的滑动返回。默认值为 true
        mSwipeBackHelper.setIsOnlyTrackingLeftEdge(true);
        // 设置是否是微信滑动返回样式。默认值为 true
        mSwipeBackHelper.setIsWeChatStyle(true);
        // 设置阴影资源 id。默认值为 R.drawable.bga_sbl_shadow
        mSwipeBackHelper.setShadowResId(R.drawable.bga_sbl_shadow);
        // 设置是否显示滑动返回的阴影效果。默认值为 true
        mSwipeBackHelper.setIsNeedShowShadow(true);
        // 设置阴影区域的透明度是否根据滑动的距离渐变。默认值为 true
        mSwipeBackHelper.setIsShadowAlphaGradient(true);
        // 设置触发释放后自动滑动返回的阈值，默认值为 0.3f
        mSwipeBackHelper.setSwipeBackThreshold(0.3f);
        // 设置底部导航条是否悬浮在内容上，默认值为 false
        mSwipeBackHelper.setIsNavigationBarOverlap(false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ActivityHelper.getIns().resumeTop(mWeakActivity);
    }


    @Override
    protected void onDestroy() {
        ActivityHelper.getIns().removeActivity(mWeakActivity);
        super.onDestroy();
    }

    @Override
    public boolean isSupportSwipeBack() {
        return true;
    }

    /**
     * 正在滑动返回
     *
     * @param slideOffset 从 0 到 1
     */
    @Override
    public void onSwipeBackLayoutSlide(float slideOffset) {

    }

    /**
     * 没达到滑动返回的阈值，取消滑动返回动作，回到默认状态
     */
    @Override
    public void onSwipeBackLayoutCancel() {

    }

    /**
     * 滑动返回执行完毕，销毁当前 Activity
     */
    @Override
    public void onSwipeBackLayoutExecuted() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
            mSwipeBackHelper.swipeBackward();
        } else {
            BGAKeyboardUtil.closeKeyboard(this);
            finish();
            //TODO 动画造成关闭界面闪动
            overridePendingTransition(0, 0);
        }
    }

    @Override
    public void onBackPressed() {
        if (!enableExitAnim()) {
            super.onBackPressed();
            return;
        }
        // 正在滑动返回的时候取消返回按钮事件
        if (mSwipeBackHelper.isSliding()) {
            return;
        }
        mSwipeBackHelper.backward();

    }

    private long firstPressedBackTime = 0;

    protected void checkExit(Runnable task) {
        if (System.currentTimeMillis() - firstPressedBackTime < 2000) {
            task.run();
            super.onBackPressed();
        } else {
            ToastUtils.show("再按一次退出");
            firstPressedBackTime = System.currentTimeMillis();
        }
    }

    private boolean enableExitAnim() {
        return true;
    }

    /**
     * true: 黑夜模式，白色字体
     * false：白光模式，黑色字体
     *
     * @return isDarkMode
     */
    protected boolean isDarkMode() {
        return true;
    }

    protected boolean isFullScreen() {
        return true;
    }

    protected boolean enableEnterAnim() {
        return true;
    }

    protected abstract void initView();
    protected abstract void initData();


}
