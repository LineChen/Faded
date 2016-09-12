package com.beiing.faded;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by chenliu on 2016/9/12.<br/>
 * 描述：
 * </br>
 */
public class FadedView extends View {
    public FadedView(Context context) {
        this(context, null ,0);
    }

    public FadedView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FadedView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();

    }

    private Bitmap bitmap;

    private void init() {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save(Canvas.CLIP_SAVE_FLAG);
        canvas.clipRect(0, 0, getMeasuredWidth() * phase, getHeight());
        canvas.drawBitmap(bitmap, 0, 0, null);
        canvas.restore();
    }

    private float phase;

    public void setPhase(float phase) {
        this.phase = phase;
        invalidate();
    }

    public void showWithAnimation(int duration){
        ObjectAnimator.ofFloat(this, "phase", 0f, 1f)
                .setDuration(duration)
                .start();
    }
}
















