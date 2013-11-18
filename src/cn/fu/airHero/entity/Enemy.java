package cn.fu.airHero.entity;

import java.util.Random;

import cn.fu.airHero.manager.EnemyBulletManager;

import android.R.integer;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;

public class Enemy
{
	private Bitmap enemyMap = null;
	private int fireIndex = 0;
	public int x=0,y=0;
	public int selfWidth=0,selfHeigh=0;
	public int centerX = 0, centerY = 0;
	private int viewWidth = 0, viewHeight = 0;
	public boolean flg = false;
	public Enemy(View view, Bitmap enemyMap)
	{
		this.enemyMap = enemyMap;
		viewWidth = view.getWidth();
		viewHeight = view.getHeight();
		selfWidth = enemyMap.getWidth();
		selfHeigh = enemyMap.getHeight();
		init();				
	}
	private void init()
	{
		fireIndex = new Random().nextInt(30);
		x = new Random().nextInt(viewWidth);
		y = new Random().nextInt(50)-50-selfHeigh;
		centerX = x + selfWidth/2;
		centerY = y + selfHeigh/2; 
		flg = true;
	}
	public void drawSelf(Canvas canvas)
	{
		if(flg)
		   canvas.drawBitmap(enemyMap, x, y, null);
		else
		{
			init();
			canvas.drawBitmap(enemyMap, x, y, null);
		}
	}
	public void fire(EnemyBulletManager enemyBulletManager)
	{
		fireIndex ++;
		if (fireIndex == 30)
		{
			fireIndex = 0;
			enemyBulletManager.newOneBullet(new Point(centerX,centerY));	
		}
		
		
	}
	public void move(Point point)
	{
		if (x<0-selfWidth || x>viewWidth || y>viewHeight)
		{
			init();
			return;
		}	
		int dx = new Random().nextInt(7);
		int dy = new Random().nextInt(2)+4;
		y += dy;
	
			//朝着玩家运动
			if (x > point.x + 3)
			{
				x -= dx;
			}		
			else  if (x  < point.x -3)
			{
				x += dx;
			}
			centerX = x + selfWidth/2;
			centerY = y + selfHeigh/2; 	
		
	}
}
