package com.g.tst;

import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Paint;
import android.graphics.Path.Direction;
import android.graphics.Color;

public class PuzzleView extends View {
	
    private static final String QUOTE = "Now is the time for all ";
    //+
      		//"good men to come to the aid of their country." +
      		//"good men to come to the aid of their country.";

	private final Path circle;
	private final Paint cPaint;
	private final Paint tPaint;

	public PuzzleView(Context context) {
		super(context);

        // Color examples
        
        int color = Color.BLUE; // solid blue
        
        
        // Translucent purple
        color = Color.argb(127, 255, 0, 255);
        
        
        //color = getResources().getColor(R.color.mycolor);
        

        
        circle = new Path();
        circle.addCircle(120, 150, 100, Direction.CW);
        //circle.addCircle(150, 250, 200, Direction.CW);
        

        cPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        cPaint.setStyle(Paint.Style.STROKE);

        cPaint.setColor(Color.LTGRAY);
        
        cPaint.setStrokeWidth(3);

        tPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        tPaint.setStyle(Paint.Style.FILL);//FILL_AND_STROKE
        tPaint.setColor(Color.BLACK);
        tPaint.setTextSize(20f);
        //tPaint.setTextSize(40f);
        tPaint.setStrokeWidth(1);

        setBackgroundColor(Color.WHITE);
        
        //setBackgroundResource(R.drawable.background);
        
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		canvas.drawText(QUOTE, 0, 40, tPaint);
		canvas.drawPath(circle, cPaint);
		canvas.drawTextOnPath(QUOTE, circle, 0, 20, tPaint);
	}

}
