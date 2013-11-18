package cn.fu.airHero.entity;

import java.util.ArrayList;

import android.R.integer;
import android.R.xml;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

public class Explor
{
	private ArrayList<Bitmap> maps = null;
	public boolean flg = false;
	public int x=0,y=0;
	public int selfWidth=0, selfHeight=0;
	private int cnt = 0;
	public Explor(ArrayList<Bitmap> maps)
	{
		this.maps = maps;
		selfWidth = maps.get(0).getWidth();
		selfHeight = maps.get(0).getHeight();
	}
	public void drawSelf(Canvas canvas)
	{
		canvas.drawBitmap(maps.get(cnt), x-selfWidth/2, y-selfHeight/2, null);
		cnt++;
		if (maps.size() == cnt)
		{
			flg = false;
			cnt = 0;
		}
	}
}
