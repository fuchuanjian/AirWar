package cn.fu.airHero;

import cn.fu.airHero.entity.Player;
import cn.fu.airHero.manager.BackGroundManager;
import cn.fu.airHero.manager.EnemyBulletManager;
import cn.fu.airHero.manager.EnemyManager;
import cn.fu.airHero.manager.ExplorManger;
import cn.fu.airHero.manager.HitCheckManager;
import cn.fu.airHero.manager.PlayerBulletManager;
import cn.fu.airHero.manager.PlayerManager;
import android.R.integer;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class GameView extends SurfaceView implements SurfaceHolder.Callback, Runnable
{
	private SurfaceHolder sHolder = null;
	private Canvas canvas = null;
	private int viewWidth = 0, viewHeight = 0;
	private boolean isRunning = false;
	private BackGroundManager groundManager = null;
	private PlayerManager playerManager = null;
	private EnemyManager enemyManager = null;
	private Thread gamethread = null;
	private Point playerPoint = null;
	private PlayerBulletManager playerBulletManager = null;
	private EnemyBulletManager enemyBulletManager = null;
	private HitCheckManager hitCheckManager = null;
	private ExplorManger explorManger = null;
	public GameView(Context context)
	{
		super(context);	
		sHolder = this.getHolder();
		sHolder.addCallback(this);
		
	}
	public void surfaceCreated(SurfaceHolder holder)
	{
		viewHeight = this.getHeight();
		viewWidth = this.getWidth();
		isRunning = true;
		if (groundManager == null)
			groundManager = new BackGroundManager(this);
		if (playerManager == null)
			playerManager = new PlayerManager(this);
		if (enemyManager == null)
			enemyManager = new EnemyManager(this);
		if (playerBulletManager == null)
			playerBulletManager =  new PlayerBulletManager(this);	
		if (enemyBulletManager == null)
			enemyBulletManager = new EnemyBulletManager(this);
		if (hitCheckManager == null)
			hitCheckManager = new HitCheckManager();
		if (explorManger == null)
			explorManger = new ExplorManger(this);
	
		//	if (gamethread == null)
		gamethread = new Thread(this);
		gamethread.start();
		
	}
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
	{
	}
	public void surfaceDestroyed(SurfaceHolder holder)
	{
		isRunning = false;
		gamethread.interrupt();	
		Log.i("Fu","sufaceDestry");
	}
	public void run()
	{
		while(isRunning)
		{	
			if (sHolder != null)
			{
				canvas = sHolder.lockCanvas();
				if (canvas != null)
				{
					canvas.drawColor(Color.RED);
					canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG|Paint.FILTER_BITMAP_FLAG));
					
					groundManager.drawBackGround(canvas);
					
					playerManager.drawPlayer(canvas,playerBulletManager);
					playerBulletManager.drawAllBullet(canvas);
					
					playerPoint = playerManager.getPlayPoint();
					
					enemyManager.drawEnemies(canvas, playerPoint,enemyBulletManager);
					enemyBulletManager.drawAllBullet(canvas);
					hitCheckManager.checkHit(playerManager, playerBulletManager, enemyManager, enemyBulletManager, explorManger);//Åö×²¼ì²â
					
					explorManger.drawExplors(canvas);
					sHolder.unlockCanvasAndPost(canvas);
					if (Player.flood == 0)
					{
						isRunning = false;
						gamethread.interrupt();
						
					}
				}		
			}	
			try
			{
				Thread.sleep(50);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}	
	}
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		Point point = new Point((int)event.getX(), (int)event.getY()-40);
		playerManager.playermove(point);
		return super.onTouchEvent(event);
	}
	
}
