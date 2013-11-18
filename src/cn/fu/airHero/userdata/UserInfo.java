package cn.fu.airHero.userdata;


public  class UserInfo implements Comparable
{	
	private String name;
	private int score;
	public UserInfo(String name, int score)
	{
		this.name = name;
		this.score = score;
	}
	
	
	public String getName()
	{
		return name;
	}


	public void setName(String name)
	{
		this.name = name;
	}


	public int getScore()
	{
		return score;
	}


	public void setScore(int score)
	{
		this.score = score;
	}


	@Override
	public String toString()
	{
		
		return name+"    score:"+score;
	}


	public int compareTo(Object another)
	{
		UserInfo x = (UserInfo)another;
		return this.getScore()-x.getScore();
	}

}