package com.bob.frescodemo.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.ColorInt;
import android.view.View;

/**
 * Author: bob
 * Date: 16-3-12.
 */
public class ImageUtils {

    /**
     * 为图片添加网格
     *
     * @param bitmap
     * @param color
     */
    public static void addBlock(Bitmap bitmap, @ColorInt int color) {
        for (int x = 0; x < bitmap.getWidth(); x += 2) {
            for (int y = 0; y < bitmap.getHeight(); y += 2) {
                bitmap.setPixel(x, y, color);
            }
        }
    }

    public static void doBlur(Bitmap bitmap) {

//        int width = bitmap.getWidth();
//        int height = bitmap.getHeight();
//        float scaleWidth = 0.25f;
//        float scaleHeight = 0.25f;
//
//        Matrix matrix = new Matrix();
//        matrix.postScale(scaleWidth, scaleHeight);
//        // if you want to rotate the Bitmap
//        // matrix.postRotate(45);
//        bitmap = Bitmap.createBitmap(bitmap, 0, 0, width,
//                height, matrix, true);
//        float scaleFactor = 8;//图片缩放比例；
        int radius = 80;//模糊程度

        FastBlur.doBlur(bitmap,radius, true);
    }

}
