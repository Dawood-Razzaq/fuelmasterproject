package com.example.fuelmasterproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.core.content.ContextCompat;

public class HourlySalesView extends View {

    private Paint paintPetrol;
    private Paint paintDiesel;
    private Paint paintText;
    private final String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Today"};
    private final float[] petrolValues = {65f, 75f, 60f, 85f, 70f, 95f, 80f};
    private final float[] dieselValues = {45f, 55f, 40f, 65f, 50f, 75f, 60f};

    public HourlySalesView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paintPetrol = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintPetrol.setColor(ContextCompat.getColor(getContext(), R.color.primary_blue));

        paintDiesel = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintDiesel.setColor(ContextCompat.getColor(getContext(), R.color.success));

        paintText = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintText.setColor(ContextCompat.getColor(getContext(), R.color.text_secondary));
        paintText.setTextSize(28f);
        paintText.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight() - 50;
        int n = days.length;
        float groupWidth = (float) width / n;
        float barWidth = groupWidth * 0.35f;

        for (int i = 0; i < n; i++) {
            float groupLeft = i * groupWidth + groupWidth * 0.15f;

            float pHeight = (petrolValues[i] / 100f) * (height - 20);
            float pTop = height - pHeight;
            canvas.drawRect(groupLeft, pTop, groupLeft + barWidth, height, paintPetrol);

            float dHeight = (dieselValues[i] / 100f) * (height - 20);
            float dTop = height - dHeight;
            canvas.drawRect(groupLeft + barWidth + 4f, dTop, groupLeft + (barWidth * 2) + 4f, height, paintDiesel);

            canvas.drawText(days[i], groupLeft + barWidth + 2f, height + 35f, paintText);
        }
    }
}
