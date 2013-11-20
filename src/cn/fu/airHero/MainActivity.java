package cn.fu.airHero;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import cn.fu.airHero.userdata.UserInfo;

public class MainActivity extends Activity {
    private GameView gameView = null;
    private String playerName = null;
    public  ArrayList<UserInfo> users = new ArrayList<UserInfo>();
    private Spinner spinner = null;
    private EditText editText = null;
    private Button btnStart = null;
    private Button btnQuit = null;
    private Object[] userInfoList = null;
    private boolean flg = false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new GameView(this);
//        setContentView(R.layout.main);
        setContentView(gameView);
//        editText =(EditText) findViewById(R.id.editText1);
//        btnStart = (Button) findViewById(R.id.button1);
//        btnQuit = (Button) findViewById(R.id.button2);
//        btnStart.setOnClickListener(doThing);
//        btnQuit.setOnClickListener(doThing);
//        spinner = (Spinner)findViewById(R.id.spinner);
  
//        int len = users.size();
//        String userString[] = new String[len];
//        userInfoList = new Object[len];
//        userInfoList = (Object[])users.toArray();
//        for (int i=0; i<len; i++)
//        {
//        	userString[i] = ((UserInfo)userInfoList[i]).toString();
//        }
//    
//        //String userString[] = (String[])users.toArray();
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, userString);
//        adapter.setDropDownViewResource(android.R.layout. simple_spinner_dropdown_item );
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(doThing1);
    } 
    private  OnItemSelectedListener doThing1 = new OnItemSelectedListener()
	{

		public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
		{
			editText.setText(((UserInfo)userInfoList[position]).getName());	
		}

		public void onNothingSelected(AdapterView<?> parent)
		{
			
		}
	};
	
	@Override
	protected void onPause()
	{
		super.onPause();
	};
	
	@Override
	protected void onResume()
	{
		super.onResume();
	}
	
    @Override
    protected void onDestroy()
    {
    	if (playerName != null)
    	{
    	}
    	gameView.onDestroy();
    	 super.onDestroy();
    	 
    	 android.os.Process.killProcess(android.os.Process.myPid());
         System.exit(0);

    } 
   	private OnClickListener doThing = new OnClickListener()
	{		
		public void onClick(View v)
		{
			switch (v.getId())
			{
			case R.id.button1:
				if(editText.getText().toString().equals(""))
				{
				   Toast.makeText(MainActivity.this,"Enter your Name",1).show();
				}
				else 
				{
					playerName = editText.getText().toString();
					setContentView(gameView);
				}
				break;
			case R.id.button2:
				finish();
				break;
			default:
				break;
			}
			
		}
	};
	
	@Override
    public boolean onTouchEvent(MotionEvent event)
    {
    	gameView.onTouchEvent(event);
    	return super.onTouchEvent(event);
    }
}