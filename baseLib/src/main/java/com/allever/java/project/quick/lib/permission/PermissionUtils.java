package com.allever.java.project.quick.lib.permission;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.app.AppOpsManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.allever.java.project.quick.lib.util.ToastUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermissionUtils {

    public static final int REQUEST_CODE_PERMISSION = 0x01;
    public static final int RC_PERMISSION_MANUAL = 0x02;


    public static void requestPermissionList(Activity activity, List<String> permission) {
        //List转数组
        String[] permissionArray = permission.toArray(new String[permission.size()]);
        requestPermissionArray(activity, permissionArray);
    }

    public static void requestPermissionArray(Activity activity, String[] permission) {
        requestPermission(activity, permission);
    }

    public static void requestPermission(Activity activity, String... permission) {
        ActivityCompat.requestPermissions(activity, permission, REQUEST_CODE_PERMISSION);
    }

    public static void requestMediaStorePermission(Activity activity, Runnable agreeTask) {
        List<String> permissionList = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {

        } else {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (permissionList.isEmpty()) {
            if (agreeTask != null) {
                agreeTask.run();
            }
        } else {
            requestPermissionList(activity, permissionList);
        }
    }

    public static boolean hasPermission(Context context, String... permissions) {
        return hasPermissionList(context, Arrays.asList(permissions));
    }

    public static boolean hasPermissionArray(Context context, String[] permissions) {
        return hasPermissionList(context, Arrays.asList(permissions));
    }

    public static boolean hasPermissionList(Context context, List<String> permissions) {
        if (context == null) {
            return false;
        }

        for (String permission : permissions) {
            int result = ContextCompat.checkSelfPermission(context, permission);
            if (result == PackageManager.PERMISSION_DENIED) {
                return false;
            }

            String op = AppOpsManagerCompat.permissionToOp(permission);
            if (TextUtils.isEmpty(op)) {
                continue;
            }
            result = AppOpsManagerCompat.noteProxyOp(context, op, context.getPackageName());
            if (result != AppOpsManagerCompat.MODE_ALLOWED) {
                return false;
            }
        }
        return true;
    }

    public static void gotoSetting(Activity activity) {
        openAppDetailSetting(activity);
    }

    public static boolean hasAlwaysDeniedPermissionArray(Object context, String[] deniedPermissions) {
        return hasAlwaysDeniedPermissionList(context, Arrays.asList(deniedPermissions));
    }

    public static boolean hasAlwaysDeniedPermission(Object context, String... deniedPermissions) {
        return hasAlwaysDeniedPermissionList(context, Arrays.asList(deniedPermissions));
    }

    public static boolean hasAlwaysDeniedPermissionList(Object context, List<String> deniedPermissions) {

        if (deniedPermissions.isEmpty()) {
            return false;
        }

        Activity activity = null;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else if (context instanceof Fragment) {
            activity = ((Fragment) context).requireActivity();
        }

        if (activity == null) {
            return false;
        }

        for (String permission : deniedPermissions) {
            boolean rationale = activity.shouldShowRequestPermissionRationale(permission);
            if (!rationale) {
                return true;
            }
        }
        return false;
    }

    private static Intent getAppDetailSettingIntent(Activity activity) {
        Intent localIntent = new Intent();
        localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            localIntent.setData(Uri.fromParts("package", activity.getPackageName(), null));
        } else if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.FROYO) {
            localIntent.setAction(Intent.ACTION_VIEW);
            localIntent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
            localIntent.putExtra("com.android.settings.ApplicationPkgName", activity.getPackageName());
        }

        return localIntent;
    }

    public static void openAppDetailSetting(Activity activity) {
        activity.startActivityForResult(getAppDetailSettingIntent(activity), RC_PERMISSION_MANUAL);
    }

    public static void handlePermissionResult(Activity activity, String[] permissions, int requestCode, Runnable agreeTask) {
        if (requestCode == REQUEST_CODE_PERMISSION) {
            if (hasPermission(activity, permissions)) {
                agreeTask.run();
            } else if (hasAlwaysDeniedPermissionArray(activity, permissions)) {
                //构建一个Dialog 提示 跳转设置
                new AlertDialog.Builder(activity).setTitle("提示").setMessage("请前往设置页面授权").setPositiveButton("确定", (dialog, which) -> PermissionUtils.gotoSetting(activity)).setNegativeButton("取消", (dialog, which) -> {
                    dialog.dismiss();
                }).show();
            } else {
                ToastUtils.show("no permission");
            }
        }
    }
}
