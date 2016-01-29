package com.lym;

import com.lym.utils.ActivityUtils;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private ActivityUtils au;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		au = ActivityUtils.getInstance();
		au.addAnimation(android.R.anim.slide_in_left,
				android.R.anim.slide_out_right, android.R.anim.slide_in_left,
				android.R.anim.slide_out_right);
		
		Button btnNext = (Button) findViewById(R.id.btn_next);
		btnNext.setText("µÚÒ»Ò³");
	}

	public void click(View view) {
		au.startActivity(this, Activity1.class);
	}
}
