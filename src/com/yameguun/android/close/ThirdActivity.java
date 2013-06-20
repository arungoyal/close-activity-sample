package com.yameguun.android.close;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ThirdActivity extends BaseActivity {
	
	private int no = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		LinearLayout layout = (LinearLayout) this.findViewById(R.id.back);
		layout.setBackgroundColor(getRandomColor());
		
		// ボタンを無効にする
		Button button = (Button) layout.findViewById(R.id.btn);
		button.setEnabled(false);
		
		// テキスト
		no = getIntent().getIntExtra("page", 1);
		TextView pageView = (TextView) layout.findViewById(R.id.text);
		pageView.setText(String.valueOf(no));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		close(); // 全てのアクティビティを閉じます
		return false;
	}
}
