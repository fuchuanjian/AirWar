package cn.fu.airHero.entity;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

public class PlayerBullet
{
	public boolean flg;
	public int x = 0, y = 0;
	public int selfWidth=0, selfHeigh=0;
	private View view = null;
	private Bitmap bitmap = null;
	public int centerX = 0, centerY=0;
	public PlayerBullet(View view, Bitmap bitmap)
	{
		flg = false;
		this.view = view;
		this.bitmap = bitmap;
		selfWidth = bitmap.getWidth();
		selfHeigh = bitmap.getHeight();
	}
	
	public void drawBulletSelf(Canvas canvas)
	{
		if (centerY < 0 )
		{
			flg = false;
		}
		else
		{	
			x = centerX - selfWidth/2;
			y = centerY - selfHeigh/2;
			canvas.drawBitmap(bitmap, x, y, null);
		}
		
	}
}
