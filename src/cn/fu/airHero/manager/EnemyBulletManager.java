package cn.fu.airHero.manager;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;
import cn.fu.airHero.R;
import cn.fu.airHero.entity.EnemyBullet;
import cn.fu.airHero.entity.PlayerBullet;

public class EnemyBulletManager
{
	private ArrayList<EnemyBullet> enemyBulletsList  = null;
	private Bitmap enemyBulletMap = null;
	private View view = null;
	public EnemyBulletManager(View view)
	{
		this.view = view;
		enemyBulletMap = BitmapFactory.decodeResource(view.getResources(), R.drawable.bullet3);
		enemyBulletsList = new ArrayList<EnemyBullet>();
        makeBulletNum(100);
       
	}
	private void makeBulletNum(int n)
	{
		 for (int i = 0; i < n; i++)
		 {
			 enemyBulletsList.add(new EnemyBullet(view,enemyBulletMap));
		 }
	}
	
	public void newOneBullet(Point point)
	{
		for (EnemyBullet bullet : enemyBulletsList)
		{
			if(bullet.flg == false)
			{
				bullet.flg = true;
				bullet.centerX = point.x;
				bullet.centerY = point.y;
				break;
			}
		}
	
	}
	
	public void drawAllBullet(Canvas canvas)
	{
		for (EnemyBullet bullet : enemyBulletsList)
		{
			if(bullet.flg)
			{
				bullet.drawBulletSelf(canvas);
				bullet.centerY += 8;
			}
		}
	}
	public ArrayList<EnemyBullet> getBulletArray()
	{
		return enemyBulletsList;
	}
	
}
