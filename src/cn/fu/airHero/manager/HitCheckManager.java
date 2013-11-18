package cn.fu.airHero.manager;

import java.util.ArrayList;

import android.graphics.Point;

import cn.fu.airHero.GameView;
import cn.fu.airHero.entity.Enemy;
import cn.fu.airHero.entity.EnemyBullet;
import cn.fu.airHero.entity.Player;
import cn.fu.airHero.entity.PlayerBullet;

public class HitCheckManager
{
	private ArrayList<PlayerBullet> playerBulletList = null;
	private ArrayList<Enemy> enemies = null;
	private ArrayList<EnemyBullet> enemyBulletList = null;
	private Player player = null;
	private ExplorManger explorManger;
	public void checkHit(PlayerManager playerManager, PlayerBulletManager playerBulletManager, EnemyManager enemyManager, EnemyBulletManager enemyBulletManager, ExplorManger explorManger)
	{
		this.explorManger = explorManger;
		checkPlayerBullet(playerBulletManager, enemyManager);
		checkEnemyBullet(enemyBulletManager, playerManager);
	}
	
	public void checkPlayerBullet(PlayerBulletManager playerBulletManager, EnemyManager enemyManager)
	{
		playerBulletList = playerBulletManager.getBulletArray();
		enemies = enemyManager.getEnemyArray();
		for (Enemy enemy : enemies)
		{
			for (PlayerBullet bullet : playerBulletList)
			{
				if (bullet.flg)
				{
					if(bullet.x<(enemy.x+enemy.selfWidth) && bullet.y<(enemy.y+enemy.selfHeigh) && enemy.x<(bullet.x+bullet.selfWidth) && enemy.y<(bullet.y+bullet.selfHeigh))
					{
						bullet.flg = false;
						enemy.flg = false;
						Player.score += 1;//ตรทึ
						explorManger.makeExplorPoiont(new Point(enemy.centerX, enemy.centerY));
					}
				}
			}
		}
	}
	public void checkEnemyBullet(EnemyBulletManager enemyBulletManager, PlayerManager playerManager)
	{
		enemyBulletList = enemyBulletManager.getBulletArray();
		player = playerManager.getPlayer();
		for (EnemyBullet bullet : enemyBulletList)
		{
			if (bullet.flg)
			{
				if(bullet.x<(player.x+player.selfWidth) && bullet.y<(player.y+player.selfHeigh) && player.x<(bullet.x+bullet.selfWidth) && player.y<(bullet.y+bullet.selfHeigh))
				{
					bullet.flg = false;
					player.flg = false;
					explorManger.makeExplorPoiont(new Point(player.centerX, player.centerY));
				}
			}
		}
		
	}
}
