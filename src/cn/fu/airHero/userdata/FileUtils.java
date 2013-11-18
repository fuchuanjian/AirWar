package cn.fu.airHero.userdata;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtils
{

	public void saveFile(String data)
	{
		// TODO Auto-generated method stub
		
	}
	public String readFile(InputStream inStream) throws IOException
	{
		ByteArrayOutputStream tempStream = new ByteArrayOutputStream();
		byte buff[] = new byte[1024];
		int len ;
		while ((len=inStream.read(buff)) !=-1 )
		{
			tempStream.write(buff,0,len);					
		}
		byte data[] = tempStream.toByteArray();
		tempStream.close();
		inStream.close();
		return new String(data);
	}
	
}
