package cn.fu.airHero.manager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;
import cn.fu.airHero.GameView;
import cn.fu.airHero.R;
import cn.fu.airHero.entity.Player;

public class PlayerManager
{
	private int score = 0;
	private int flood = 1;
	private Player player = null;
	private Bitmap playerMap = null;
	private View gameView = null;
	private Paint paint = new Paint();
	public PlayerManager(View view)
	{
		gameView = view;
		paint.setColor(Color.RED);
		paint.setFakeBoldText(true);
		paint.setTextSize(40);
		playerMap = BitmapFactory.decodeResource(view.getResources(), R.drawable.player1);
		player = new Player(view,playerMap);
	}
	public void drawPlayer(Canvas canvas,PlayerBulletManager playerBulletManager)
	{
		player.drawSelf(canvas);
		player.fire(playerBulletManager);
		canvas.drawText("Scroe: "+ score, 10 ,40, paint);
		canvas.drawText("Flood: "+flood, 10, gameView.getHeight()-40, paint);

	}
	public void playermove(Point point)
	{
		player.move(point);
	}
	public Point getPlayPoint()
	{
		return player.getPoint();
	}
	public Player getPlayer()
	{
		return player;
	}
	public void addScore()
	{
		score ++;
	}
	public int getScore()
	{
		return score;
	}
	public void musFlood()
	{
		flood--;
	}
	public int getFlood()
	{
		return flood;
	}
	public void release()
	{
		if (playerMap != null && !playerMap.isRecycled())
		{
			playerMap.recycle();
			playerMap = null;
		}
		
	}
}
