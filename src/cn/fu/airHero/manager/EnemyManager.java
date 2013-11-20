package cn.fu.airHero.manager;

import java.util.ArrayList;

import cn.fu.airHero.R;
import cn.fu.airHero.R.drawable;
import cn.fu.airHero.entity.Enemy;

import android.R.integer;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;

public class EnemyManager
{
	private Bitmap enemybBitmap = null;
	private ArrayList<Enemy> enemies = null;
	private View view = null;
	public EnemyManager(View view)
	{
		this.view = view;
		enemybBitmap = BitmapFactory.decodeResource(view.getResources(), R.drawable.e5);
		enemies = new ArrayList<Enemy>();
		MakeEnemyNum(5);
		
	}
	public void MakeEnemyNum(int n)
	{
		for (int i=0; i<n; i++)
			enemies.add(new Enemy(view, enemybBitmap));
	}
	
	public void drawEnemies(Canvas canvas, Point playerPoint, EnemyBulletManager enemyBulletManager)
	{
		for (Enemy enemy: enemies)
		{
			enemy.drawSelf(canvas);
			enemy.move(playerPoint);
			enemy.fire(enemyBulletManager);
		}
	}
	public ArrayList<Enemy> getEnemyArray()
	{
		return enemies;
	}
	public void release()
	{
		if (enemybBitmap != null && !enemybBitmap.isRecycled())
		{
			enemybBitmap.recycle();
			enemybBitmap = null;
		}
		
	}
}
