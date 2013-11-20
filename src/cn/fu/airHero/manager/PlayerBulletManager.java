package cn.fu.airHero.manager;

import java.util.ArrayList;

import android.R.integer;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;
import cn.fu.airHero.R;
import cn.fu.airHero.entity.PlayerBullet;

public class PlayerBulletManager
{
	private ArrayList<PlayerBullet> pBulletsList  = null;
	private Bitmap playerBulletMap = null;
	private View view = null;
	public PlayerBulletManager(View view)
	{
		this.view = view;
		playerBulletMap = BitmapFactory.decodeResource(view.getResources(), R.drawable.bullet1);
        pBulletsList = new ArrayList<PlayerBullet>();
        makeBulletNum(100);
       
	}
	private void makeBulletNum(int n)
	{
		 for (int i = 0; i < n; i++)
		 {
			 pBulletsList.add(new PlayerBullet(view,playerBulletMap));
		 }
	}
	
	public void newOneBullet(Point point)
	{
		for (PlayerBullet bullet : pBulletsList)
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
		for (PlayerBullet bullet : pBulletsList)
		{
			if(bullet.flg)
			{
				bullet.drawBulletSelf(canvas);
				bullet.centerY -= 15;
			}
		}
	}
	public ArrayList<PlayerBullet> getBulletArray()
	{
		return pBulletsList;
	}

	public void release()
	{
		if (playerBulletMap != null && !playerBulletMap.isRecycled())
		{
			playerBulletMap.recycle();
			playerBulletMap = null;
		}
	}
	
	
}
