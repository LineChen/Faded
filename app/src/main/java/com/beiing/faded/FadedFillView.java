package com.beiing.faded;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by chenliu on 2016/9/12.<br/>
 * 描述：
 * </br>
 */
public class FadedFillView extends View {
    private float phase;

    Path path;

    Paint paint;


    // 起始点
    private static final int[] START_POINT = new int[] {
            450, 320
    };
    // 爱心下端点
    private static final int[] BOTTOM_POINT = new int[] {
            450, 600
    };
    // 左侧控制点
    private static final int[] LEFT_CONTROL_POINT = new int[] {
            800, 200
    };
    // 右侧控制点
    private static final int[] RIGHT_CONTROL_POINT = new int[] {
            100, 200
    };

    public FadedFillView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        paint.setColor(Color.RED);

        path = new Path();
        path.moveTo(START_POINT[0], START_POINT[1]);
        path.quadTo(RIGHT_CONTROL_POINT[0], RIGHT_CONTROL_POINT[1], BOTTOM_POINT[0],
                BOTTOM_POINT[1]);
        path.quadTo(LEFT_CONTROL_POINT[0], LEFT_CONTROL_POINT[1], START_POINT[0], START_POINT[1]);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(path != null){
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawPath(path, paint);

            canvas.save(Canvas.CLIP_SAVE_FLAG);
            canvas.clipRect(0, (1 - phase) * getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight());
            paint.setStyle(Paint.Style.FILL);
            canvas.drawPath(path, paint);
            canvas.restore();
        }
    }


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











