package cn.fu.airHero.manager;

import java.util.ArrayList;

import cn.fu.airHero.entity.Explor;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;

public class ExplorManger
{
  private ArrayList<Bitmap> maps = new ArrayList<Bitmap>();	
  private ArrayList<Explor> explorList = new ArrayList<Explor>();
  private View  view = null;
  public ExplorManger(View view)
  {   this.view = view;
  	  maps.clear();
	  makeMaps(4);
	  makeExplorNum(6);
	 
  }

private void makeMaps(int n)
  {
	  for (int i=1; i<=n; i++)
	  {
		  int id = view.getResources().getIdentifier("bomb_"+i, "drawable", view.getContext().getPackageName());
		  Bitmap bitmap = BitmapFactory.decodeResource(view.getResources(), id);
		  maps.add(bitmap);
	  }
  }
private void makeExplorNum(int n)
{
	  for (int i=1; i<=n; i++)
	  {
		 Explor explor = new Explor(maps);
		 explorList.add(explor);
	  }
}
 public void makeExplorPoiont(Point point)
 {
	 for (Explor explor : explorList)
	{
		if(explor.flg == false)
		{
			explor.flg = true;
			explor.x = point.x;
			explor.y = point.y;
			break;
		}
	}
 }
 public void drawExplors(Canvas canvas)
 {
	 for (Explor explor : explorList)
	{
		if (explor.flg)
		{
			explor.drawSelf(canvas);
		}
	}
 }

public void release()
{
	for (Bitmap bm : maps)
	{
		if (!bm.isRecycled())
		{
			bm.recycle();
		}
	}
	maps.clear();
	
}
 
  
}
