package com.allever.java.project.quick.lib.image;

import android.graphics.Bitmap;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import com.allever.java.project.quick.lib.util.DisplayUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleWithBorderTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class ImageLoader {
    public static void loadImage(@NonNull ImageView target, Object source) {
        Glide.with(target.getContext()).load(source).into(target);
    }

    public static void loadRound(@NonNull ImageView target, Object source, int radius) {
        //不行
//        Glide.with(target.getContext()).load(source).apply(RequestOptions.bitmapTransform(new RoundedCornersTransformation(radius, 0))).into(target);
        //ok issues https://github.com/wasabeef/glide-transformations/issues/151
        Glide.with(target.getContext()).load(source).transform(new CenterCrop(),new RoundedCornersTransformation(radius, 0)).into( target);
//        Glide.with(target.getContext()).load(source).into(new BitmapImageViewTarget(target) {
//            @Override
//            protected void setResource(Bitmap resource) {
//                super.setResource(resource);
//                RoundedBitmapDrawable rbd =
//                        RoundedBitmapDrawableFactory.create(target.getContext().getResources(), resource);
//                rbd.setCornerRadius(radius);
//                target.setImageDrawable(rbd);
//            }
//        }.getView());
    }

    public static void loadCircle(@NonNull ImageView target, Object source) {
        Glide.with(target.getContext()).load(source).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(target);
    }

    public static void loadBroderCircle(@NonNull ImageView target, Object source, int borderWidth, int color) {
        Glide.with(target.getContext()).load(source).apply(RequestOptions.bitmapTransform(new CropCircleWithBorderTransformation(borderWidth, color))).into(target);
    }

    public static void loadGif(@NonNull ImageView target, Object source) {

    }

    public static void loadBlur(@NonNull ImageView target, Object source) {
        Glide.with(target.getContext()).load(source).apply(RequestOptions.bitmapTransform(new BlurTransformation())).into(target);
    }

    public static void loadRoundBlur(@NonNull ImageView target, Object source, int radius) {
//        Glide.with(target.getContext()).load(source).transform(new BlurTransformation(), new RoundedCornersTransformation(radius, 0)).into( target);
    }


}
