package cn.fu.airHero.entity;

import cn.fu.airHero.GameView;
import cn.fu.airHero.manager.PlayerBulletManager;
import android.R.integer;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;

public class Player
{
	private Bitmap playerMap = null;
	public int x=0,y=0;
	public int selfWidth=0, selfHeigh=0;
	public int centerX = 0, centerY = 0;
	private int fireIndex = 0;
	private View view = null;
	public boolean flg = false;
	public Player(View view, Bitmap playerMap)
	{
		this.playerMap = playerMap;
		this.view = view;
		selfWidth = playerMap.getWidth();
		selfHeigh = playerMap.getHeight();
		init();
	}
	public void init()
	{
		flg = true;
		centerX = view.getWidth()/2;
		centerY = view.getHeight() - playerMap.getHeight()/2;
		y = view.getHeight()-playerMap.getHeight();
		x = view.getWidth()/2 - playerMap.getWidth()/2;
	}
	public void drawSelf(Canvas canvas)
	{
		if (flg)
		canvas.drawBitmap(playerMap, x, y, null);
		else
		{
			init();
			canvas.drawBitmap(playerMap, x, y, null);
		}
	
	}
	public void move(Point point)
	{
		centerX = point.x;
		centerY = point.y-playerMap.getHeight()/2;
		x = point.x - playerMap.getWidth()/2;
		y = point.y - playerMap.getHeight();
	}
	public Point getPoint()
	{
		Point point = new Point(x,y);
		return point;
	}
	public void fire(PlayerBulletManager playerBulletManager)
	{
		fireIndex ++;
		if (fireIndex == 5)
		{
			fireIndex = 0;
			playerBulletManager.newOneBullet(new Point(centerX,centerY));	
		}
		
	}

}
