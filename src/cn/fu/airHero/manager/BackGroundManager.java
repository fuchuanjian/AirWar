package cn.fu.airHero.manager;

import cn.fu.airHero.R;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

public class BackGroundManager
{
	private Bitmap backMap = null;
	private int width = 0, height = 0;
	private int viewWidth = 0, viewHeight = 0;
	private Rect srcMapRect = null;
	private Rect rect1 = null;
	private Rect rect2 = null;
	private int y1 = 0,y2 = 0;
	public BackGroundManager(View view)
	{
		backMap = BitmapFactory.decodeResource(view.getResources(), R.drawable.background1);
		width = backMap.getWidth();
		height = backMap.getHeight();
		viewWidth = view.getWidth();
		viewHeight = view.getHeight();
		y2 = -viewHeight;
		srcMapRect = new Rect(0, 0, width, height);
		rect1 = new Rect(0,y1,viewWidth,viewHeight+y1);
		rect2 = new Rect(0, y2, viewWidth, viewHeight+y2);
	}
	public void drawBackGround(Canvas canvas)
	{
		rect1.set(0,y1,viewWidth,viewHeight+y1);
		rect2.set(0, y2, viewWidth, viewHeight+y2);
		canvas.drawBitmap(backMap, srcMapRect,rect1, null);
		canvas.drawBitmap(backMap, srcMapRect,rect2, null);
		
		y1 += 3;
		y2 += 3;
		
		if (y1 >= viewHeight)
			y1 -= viewHeight*2;
		
		if (y2 >= viewHeight)
			y2 -= viewHeight*2;	
	}
}
