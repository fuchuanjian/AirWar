package cn.fu.airHero.manager;

import java.util.Random;

import cn.fu.airHero.R;
import cn.fu.airHero.R.drawable;
import cn.fu.airHero.entity.Player;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;

public class PlayerManager
{
	private Player player = null;
	private Bitmap playerMap = null;
	public PlayerManager(View view)
	{
		playerMap = BitmapFactory.decodeResource(view.getResources(), R.drawable.player1);
		player = new Player(view,playerMap);
	}
	public void drawPlayer(Canvas canvas,PlayerBulletManager playerBulletManager)
	{
		player.drawSelf(canvas);
		player.fire(playerBulletManager);

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
}
