package com.yameguun.android.close;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends BaseActivity {
	
	private int no = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		LinearLayout layout = (LinearLayout) this.findViewById(R.id.back);
		layout.setBackgroundColor(getRandomColor());

		// ボタン
		Button button = (Button) layout.findViewById(R.id.btn);
		button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View view) {
				Intent intent = new Intent();
				intent.putExtra("page", no + 1);
				intent.setClassName(MainActivity.this,SecondActivity.class.getName());
				startActivity(intent);
			}
		});
		
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
