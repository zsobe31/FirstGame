package com.zsobe31.firstgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class GameView extends View {

    private Paint paintBg;
    private Paint paintLine;
    private Paint paintCircle;

    /* erinteses koordinatak begyujtese
    private PointF pointF = new PointF(0,0);
    */
    // lista, ami gyujti az erintes koordinatajit
    private List<PointF> circles = new ArrayList<PointF>();

    // egyedi vaszon letrehozasa
    public GameView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);

        // negyzet-teglalap letrehozasa
        paintBg = new Paint();
        paintBg.setColor(Color.BLACK);
        paintBg.setStyle(Paint.Style.FILL);

        // vonal letrehozasa
        paintLine = new Paint();
        paintLine.setColor(Color.WHITE);
        paintLine.setStyle(Paint.Style.STROKE);
        paintLine.setStrokeWidth(5);

        // kor lerajzolasa
        paintCircle = new Paint();
        paintCircle.setColor(Color.YELLOW);
        paintCircle.setStyle(Paint.Style.FILL);
    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        // negyzet kirajzolasa
        canvas.drawRect(0,0, getWidth(), getHeight(), paintBg);

        // atlos vonal lerajzolasa
        canvas.drawLine(0,0, getWidth(), getHeight(), paintLine);

        // kor rajzolas
        // canvas.drawCircle(pointF.x, pointF.y, 70, paintLine);

        // a korok rajzolasa
        for (PointF circle : circles) {
            canvas.drawCircle(circle.x, circle.y, 70, paintCircle);
        }

    }

    // ahova kattintok jelenjen meg egy karika
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        // amikor ranyomunk a kijelzore
        if(event.getAction() == MotionEvent.ACTION_DOWN){       // ACTION_MOVE -> az uj mozgatasara a kor kovetei
            // a koordinatak begyujtese, egy kor rajzolasa
            // pointF.set(event.getX(), event.getY());

            // tobb kor rajzolasa, megmaradnak az elozoleg erintett korok
            circles.add(new PointF(event.getX(), event.getY()));

            // feltetel vizsgalata, 5 kor utan
            if (circles.size() == 5) {
                ((MainActivity)getContext()).changeText("Elérted az 5 kört!");
            }

            // a terulet ujrarajzolasa
            invalidate();
        }

        return super.onTouchEvent(event);                       // ACTION_MOVE -> return true
    }

    // fuggveny a korok torlesera
    public void clearGameView(){
        circles.clear();
        invalidate();
    }
}
