package com.hencoder.hencoderpracticedraw2.practice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw2.R;

public class Practice14MaskFilterView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    public Practice14MaskFilterView(Context context) {
        super(context);
    }

    public Practice14MaskFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice14MaskFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.what_the_fuck);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int radius = 100;

        // 用 Paint.setMaskFilter 来设置不同的 BlurMaskFilter

        MaskFilter maskFilter = new BlurMaskFilter(radius, BlurMaskFilter.Blur.NORMAL);
        paint.setMaskFilter(maskFilter);

        // 第一个：NORMAL
        canvas.drawBitmap(bitmap, 100, 50, paint);

        maskFilter = new BlurMaskFilter(radius, BlurMaskFilter.Blur.INNER);
        paint.setMaskFilter(maskFilter);

        // 第二个：INNER
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 200, 50, paint);

        maskFilter = new BlurMaskFilter(radius, BlurMaskFilter.Blur.OUTER);
        paint.setMaskFilter(maskFilter);

        // 第三个：OUTER
        canvas.drawBitmap(bitmap, 100, bitmap.getHeight() + 100, paint);

        maskFilter = new BlurMaskFilter(radius, BlurMaskFilter.Blur.SOLID);
        paint.setMaskFilter(maskFilter);

        // 第四个：SOLID
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 200, bitmap.getHeight() + 100, paint);
    }
}
