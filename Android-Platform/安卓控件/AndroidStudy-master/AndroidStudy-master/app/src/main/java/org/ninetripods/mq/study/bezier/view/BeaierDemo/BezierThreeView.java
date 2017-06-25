package org.ninetripods.mq.study.bezier.view.BeaierDemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by MQ on 2017/1/17.
 */

public class BezierThreeView extends View {
    private Paint mPaint;
    private Paint textPaint;
    private Path mPath;
    private int mCenterX, mCenterY;
    private PointF dataPoint1, dataPoint2, controlPoint1, controlPoint2;
    private float radius = 8f;
    private float region_diff = 100f;

    public BezierThreeView(Context context) {
        this(context, null);
    }

    public BezierThreeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BezierThreeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        //初始化绘制贝塞尔曲线画笔
        mPaint = new Paint();
        mPaint.setDither(true);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(8f);
        mPaint.setColor(Color.RED);
        //初始化绘制辅助线和文字的画笔
        textPaint = new Paint();
        textPaint.setDither(true);
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setStrokeWidth(4f);
        textPaint.setColor(Color.GRAY);
        textPaint.setTextSize(40);
        //初始化路径
        mPath = new Path();
        //初始化数据点和控制点
        dataPoint1 = new PointF();
        dataPoint2 = new PointF();
        controlPoint1 = new PointF();
        controlPoint2 = new PointF();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mCenterX = w / 2;
        mCenterY = h / 2;
        //给数据点和控制点赋值
        dataPoint1.x = mCenterX - 300;
        dataPoint1.y = mCenterY;
        dataPoint2.x = mCenterX + 300;
        dataPoint2.y = mCenterY;
        controlPoint1.x = mCenterX - 300;
        controlPoint1.y = mCenterY - 300;
        controlPoint2.x = mCenterX + 300;
        controlPoint2.y = mCenterY - 300;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPath.reset();
        //绘制点
        canvas.drawCircle(dataPoint1.x, dataPoint1.y, radius, textPaint);
        canvas.drawCircle(dataPoint2.x, dataPoint2.y, radius, textPaint);
        canvas.drawCircle(controlPoint1.x, controlPoint1.y, radius, textPaint);
        canvas.drawCircle(controlPoint2.x, controlPoint2.y, radius, textPaint);
        //绘制文字
        canvas.drawText("数据点1", dataPoint1.x + 10, dataPoint1.y + 10, textPaint);
        canvas.drawText("数据点2", dataPoint2.x + 10, dataPoint2.y + 10, textPaint);
        canvas.drawText("控制点1", controlPoint1.x + 10, controlPoint1.y + 10, textPaint);
        canvas.drawText("控制点2", controlPoint2.x + 10, controlPoint2.y + 10, textPaint);
        //绘制辅助线
        canvas.drawLine(dataPoint1.x, dataPoint1.y, controlPoint1.x, controlPoint1.y, textPaint);
        canvas.drawLine(controlPoint1.x, controlPoint1.y, controlPoint2.x, controlPoint2.y, textPaint);
        canvas.drawLine(controlPoint2.x, controlPoint2.y, dataPoint2.x, dataPoint2.y, textPaint);
        //绘制三阶贝塞尔曲线
        mPath.moveTo(dataPoint1.x, dataPoint1.y);
        mPath.cubicTo(controlPoint1.x, controlPoint1.y, controlPoint2.x,
                controlPoint2.y, dataPoint2.x, dataPoint2.y);
        canvas.drawPath(mPath, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (isPointChoice(controlPoint1, event.getX(), event.getY())) {
            controlPoint1.x = event.getX();
            controlPoint1.y = event.getY();
            invalidate();
        } else if (isPointChoice(controlPoint2, event.getX(), event.getY())) {
            controlPoint2.x = event.getX();
            controlPoint2.y = event.getY();
            invalidate();
        }
        return true;
    }

    /**
     * 判断按下的区域（x,y）是否在点PointF附近的区域内
     *
     * @param p PointF
     * @param x event.getX()
     * @param y event.getY()
     * @return
     */
    private boolean isPointChoice(PointF p, float x, float y) {
        RectF mRectF = new RectF();
        mRectF.set(p.x - region_diff, p.y - region_diff, p.x + region_diff, p.y + region_diff);
        return mRectF.contains(x, y);
    }
}
