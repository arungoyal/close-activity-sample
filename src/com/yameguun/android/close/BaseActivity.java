package com.yameguun.android.close;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;

public class BaseActivity extends Activity {
	
	public static final String FINISH_FILTER = "com.yameguun.android.FINISH_FILTER";
	private createReceiver receiver = new createReceiver();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// タイトル非表示
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		IntentFilter filter = new IntentFilter();
		filter.addAction(FINISH_FILTER);
		registerReceiver(receiver, filter);
	}
	
	@Override
    protected void onDestroy() {
    	super.onDestroy();
    	unregisterReceiver(receiver);
	}
	
	/**
	 * Activityを閉じる
	 */
	protected void close(){
		sendBroadcast(new Intent(FINISH_FILTER));
	}
	
	public class createReceiver extends BroadcastReceiver{
		@Override
		public void onReceive(Context con, Intent intent) {
			if(intent.getAction().equals(FINISH_FILTER)){
				finish();
			}
		}
	}
	
	/**
	 * ランダムな色を返す
	 * @return
	 */
	protected int getRandomColor(){
		int r =(int)(Math.random()*256);
	    int g =(int)(Math.random()*256);
	    int b =(int)(Math.random()*256);
	    return Color.rgb(r,g,b);
	}
}
