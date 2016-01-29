package com.lym;

import com.lym.utils.ActivityUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity2 extends Activity {
	private ActivityUtils au;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		au = ActivityUtils.getInstance();

		findViewById(R.id.exit).setVisibility(View.VISIBLE);

		Button btnNext = (Button) findViewById(R.id.btn_next);
		btnNext.setText("第三页");

		Intent intent = getIntent();

		byte bu = 5;
		String stringExtra = intent.getStringExtra("string");
		int ints = intent.getIntExtra("int", -1);
		float f = intent.getFloatExtra("float", 0.0f);
		double d = intent.getDoubleExtra("double", -110.0);
		byte b = intent.getByteExtra("byte", bu);

		System.out.println(stringExtra);
		System.out.println(ints);
		System.out.println(f);
		System.out.println(d);
		System.out.println(b);
	}

	public void click(View view) {
		Button btn = ((Button) view);
		btn.setText("第二页");
	}

	public void exit(View view) {
		au.exitApp(this);
		// au.clearTack(this);
		// au.startActivity(this, MainActivity.class);
		// au.finish(this);
	}
}
